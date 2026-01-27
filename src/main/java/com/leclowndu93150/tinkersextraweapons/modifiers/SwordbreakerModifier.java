package com.leclowndu93150.tinkersextraweapons.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class SwordbreakerModifier extends Modifier implements MeleeHitModifierHook {

    private static final int WEAKNESS_DURATION = 40;
    private static final int WEAKNESS_AMPLIFIER = 0;

    @Override
    protected void registerHooks(Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && damageDealt > 0) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, WEAKNESS_DURATION * modifier.getLevel(), WEAKNESS_AMPLIFIER));
        }
    }
}
