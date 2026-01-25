package com.leclowndu93150.tinkersextraweapons;

import com.leclowndu93150.tinkersextraweapons.config.TKEWConfig;
import com.leclowndu93150.tinkersextraweapons.datagen.TKEWDataGatherer;
import com.leclowndu93150.tinkersextraweapons.modifiers.TKEWModifiers;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWParts;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTabs;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TKEWMain.MODID)
public class TKEWMain {

    public static final String MODID = "tinkersextraweapons";

    @SuppressWarnings("removal")
    public TKEWMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TKEWTools.ITEMS.register(modEventBus);
        TKEWParts.ITEMS.register(modEventBus);
        TKEWTabs.CREATIVE_TABS.register(modEventBus);
        TKEWModifiers.init(modEventBus);

        modEventBus.addListener(TKEWDataGatherer::gatherData);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TKEWConfig.COMMON_SPEC);
    }

    @SuppressWarnings("deprecation")
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }
}
