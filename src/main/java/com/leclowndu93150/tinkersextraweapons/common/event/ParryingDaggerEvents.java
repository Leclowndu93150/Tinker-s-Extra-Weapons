package com.leclowndu93150.tinkersextraweapons.common.event;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TKEWMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ParryingDaggerEvents {

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        LivingEntity defender = event.getEntity();
        ItemStack stack = defender.getUseItem();

        if (!stack.is(TKEWTools.PARRYING_DAGGER.get())) {
            return;
        }

        if (!stack.getItem().canPerformAction(stack, ToolActions.SHIELD_BLOCK)) {
            return;
        }

        DamageSource source = event.getDamageSource();
        boolean isMeleeAttack = source.is(DamageTypes.PLAYER_ATTACK) ||
                                source.is(DamageTypes.MOB_ATTACK) ||
                                source.is(DamageTypes.MOB_ATTACK_NO_AGGRO);

        if (!isMeleeAttack) {
            event.setCanceled(true);
            return;
        }

        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            livingAttacker.knockback(0.5f, defender.getX() - livingAttacker.getX(), defender.getZ() - livingAttacker.getZ());

            defender.level().playSound(null, defender.getX(), defender.getY(), defender.getZ(),
                SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 0.8f, 0.8f);
        }

        int itemDamage = 1 + Mth.floor(event.getBlockedDamage());
        if (defender instanceof Player player) {
            stack.hurtAndBreak(itemDamage, player, p -> p.broadcastBreakEvent(defender.getUsedItemHand()));
        }

        defender.stopUsingItem();
    }
}
