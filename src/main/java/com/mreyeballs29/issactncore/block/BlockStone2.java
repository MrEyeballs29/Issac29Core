package com.mreyeballs29.issactncore.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockStone2 extends Block {

	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);
	
	public BlockStone2() {
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.LIMESTONE));
	}

	public BlockStone2(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		int meta = ((EnumType)state.getValue(VARIANT)).meta;
		if (meta % 2 == 0) {
			return meta/2;
		}
		return meta;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		int meta = state.getValue(VARIANT).meta;
		if (meta % 2 == 0) {
			return Item.getItemFromBlock(Blocks.WOOL);
		}
		return super.getItemDropped(state, rand, fortune);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumType)state.getValue(VARIANT)).meta;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
	}
	
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((EnumType)state.getValue(VARIANT)).getMapColor();
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (EnumType type : EnumType.values()) items.add(new ItemStack(this, 1, type.meta));
	}
	
	@Override
	public String getUnlocalizedName() {
		return super.getUnlocalizedName() + ".stone";
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static enum EnumType implements IStringSerializable {
		LIMESTONE(0, MapColor.SAND, "limestone"),
		LIMESTONE_SMOOTH(1, MapColor.SAND, "smooth_limestone", "limestoneSmooth", false),
		MARBLE(2, MapColor.SNOW, "marble"),
		MARBLE_SMOOTH(3, MapColor.SNOW, "smooth_marble", "marbleSmooth", false),
		BASALT(4, MapColor.BLACK, "basalt"),
		BASALT_SMOOTH(5, MapColor.BLACK, "smooth_basalt", "basaltSmooth", false),
		QUARTZITE(6, MapColor.PINK, "quartzite"),
		QUARTZITE_SMOOTH(7, MapColor.PINK, "smooth_quartzite", "quartziteSmooth", false),
		GNEISS(8, MapColor.CLAY, "gneiss"),
		GNEISS_SMOOTH(9, MapColor.CLAY, "smooth_gneiss", "gneissSmooth", false),
		BLACK_GRANITE(10, MapColor.PURPLE, "black_granite"),
		BLACK_GRANITE_SMOOTH(11, MapColor.PURPLE, "smooth_black_granite", "black_graniteSmooth", false),
		BLUE_SCHIST(12, MapColor.CYAN, "blue_schist"),
		BLUE_SCHIST_SMOOTH(13, MapColor.CYAN, "smooth_blue_schist", "blue_schistSmooth", false),
		GREEN_SCHIST(14, MapColor.GRASS, "green_schist"),
		GREEN_SCHIST_SMOOTH(15, MapColor.GRASS, "smooth_green_schist", "green_schistSmooth", false);
		
		private final int meta;
		private final MapColor color;
		private final String unlocalized;
		private final String name;
		private final boolean isNatural;
		
		EnumType(int me, MapColor map, String entry, String registry,  boolean natural) {
			meta = me;
			color = map;
			unlocalized = registry;
			name = entry;
			isNatural = natural;
		}
		
		private EnumType(int me, MapColor map, String entry) {
			this(me, map, entry, entry, true);
		}
		
		@Override
		public String getName() {
			return name;
		}

		public String getUnlocalizedName() {
			return unlocalized;
		}

		public boolean isNatural() {
			return isNatural;
		}

		public MapColor getMapColor() {
			return color;
		}

		public int getMetadata() {
			return meta;
		}
		
        public static EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= values().length)
            {
                meta = 0;
            }
            return values()[meta];
        }
		
	}
}
