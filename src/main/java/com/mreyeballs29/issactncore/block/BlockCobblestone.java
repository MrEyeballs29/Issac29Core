package com.mreyeballs29.issactncore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCobblestone extends Block {

	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);	
	
	public BlockCobblestone() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.GRANITE));
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((EnumType)state.getValue(VARIANT)).getMapColor();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumType)state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
	}

	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (EnumType type : EnumType.values()) items.add(new ItemStack(this, 1, type.meta));
		
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ((EnumType)state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	public static enum EnumType implements IStringSerializable {
		GRANITE(0, MapColor.DIRT, "granite"),
		DIORITE(1, MapColor.QUARTZ, "diorite"),
		ANDESITE(2, MapColor.STONE, "andesite");
		
		private int meta;
		private MapColor map;
		private String unloc;
		private String name;
		
		private EnumType(int p_i0, MapColor p_mc0, String p_s0) {
			meta = p_i0;
			map = p_mc0;
			unloc = p_s0;
			name = p_s0;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		public MapColor getMapColor() {
			return map;
		}
		
		public int getMetadata() {
			return meta;
		}
		
		public String getUnlocalizedName() {
			return unloc;
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
