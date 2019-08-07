package com.mreyeballs29.issactncore.init;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.mreyeballs29.issactncore.Issac29Core;
import com.mreyeballs29.issactncore.block.BlockCobblestone;
import com.mreyeballs29.issactncore.block.BlockFrame;
import com.mreyeballs29.issactncore.block.BlockPlainConcretePowder;
import com.mreyeballs29.issactncore.block.BlockPlate;
import com.mreyeballs29.issactncore.block.BlockPowder;
import com.mreyeballs29.issactncore.block.BlockStone2;
import com.mreyeballs29.issactncore.block.BlockWoodLog;
import com.mreyeballs29.issactncore.block.BlockWoodPlank;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class I29CBlocks {

	static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final BlockFrame IRON_FRAME = new BlockFrame(MapColor.IRON, true);
	public static final BlockFrame GOLD_FRAME = new BlockFrame(MapColor.GOLD, true);
	public static final Block IRON_PLATE_BLOCK = new BlockPlate();
	public static final Block GOLD_PLATE_BLOCK = new BlockPlate(MapColor.GOLD);
	public static final Block WOOD_PLANK = new BlockWoodPlank();
	public static final BlockRotatedPillar WOOD = new BlockWoodLog();
	public static final BlockPowder IRON_DUST = new BlockPowder(false, I29CItems.IRON_DUST, new Color(0xA1A1A1), MapColor.IRON);
	public static final BlockPowder GOLD_DUST = new BlockPowder(false, I29CItems.GOLD_DUST, new Color(0xCFB541), MapColor.GOLD);
	public static final BlockCobblestone COBBLESTONE = new BlockCobblestone();
	public static final Block STONE = new Block(Material.ROCK);
	public static final Block BEDROCK_COBBLESTONE = new Block(Material.ROCK);
	public static final Block BEDROCK_SMOOTH = new Block(Material.ROCK);
	public static final Block CONCRETE = new Block(Material.ROCK);
	public static final Block CONCRETE_POWDER = new BlockPlainConcretePowder(I29CItems.CONCRETE_POWDER);

	public static final BlockStone2 STONE2 = new BlockStone2();
	
	private static boolean initalized = false;

	public static void initalizeBlocks() {
		if (initalized)
		{
			return;
		}
		vanillaPlus();
		IRON_FRAME.setUnlocalizedName("frameIron").setHardness(3.75F).setResistance(7.5F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		GOLD_FRAME.setUnlocalizedName("frameGold").setHardness(2.25F).setResistance(7.5F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		WOOD_PLANK.setUnlocalizedName("wood").setHardness(2.0F).setResistance(10F/3).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		IRON_PLATE_BLOCK.setUnlocalizedName("structureIron").setHardness(5.0F).setResistance(10.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		GOLD_PLATE_BLOCK.setUnlocalizedName("structureGold").setHardness(3.0F).setResistance(10.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		IRON_DUST.setUnlocalizedName("dustIron").setHardness(2.0F).setResistance(4.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		GOLD_DUST.setUnlocalizedName("dustGold").setHardness(1.2F).setResistance(4.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		COBBLESTONE.setUnlocalizedName("stonebrick").setHardness(2.0F).setResistance(10.0F);
		WOOD.setUnlocalizedName("log").setResistance(10F/3);
		Blocks.BEDROCK.setHardness(145F).setResistance(8000.0F).setHarvestLevel("pickaxe", 3);
		STONE.setUnlocalizedName("stoneSmooth").setResistance(10.0F).setHardness(1.5F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		BEDROCK_COBBLESTONE.setUnlocalizedName("stonebrick.bedrock").setHardness(150F).setResistance(8000.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		BEDROCK_SMOOTH.setUnlocalizedName("stone.bedrockSmooth").setHardness(145F).setResistance(8000.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		STONE2.setUnlocalizedName("stone").setHardness(1.5F).setResistance(10F);
		CONCRETE_POWDER.setUnlocalizedName("concretePowder").setHardness(0.5F).setResistance(5F/6);
		CONCRETE.setUnlocalizedName("concrete").setHardness(1.8F).setResistance(3.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		BLOCKS.add(IRON_FRAME);
		BLOCKS.add(GOLD_FRAME);
		BLOCKS.add(IRON_PLATE_BLOCK);
		BLOCKS.add(GOLD_PLATE_BLOCK);
		BLOCKS.add(IRON_DUST);
		BLOCKS.add(GOLD_DUST);
		BLOCKS.add(WOOD);
		BLOCKS.add(WOOD_PLANK);
		BLOCKS.add(STONE);
		BLOCKS.add(COBBLESTONE);
		BLOCKS.add(BEDROCK_COBBLESTONE);
		BLOCKS.add(BEDROCK_SMOOTH);
		BLOCKS.add(STONE2);
		BLOCKS.add(CONCRETE);
		BLOCKS.add(CONCRETE_POWDER);
		try {
			Field field = Block.class.getDeclaredField("enableStats");
			field.setAccessible(true);
			field.set(Blocks.BEDROCK, true);
		} catch (Throwable thro) {
			Issac29Core.log.error(thro);
		}
		initalized = true;
	}
	
	private static void vanillaPlus() {
		
		// Metals
		
		IRON_FRAME.setRegistryName("i29c:iron_frame").setHarvestLevel("pickaxe", 1);
		GOLD_FRAME.setRegistryName("i29c:gold_frame").setHarvestLevel("pickaxe", 2);
		IRON_PLATE_BLOCK.setRegistryName("i29c:iron_plate_block").setHarvestLevel("pickaxe", 1);
		GOLD_PLATE_BLOCK.setRegistryName("i29c:gold_plate_block").setHarvestLevel("pickaxe", 2);
		IRON_DUST.setRegistryName("i29c:iron_dust_block").setHarvestLevel("shovel", -1);
		GOLD_DUST.setRegistryName("i29c:gold_dust_block").setHarvestLevel("shovel", -1);
		
		// ROCK
		
		COBBLESTONE.setRegistryName("i29c:cobblestone").setHarvestLevel("pickaxe", 0);
		STONE.setRegistryName("i29c:smooth_stone").setHarvestLevel("pickaxe", 0);
		BEDROCK_COBBLESTONE.setRegistryName("i29c:bedrock_cobblestone").setHarvestLevel("pickaxe", 3);;
		BEDROCK_SMOOTH.setRegistryName("i29c:smooth_bedrock").setHarvestLevel("pickaxe", 3);
		STONE2.setRegistryName("i29c:stone2").setHarvestLevel("pickaxe", 0);
		CONCRETE.setRegistryName("i29c:concrete").setHarvestLevel("pickaxe", 0);
		CONCRETE_POWDER.setRegistryName("i29c:concrete_powder_block").setHarvestLevel("shovel", -1);
		
		// WOOD
		
		WOOD_PLANK.setRegistryName("i29c:planks").setHarvestLevel("axe", -1);
		WOOD.setRegistryName("i29c:log").setHarvestLevel("axe", -1);
	}
	
	@SuppressWarnings("unused")
	private static void baseMetal() {
		// 
	}
	
	@SuppressWarnings("unused")
	private static void precousMetal() {
		//
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		Issac29Core.log.info("Fired 3");
		initalizeBlocks();
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onHarvestDrops(HarvestDropsEvent event) {
		IBlockState blockstate = event.getState();
		List<ItemStack> stack = event.getDrops();
		Block block = blockstate.getBlock();
		if (!event.isSilkTouching()) {
			if (blockstate.getBlock() == Blocks.SAND)
			{
				stack.clear();
				addItemsToDrop(stack, I29CItems.SAND, 9, getMetaFromBlockRaw(blockstate));
			} else if (block == Blocks.CONCRETE_POWDER) {
				stack.clear();
				addItemsToDrop(stack, I29CItems.DYED_CONCRETE_POWDER, 9, getMetaFromBlockRaw(blockstate));
			} else if (Blocks.STONE == block && 
					(1 == Blocks.STONE.getMetaFromState(blockstate) ||
					3 == Blocks.STONE.getMetaFromState(blockstate) ||
					5 == Blocks.STONE.getMetaFromState(blockstate))) {
				stack.clear();
				stack.add(new ItemStack(COBBLESTONE, 1, getMetaFromBlockRaw(blockstate)/2));
			}
			if (block == Blocks.BEDROCK) {
				stack.clear();
				stack.add(new ItemStack(BEDROCK_COBBLESTONE));
			}
		} else if (block == Blocks.BEDROCK) {
			stack.add(ItemStack.EMPTY);
		}
	}
	
	private static int getMetaFromBlockRaw(IBlockState state) {
		return state.getBlock().getMetaFromState(state);
	}

	private static void addItemsToDrop(List<ItemStack> list, Item item, int rows, int meta) {
		for (int i = 0; i < rows; i++) {
			list.add(new ItemStack(item, 1, meta));
		}
	}
}
