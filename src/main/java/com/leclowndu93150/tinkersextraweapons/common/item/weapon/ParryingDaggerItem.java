package com.leclowndu93150.tinkersextraweapons.common.item.weapon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class ParryingDaggerItem extends ModifiableMeleeWeaponItem {

    public ParryingDaggerItem(Properties properties, ToolDefinition toolDefinition) {
        super(properties, toolDefinition);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isCrouching()) {
            return InteractionResultHolder.fail(stack);
        }
        InteractionResultHolder<ItemStack> result = super.use(level, player, hand);
        if (result.getResult().consumesAction()) {
            return result;
        }
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if (toolAction == ToolActions.SHIELD_BLOCK) {
            return stack.getCount() == 1 && !ToolStack.from(stack).isBroken();
        }
        return super.canPerformAction(stack, toolAction);
    }
}
