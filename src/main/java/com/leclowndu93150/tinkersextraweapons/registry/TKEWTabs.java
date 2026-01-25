package com.leclowndu93150.tinkersextraweapons.registry;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;

import java.util.function.Consumer;

public class TKEWTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TKEWMain.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tinkersextraweapons"))
                    .icon(() -> TKEWTools.PIKE.get().getRenderTool())
                    .displayItems(TKEWTabs::addItems)
                    .build());

    private static void addItems(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        Consumer<ItemStack> consumer = output::accept;
        ToolBuildHandler.addVariants(consumer, TKEWTools.PIKE.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.WARHAMMER.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.SICKLE.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.BOARDING_AXE.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.QUARTERSTAFF.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.PARRYING_DAGGER.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.LANCE.get(), "");
        ToolBuildHandler.addVariants(consumer, TKEWTools.GREATSWORD.get(), "");
    }
}
