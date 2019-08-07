package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.Issac29Core;
import com.mreyeballs29.issactncore.util.EnumSeries;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public abstract class ItemWood extends ItemElement {
	@Override
	public EnumSeries getSeries() {
		return EnumSeries.WOOD;
	}
	
	@Override
	public int getLength() {
		return 6;
	}
	
	protected ItemWood() {
		this.setHasSubtypes(true);
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
	public void registerModels() {
		for (EnumType type : EnumType.values()) {
			Issac29Core.proxy.registerModel(
					this, 
					type.getMetadata(), 
					"inventory",
					getShape(),
					type.getName()
				);
		}
	}
}