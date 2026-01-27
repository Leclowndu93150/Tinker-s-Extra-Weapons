package com.leclowndu93150.tinkersextraweapons.modifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap.Builder;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;

public class ArmorBonusModifier extends Modifier implements AttributesModifierHook, TooltipModifierHook {

    private static final UUID ARMOR_UUID = UUID.fromString("9b7c5a3e-1d8f-4b2a-a6e0-7f3c8d9e0a1b");
    private static final Component ARMOR_BONUS = Component.translatable("modifier.tinkersextraweapons.armor_bonus.armor");
    private final float armorPerLevel;

    public ArmorBonusModifier(float armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    @Override
    protected void registerHooks(Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.ATTRIBUTES, ModifierHooks.TOOLTIP);
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) {
            float armor = armorPerLevel * modifier.getLevel();
            if (armor > 0) {
                consumer.accept(Attributes.ARMOR, new AttributeModifier(ARMOR_UUID, "tinkersextraweapons.armor_bonus", armor, AttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        float armor = armorPerLevel * modifier.getLevel();
        if (armor > 0) {
            tooltip.add(applyStyle(Component.literal("+" + (int)armor + " ").append(ARMOR_BONUS)));
        }
    }
}
