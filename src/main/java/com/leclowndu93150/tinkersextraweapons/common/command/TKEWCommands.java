package com.leclowndu93150.tinkersextraweapons.common.command;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TKEWMain.MODID, value = Dist.CLIENT)
public class TKEWCommands {

    @SubscribeEvent
    public static void onRegisterClientCommands(RegisterClientCommandsEvent event) {
        DumpTextureCommand.register(event.getDispatcher());
    }
}
