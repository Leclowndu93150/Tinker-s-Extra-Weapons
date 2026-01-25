package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.library.recipe.tinkerstation.building.ToolBuildingRecipeBuilder;
import slimeknights.tconstruct.library.tools.item.IModifiable;

import java.util.function.Consumer;

public class TKEWToolsRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public TKEWToolsRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/building/";

        toolBuilding(consumer, TKEWTools.PIKE, folder);
        toolBuilding(consumer, TKEWTools.WARHAMMER, folder);
        toolBuilding(consumer, TKEWTools.SICKLE, folder);
        toolBuilding(consumer, TKEWTools.BOARDING_AXE, folder);
        toolBuilding(consumer, TKEWTools.QUARTERSTAFF, folder);
        toolBuilding(consumer, TKEWTools.PARRYING_DAGGER, folder);
        toolBuilding(consumer, TKEWTools.LANCE, folder);
        toolBuilding(consumer, TKEWTools.GREATSWORD, folder);
    }

    protected void toolBuilding(Consumer<FinishedRecipe> consumer, ItemObject<? extends IModifiable> item, String folder) {
        ToolBuildingRecipeBuilder.toolBuildingRecipe(item.get())
                .save(consumer, prefix(item.getId(), folder));
    }

    @SuppressWarnings("deprecation")
    protected ResourceLocation prefix(ResourceLocation loc, String prefix) {
        return new ResourceLocation(TKEWMain.MODID, prefix + loc.getPath());
    }
}
