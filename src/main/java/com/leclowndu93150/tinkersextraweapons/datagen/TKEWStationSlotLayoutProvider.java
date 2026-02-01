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
                .addInputItem(TinkerToolParts.toolHandle, 12, 62)
                .addInputItem(TinkerToolParts.toolHandle, 30, 44)
                .addInputItem(TinkerToolParts.toolHandle, 48, 26)
                .addInputItem(TinkerToolParts.smallBlade, 66, 8)
                .build();

        defineModifiable(TKEWTools.WARHAMMER)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle,  15, 60)
                .addInputItem(TinkerToolParts.toolBinding, 33, 42)
                .addInputItem(TinkerToolParts.hammerHead,  53, 22)
                .build();

        defineModifiable(TKEWTools.LANCE)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkerToolParts.toughHandle,  7, 62)
                .addInputItem(TinkerToolParts.largePlate,  25, 46)
                .addInputItem(TinkerToolParts.smallBlade,  45, 26)
                .addInputItem(TinkerToolParts.smallBlade,  45, 46)
                .build();

        defineModifiable(TKEWTools.GREATSWORD)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkerToolParts.toughHandle,  7, 62)
                .addInputItem(TinkerToolParts.toughHandle, 25, 46)
                .addInputItem(TinkerToolParts.broadBlade,  45, 26)
                .addInputItem(TinkerToolParts.broadBlade,  45, 46)
                .build();

        defineModifiable(TKEWTools.SICKLE)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle, 22, 53)
                .addInputItem(TinkerToolParts.smallBlade, 31, 22)
                .addInputItem(TinkerToolParts.smallBlade, 51, 34)
                .build();

        defineModifiable(TKEWTools.BOARDING_AXE)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle,    22, 53)
                .addInputItem(TinkerToolParts.smallAxeHead,  31, 22)
                .addInputItem(TinkerToolParts.smallBlade,    51, 34)
                .build();

        defineModifiable(TKEWTools.QUARTERSTAFF)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle,   12, 62)
                .addInputItem(TinkerToolParts.toolHandle,   30, 44)
                .addInputItem(TinkerToolParts.toughBinding, 48, 26)
                .build();

        defineModifiable(TKEWTools.PARRYING_DAGGER)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.toolHandle,  15, 60)
                .addInputItem(TinkerToolParts.toolBinding, 33, 42)
                .addInputItem(TinkerToolParts.smallBlade,  53, 22)
                .build();
    }

    @Override
    public String getName() {
        return "Tinker's Extra Weapons Station Slot Layouts";
    }
}
