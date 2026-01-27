package com.leclowndu93150.tinkersextraweapons.common.event;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TKEWMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ParryingDaggerEvents {

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        LivingEntity living = event.getEntity();
        ItemStack stack = living.getUseItem();
        if (!stack.is(TKEWTools.PARRYING_DAGGER.get())) {
            return;
        }
        if (!stack.getItem().canPerformAction(stack, ToolActions.SHIELD_BLOCK)) {
            return;
        }
        DamageSource source = event.getDamageSource();
        if (!source.is(DamageTypes.PLAYER_ATTACK) && !source.is(DamageTypes.MOB_ATTACK) && !source.is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {
            event.setCanceled(true);
        }
    }
}
