package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.util.EnumShape;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemPreciousIngot extends ItemPrecious {

	public ItemPreciousIngot() {
		super();
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public EnumShape getShape() {
		return EnumShape.INGOT;
	}

	@Override
	public boolean isBeaconPayment(ItemStack stack) {
		return true;
	}
}
