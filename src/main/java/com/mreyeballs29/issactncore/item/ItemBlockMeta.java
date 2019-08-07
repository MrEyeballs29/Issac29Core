package com.mreyeballs29.issactncore.item;

import com.mreyeballs29.issactncore.Issac29Core;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock {

	protected Operation operator;
	private final int length;
	private String custom = null;
	private String name = null;
	
	public ItemBlockMeta(Block block, Operation operate, int length, String name, String localized) {
		super(block);
		operator = operate;
		setHasSubtypes(true);
		this.length = length;
		this.custom = name;
		this.name = localized;
	}
	
	public ItemBlockMeta(Block block, Operation operate, int length) {
		this(block, operate, length, null, null);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return name + '.' + operator.apply(stack, true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	public void registerModels() {
		for (int i = 0; i < length; i++) {
			Issac29Core.proxy.registerModel(this, i, "inventory", operator.apply(new ItemStack(this, 0, i), false), custom);
		}
	}
	
	public static interface Operation {
		String apply(ItemStack stack, boolean translate);
	}
}
