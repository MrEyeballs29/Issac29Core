package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.Issac29Core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMeta extends Item {
	private String[] nameList;
	private String[] unlocalizedList;
	
	public ItemMeta(String[] names, String[] unloc) {
		nameList = names;
		unlocalizedList = unloc;
		hasSubtypes = true;
		setMaxDamage(0);
	}
	
	public ItemMeta(String[] names) {
		this(names, names);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = Math.min(nameList.length - 1, stack.getMetadata());
		if (nameList[meta] == null) {
			return super.getUnlocalizedName();
		}
		return super.getUnlocalizedName() + '.' + unlocalizedList[meta];
	}
	
	public void registerModels() {
		for (int i = 0; i < nameList.length; i++) {
			if (nameList[i] == null) {
				Issac29Core.proxy.registerModel(this, i, "inventory");
			} else Issac29Core.proxy.registerModel(this, i, "inventory", nameList[i]);
		};
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < nameList.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}
