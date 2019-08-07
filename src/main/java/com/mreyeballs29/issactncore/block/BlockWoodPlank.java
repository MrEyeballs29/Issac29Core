package com.mreyeballs29.issactncore.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoodPlank extends Block {

	public BlockWoodPlank() {
		super(Material.WOOD);
		this.setSoundType(SoundType.WOOD);
	}

}
