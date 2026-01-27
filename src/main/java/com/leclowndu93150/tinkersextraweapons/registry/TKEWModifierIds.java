package com.leclowndu93150.tinkersextraweapons.registry;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public final class TKEWModifierIds {

    private TKEWModifierIds() {}

    private static ModifierId id(String name) {
        return new ModifierId(TKEWMain.MODID, name);
    }

    public static final ModifierId CAVALRY = id("cavalry");
    public static final ModifierId QUAKE = id("quake");
    public static final ModifierId SWORDBREAKER = id("swordbreaker");
    public static final ModifierId REACH = new ModifierId("tconstruct", "reach");
    public static final ModifierId KNOCKBACK = new ModifierId("tconstruct", "knockback");
}
