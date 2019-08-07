package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.Issac29Core;
import com.mreyeballs29.issactncore.util.EnumSeries;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class ItemPrecious extends ItemElement {

	@Override
	public EnumSeries getSeries() {
		return EnumSeries.PRECOUS;
	}

	@Override
	public int getLength() {
		return 16;
	}
	
	protected ItemPrecious() {
		this.hasSubtypes = true;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < getLength(); ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + getShape() + EnumPreciousMetal.byMetadata(stack.getMetadata()).getUnlocalizedName();
	}
	
	@Override
	public void registerModels() {
		for (EnumPreciousMetal type : EnumPreciousMetal.values())
		{
			Issac29Core.proxy.registerModel(this, type.getId(), "inventory", getShape(), type.getName());
		}
	}
}
