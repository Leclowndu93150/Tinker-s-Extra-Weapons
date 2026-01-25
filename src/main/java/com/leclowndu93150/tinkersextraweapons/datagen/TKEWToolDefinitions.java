package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWDefinitions;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWModifierIds;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.definition.module.build.MultiplyStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolSlotsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolTraitsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.IsEffectiveModule;
import slimeknights.tconstruct.library.tools.definition.module.weapon.SweepWeaponAttack;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import static slimeknights.tconstruct.tools.TinkerToolParts.broadBlade;
import static slimeknights.tconstruct.tools.TinkerToolParts.hammerHead;
import static slimeknights.tconstruct.tools.TinkerToolParts.largePlate;
import static slimeknights.tconstruct.tools.TinkerToolParts.smallAxeHead;
import static slimeknights.tconstruct.tools.TinkerToolParts.smallBlade;
import static slimeknights.tconstruct.tools.TinkerToolParts.toolBinding;
import static slimeknights.tconstruct.tools.TinkerToolParts.toolHandle;
import static slimeknights.tconstruct.tools.TinkerToolParts.toughBinding;
import static slimeknights.tconstruct.tools.TinkerToolParts.toughHandle;

public class TKEWToolDefinitions extends AbstractToolDefinitionDataProvider {

    public TKEWToolDefinitions(PackOutput packOutput) {
        super(packOutput, TKEWMain.MODID);
    }

    @Override
    protected void addToolDefinitions() {
        RandomMaterial tier1 = RandomMaterial.random().tier(1).build();
        DefaultMaterialsModule defaultThree = DefaultMaterialsModule.builder().material(tier1, tier1, tier1).build();
        DefaultMaterialsModule defaultFour = DefaultMaterialsModule.builder().material(tier1, tier1, tier1, tier1).build();

        define(TKEWDefinitions.PIKE)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(toolHandle)
                        .part(toolHandle)
                        .part(smallBlade).build())
                .module(defaultFour)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.6f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.6f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build());

        define(TKEWDefinitions.WARHAMMER)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(toolBinding)
                        .part(hammerHead).build())
                .module(defaultThree)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 10f)
                        .set(ToolStats.ATTACK_SPEED, 0.7f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 1.0f).build()))
                .module(IsEffectiveModule.tag(BlockTags.MINEABLE_WITH_PICKAXE))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build());

        define(TKEWDefinitions.LANCE)
                .module(PartStatsModule.parts()
                        .part(toughHandle)
                        .part(largePlate)
                        .part(smallBlade)
                        .part(smallBlade).build())
                .module(defaultFour)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 6f)
                        .set(ToolStats.ATTACK_SPEED, 0.8f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.8f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 2)
                        .slots(SlotType.ABILITY, 2).build())
                .module(ToolTraitsModule.builder()
                        .trait(TKEWModifierIds.REACH, 1)
                        .trait(TKEWModifierIds.CAVALRY, 1).build());

        define(TKEWDefinitions.GREATSWORD)
                .module(PartStatsModule.parts()
                        .part(toughHandle)
                        .part(toughHandle)
                        .part(broadBlade)
                        .part(broadBlade).build())
                .module(defaultFour)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 12f)
                        .set(ToolStats.ATTACK_SPEED, 0.6f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 1.2f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build())
                .module(new SweepWeaponAttack(2));

        define(TKEWDefinitions.SICKLE)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(smallBlade)
                        .part(smallBlade).build())
                .module(defaultThree)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.7f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.5f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 4)
                        .slots(SlotType.ABILITY, 2).build());

        define(TKEWDefinitions.BOARDING_AXE)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(smallAxeHead)
                        .part(smallBlade).build())
                .module(defaultThree)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 8f)
                        .set(ToolStats.ATTACK_SPEED, 0.8f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.8f).build()))
                .module(IsEffectiveModule.tag(BlockTags.MINEABLE_WITH_AXE))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build());

        define(TKEWDefinitions.QUARTERSTAFF)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(toolHandle)
                        .part(toughBinding).build())
                .module(defaultThree)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.5f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.7f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build())
                .module(new SweepWeaponAttack(1));

        define(TKEWDefinitions.PARRYING_DAGGER)
                .module(PartStatsModule.parts()
                        .part(toolHandle)
                        .part(toolBinding)
                        .part(smallBlade).build())
                .module(defaultThree)
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 2f)
                        .set(ToolStats.ATTACK_SPEED, 2f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.DURABILITY, 0.6f).build()))
                .module(ToolSlotsModule.builder()
                        .slots(SlotType.UPGRADE, 3)
                        .slots(SlotType.ABILITY, 1).build());
    }

    @Override
    public String getName() {
        return "Tinker's Extra Weapons Tool Definitions";
    }
}
