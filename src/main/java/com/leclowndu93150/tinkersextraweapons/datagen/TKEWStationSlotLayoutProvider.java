package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class TKEWStationSlotLayoutProvider extends AbstractStationSlotLayoutProvider {

    public TKEWStationSlotLayoutProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addLayouts() {
        defineModifiable(TKEWTools.PIKE)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 15, 60)
                .addInputItem(TinkerToolParts.toolHandle, 33, 42)
                .addInputItem(TinkerToolParts.toolHandle, 51, 24)
                .addInputItem(TinkerToolParts.smallBlade, 53, 6)
                .build();

        defineModifiable(TKEWTools.WARHAMMER)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 22, 53)
                .addInputItem(TinkerToolParts.toolBinding, 35, 35)
                .addInputItem(TinkerToolParts.hammerHead, 48, 20)
                .build();

        defineModifiable(TKEWTools.LANCE)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkerToolParts.toughHandle, 7, 62)
                .addInputItem(TinkerToolParts.largePlate, 25, 44)
                .addInputItem(TinkerToolParts.smallBlade, 43, 26)
                .addInputItem(TinkerToolParts.smallBlade, 53, 16)
                .build();

        defineModifiable(TKEWTools.GREATSWORD)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkerToolParts.toughHandle, 7, 62)
                .addInputItem(TinkerToolParts.toughHandle, 25, 44)
                .addInputItem(TinkerToolParts.broadBlade, 43, 26)
                .addInputItem(TinkerToolParts.broadBlade, 53, 16)
                .build();

        defineModifiable(TKEWTools.SICKLE)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 22, 53)
                .addInputItem(TinkerToolParts.smallBlade, 40, 35)
                .addInputItem(TinkerToolParts.smallBlade, 50, 20)
                .build();

        defineModifiable(TKEWTools.BOARDING_AXE)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 22, 53)
                .addInputItem(TinkerToolParts.smallAxeHead, 40, 35)
                .addInputItem(TinkerToolParts.smallBlade, 50, 20)
                .build();

        defineModifiable(TKEWTools.QUARTERSTAFF)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 15, 60)
                .addInputItem(TinkerToolParts.toolHandle, 51, 24)
                .addInputItem(TinkerToolParts.toughBinding, 33, 42)
                .build();

        defineModifiable(TKEWTools.PARRYING_DAGGER)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 22, 53)
                .addInputItem(TinkerToolParts.toolBinding, 35, 35)
                .addInputItem(TinkerToolParts.smallBlade, 48, 20)
                .build();
    }

    @Override
    public String getName() {
        return "Tinker's Extra Weapons Station Slot Layouts";
    }
}
