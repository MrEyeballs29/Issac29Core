package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.util.EnumShape;

import net.minecraft.block.BlockPlanks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStick extends ItemWood {

	public ItemStick() {
		super();
		this.setMaxDamage(0);
		this.setFull3D();
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item.stick." + BlockPlanks.EnumType.byMetadata(stack.getMetadata()).getUnlocalizedName();
	}
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < BlockPlanks.EnumType.values().length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public EnumShape getShape() {
		return EnumShape.STICK;
	}
	
}