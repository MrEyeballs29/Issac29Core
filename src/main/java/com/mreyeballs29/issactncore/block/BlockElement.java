package com.mreyeballs29.issactncore.block;

import com.mreyeballs29.issactncore.util.EnumSeries;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public abstract class BlockElement extends Block {

	protected BlockElement(Material materialIn) {
		super(materialIn);

	}

	protected BlockElement(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);

	}

	public abstract EnumSeries getSeries();
	
	public abstract int getLength();
}
