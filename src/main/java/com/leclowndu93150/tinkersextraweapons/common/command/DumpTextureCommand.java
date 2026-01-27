package com.leclowndu93150.tinkersextraweapons.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class DumpTextureCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("dumptexture")
            .executes(DumpTextureCommand::execute));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            context.getSource().sendFailure(Component.literal("No player found"));
            return 0;
        }

        ItemStack heldItem = mc.player.getMainHandItem();
        if (heldItem.isEmpty()) {
            context.getSource().sendFailure(Component.literal("No item in main hand"));
            return 0;
        }

        try {
            BakedModel model = mc.getItemRenderer().getModel(heldItem, mc.level, mc.player, 0);
            List<BakedModel> renderPasses = model.getRenderPasses(heldItem, true);

            Path outputDir = mc.gameDirectory.toPath().resolve("texture_dumps");
            outputDir.toFile().mkdirs();

            String itemName = heldItem.getItem().toString().replace(":", "_");
            int passIndex = 0;

            for (BakedModel pass : renderPasses) {
                TextureAtlasSprite sprite = pass.getParticleIcon();
                if (sprite != null) {
                    ResourceLocation textureLoc = sprite.contents().name();
                    int width = sprite.contents().width();
                    int height = sprite.contents().height();

                    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            int color = sprite.getPixelRGBA(0, x, y);
                            int a = (color >> 24) & 0xFF;
                            int b = (color >> 16) & 0xFF;
                            int g = (color >> 8) & 0xFF;
                            int r = color & 0xFF;
                            image.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
                        }
                    }

                    String fileName = itemName + "_pass" + passIndex + "_" + textureLoc.getPath().replace("/", "_") + ".png";
                    File outputFile = outputDir.resolve(fileName).toFile();
                    ImageIO.write(image, "PNG", outputFile);

                    context.getSource().sendSuccess(() -> Component.literal("Saved: " + fileName), false);
                    passIndex++;
                }
            }

            if (passIndex == 0) {
                TextureAtlasSprite sprite = model.getParticleIcon();
                if (sprite != null) {
                    ResourceLocation textureLoc = sprite.contents().name();
                    int width = sprite.contents().width();
                    int height = sprite.contents().height();

                    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            int color = sprite.getPixelRGBA(0, x, y);
                            int a = (color >> 24) & 0xFF;
                            int b = (color >> 16) & 0xFF;
                            int g = (color >> 8) & 0xFF;
                            int r = color & 0xFF;
                            image.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
                        }
                    }

                    String fileName = itemName + "_" + textureLoc.getPath().replace("/", "_") + ".png";
                    File outputFile = outputDir.resolve(fileName).toFile();
                    ImageIO.write(image, "PNG", outputFile);

                    context.getSource().sendSuccess(() -> Component.literal("Saved: " + fileName), false);
                }
            }

            context.getSource().sendSuccess(() -> Component.literal("Textures dumped to texture_dumps folder"), false);
            return 1;

        } catch (Exception e) {
            context.getSource().sendFailure(Component.literal("Error: " + e.getMessage()));
            return 0;
        }
    }
}
