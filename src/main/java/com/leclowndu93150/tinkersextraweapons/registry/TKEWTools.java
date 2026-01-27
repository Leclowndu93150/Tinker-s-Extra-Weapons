package com.leclowndu93150.tinkersextraweapons.registry;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.common.item.weapon.ModifiableMeleeWeaponItem;
import com.leclowndu93150.tinkersextraweapons.common.item.weapon.ParryingDaggerItem;
import net.minecraft.world.item.Item;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;

public class TKEWTools {

    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(TKEWMain.MODID);

    private static final Item.Properties UNSTACKABLE = new Item.Properties().stacksTo(1);

    public static final ItemObject<ModifiableMeleeWeaponItem> PIKE = ITEMS.register(
            "pike", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.PIKE));

    public static final ItemObject<ModifiableMeleeWeaponItem> WARHAMMER = ITEMS.register(
            "warhammer", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.WARHAMMER));

    public static final ItemObject<ModifiableMeleeWeaponItem> SICKLE = ITEMS.register(
            "sickle", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.SICKLE));

    public static final ItemObject<ModifiableMeleeWeaponItem> BOARDING_AXE = ITEMS.register(
            "boarding_axe", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.BOARDING_AXE));

    public static final ItemObject<ModifiableMeleeWeaponItem> QUARTERSTAFF = ITEMS.register(
            "quarterstaff", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.QUARTERSTAFF));

    public static final ItemObject<ParryingDaggerItem> PARRYING_DAGGER = ITEMS.register(
            "parrying_dagger", () -> new ParryingDaggerItem(UNSTACKABLE, TKEWDefinitions.PARRYING_DAGGER));

    public static final ItemObject<ModifiableMeleeWeaponItem> LANCE = ITEMS.register(
            "lance", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.LANCE));

    public static final ItemObject<ModifiableMeleeWeaponItem> GREATSWORD = ITEMS.register(
            "greatsword", () -> new ModifiableMeleeWeaponItem(UNSTACKABLE, TKEWDefinitions.GREATSWORD));
}
