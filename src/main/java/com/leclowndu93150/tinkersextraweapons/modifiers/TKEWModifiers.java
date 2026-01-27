package com.leclowndu93150.tinkersextraweapons.modifiers;

import com.leclowndu93150.tinkersextraweapons.registry.TKEWModifierIds;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.ModifierManager;

public class TKEWModifiers {

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(TKEWModifiers::onModifierRegistration);
    }

    public static void onModifierRegistration(ModifierManager.ModifierRegistrationEvent event) {
        event.registerStatic(TKEWModifierIds.CAVALRY, new CavalryModifier());
        event.registerStatic(TKEWModifierIds.QUAKE, new QuakeModifier());
        event.registerStatic(TKEWModifierIds.SWORDBREAKER, new SwordbreakerModifier());
        event.registerStatic(TKEWModifierIds.ARMOR_BONUS, new ArmorBonusModifier(2f));
    }
}
