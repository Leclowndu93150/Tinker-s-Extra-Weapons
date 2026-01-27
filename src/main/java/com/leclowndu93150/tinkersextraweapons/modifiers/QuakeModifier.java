package com.leclowndu93150.tinkersextraweapons.modifiers;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerTags.Items;
import slimeknights.tconstruct.common.network.TinkerNetwork;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolAttackUtil;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.modifiers.ability.sling.SlingModifier;

import java.util.List;

public class QuakeModifier extends SlingModifier {

    private static final float RADIUS = 4.0f;
    public static final ResourceLocation IS_QUAKING = TConstruct.getResource("is_quaking");

    @Override
    protected void registerHooks(Builder builder) {
        super.registerHooks(builder);
    }

    @Override
    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        if (!tool.isBroken() && source == InteractionSource.RIGHT_CLICK) {
            float speed = ConditionalStatModifierHook.getModifiedStat(tool, player, ToolStats.DRAW_SPEED);
            if (tool.hasTag(Items.MELEE_WEAPON)) {
                speed *= tool.getStats().get(ToolStats.ATTACK_SPEED);
            }
            tool.getPersistentData().putInt(GeneralInteractionModifierHook.KEY_DRAWTIME, (int) Math.ceil(30.0f / speed));
            GeneralInteractionModifierHook.startUsing(tool, modifier.getId(), player, hand);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void beforeReleaseUsing(IToolStackView tool, ModifierEntry modifier, LivingEntity entity, int useDuration, int timeLeft, ModifierEntry activeModifier) {
        if (entity.level().isClientSide || !(entity instanceof Player player)) {
            return;
        }

        float charge = getCharge(tool, modifier, timeLeft);
        if (charge <= 0.0f) {
            if (isActive(tool, modifier, activeModifier)) {
                entity.level().playSound(null, player.getX(), player.getY(), player.getZ(), Sounds.BONK.getSound(), player.getSoundSource(), 1.0f, 1.0f);
            }
            return;
        }

        AABB area = player.getBoundingBox().inflate(RADIUS);
        List<LivingEntity> targets = entity.level().getEntitiesOfClass(LivingEntity.class, area,
            e -> e != player && ToolAttackUtil.isAttackable(entity, e));

        if (targets.isEmpty()) {
            if (isActive(tool, modifier, activeModifier)) {
                entity.level().playSound(null, player.getX(), player.getY(), player.getZ(), Sounds.BONK.getSound(), player.getSoundSource(), 1.0f, 1.0f);
            }
            return;
        }

        InteractionHand hand = player.getUsedItemHand();
        float multiplier = charge * 3.0f;
        float force = getPower(tool, player) * multiplier;

        for (LivingEntity target : targets) {
            ToolAttackContext.Builder builder = ToolAttackContext.attacker(entity)
                .target(target)
                .hand(hand)
                .cooldown(Math.min(1.0f, charge))
                .extraAttack();

            if (hand == InteractionHand.MAIN_HAND) {
                builder.applyAttributes();
            } else {
                builder.toolAttributes(tool);
            }

            ToolAttackUtil.performAttack(tool, builder.build());

            Vec3 direction = target.position().subtract(player.position()).normalize();
            if (direction.lengthSqr() > 0) {
                target.knockback(force, -direction.x, -direction.z);
                if (target instanceof ServerPlayer serverPlayer) {
                    TinkerNetwork.getInstance().sendVanillaPacket(new ClientboundSetEntityMotionPacket(target), serverPlayer);
                }
            }
        }

        entity.level().playSound(null, player.getX(), player.getY(), player.getZ(), Sounds.BONK.getSound(), player.getSoundSource(), 1.0f, 0.5f);
        spawnExpandingRing((ServerLevel) entity.level(), player.getX(), player.getY() + 0.1, player.getZ(), RADIUS);
        player.causeFoodExhaustion(0.2f);
        player.getCooldowns().addCooldown(tool.getItem(), 40);
        ToolDamageUtil.damageAnimated(tool, 2, entity);
    }

    private void spawnExpandingRing(ServerLevel level, double centerX, double centerY, double centerZ, float maxRadius) {
        int rings = 8;
        int particlesPerRing = 24;

        for (int ring = 0; ring < rings; ring++) {
            float radius = (maxRadius / rings) * (ring + 1);
            float yOffset = ring * 0.05f;

            for (int i = 0; i < particlesPerRing; i++) {
                double angle = (2 * Math.PI / particlesPerRing) * i;
                double x = centerX + Math.cos(angle) * radius;
                double z = centerZ + Math.sin(angle) * radius;

                double outwardX = Math.cos(angle) * 0.1;
                double outwardZ = Math.sin(angle) * 0.1;

                level.sendParticles(ParticleTypes.CLOUD, x, centerY + yOffset, z, 1, outwardX, 0.02, outwardZ, 0.01);
            }
        }
    }
}
