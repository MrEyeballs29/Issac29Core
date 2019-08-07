package com.mreyeballs29.issactncore.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPlate extends Block {

	public BlockPlate(MapColor color) {
		super(Material.IRON, color);
		this.setSoundType(SoundType.METAL);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public BlockPlate() {
		this(Material.IRON.getMaterialMapColor());
	}
	
}
