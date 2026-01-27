package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.registry.TKEWModifierIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;

public class TKEWModifierProvider extends AbstractModifierProvider {

    public TKEWModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return "Tinker's Extra Weapons Modifiers";
    }

    @Override
    protected void addModifiers() {
        buildModifier(TKEWModifierIds.CAVALRY);
        buildModifier(TKEWModifierIds.QUAKE);
        buildModifier(TKEWModifierIds.SWORDBREAKER);
    }
}
