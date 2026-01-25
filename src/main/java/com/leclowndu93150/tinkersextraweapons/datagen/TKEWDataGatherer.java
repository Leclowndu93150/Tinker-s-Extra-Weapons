package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

public class TKEWDataGatherer {

    public static void gatherData(GatherDataEvent event) {
        if (!event.getModContainer().getModId().equals(TKEWMain.MODID)) {
            return;
        }

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        boolean server = event.includeServer();
        boolean client = event.includeClient();

        generator.addProvider(server, new TKEWToolDefinitions(packOutput));
        generator.addProvider(server, new TKEWToolsRecipeProvider(packOutput));
        generator.addProvider(server, new TKEWStationSlotLayoutProvider(packOutput));
        generator.addProvider(server, new TKEWModifierProvider(packOutput));

        TKEWPartSpriteProvider partSprites = new TKEWPartSpriteProvider();
        generator.addProvider(client, new slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator(packOutput, TKEWMain.MODID, partSprites));
    }
}
