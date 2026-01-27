package com.leclowndu93150.tinkersextraweapons.client;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import com.leclowndu93150.tinkersextraweapons.registry.TKEWTools;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import slimeknights.tconstruct.library.client.model.TinkerItemProperties;

import static slimeknights.tconstruct.library.client.model.tools.ToolModel.registerItemColors;

@Mod.EventBusSubscriber(modid = TKEWMain.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TKEWClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            TinkerItemProperties.registerToolProperties(TKEWTools.PIKE);
            TinkerItemProperties.registerToolProperties(TKEWTools.WARHAMMER);
            TinkerItemProperties.registerToolProperties(TKEWTools.LANCE);
            TinkerItemProperties.registerToolProperties(TKEWTools.GREATSWORD);
            TinkerItemProperties.registerToolProperties(TKEWTools.SICKLE);
            TinkerItemProperties.registerToolProperties(TKEWTools.BOARDING_AXE);
            TinkerItemProperties.registerToolProperties(TKEWTools.QUARTERSTAFF);
            TinkerItemProperties.registerToolProperties(TKEWTools.PARRYING_DAGGER);
        });
    }

//    @SubscribeEvent
//    public static void itemColors(RegisterColorHandlersEvent.Item event) {
//        registerItemColors(event.getItemColors(), TKEWTools.PIKE);
//        registerItemColors(event.getItemColors(), TKEWTools.WARHAMMER);
//        registerItemColors(event.getItemColors(), TKEWTools.LANCE);
//        registerItemColors(event.getItemColors(), TKEWTools.GREATSWORD);
//        registerItemColors(event.getItemColors(), TKEWTools.SICKLE);
//        registerItemColors(event.getItemColors(), TKEWTools.BOARDING_AXE);
//        registerItemColors(event.getItemColors(), TKEWTools.QUARTERSTAFF);
//        registerItemColors(event.getItemColors(), TKEWTools.PARRYING_DAGGER);
//    }
}
