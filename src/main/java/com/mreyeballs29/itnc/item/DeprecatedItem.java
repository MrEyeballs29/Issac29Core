package com.mreyeballs29.itnc.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class DeprecatedItem extends Item {

	private String mode;

	public DeprecatedItem(Properties properties, String mode) {
		super(properties);
		this.mode = mode;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("message.itnc.deprecation." + this.mode, INCItems.BRONZE_NUGGET.getDisplayName(stack).getFormattedText()).applyTextStyle(TextFormatting.GRAY)); //$NON-NLS-1$
	}
}
