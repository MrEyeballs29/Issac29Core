package com.mreyeballs29.itnc.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("itnc")
public class INCBlocks {
	
	private static final List<Block> LIST = new ArrayList<>();
	
	public static final Block POLISHED_STONE = new Block(Properties.from(Blocks.STONE)).setRegistryName(new ResourceLocation("itnc", "polished_stone"));
	public static final Block POLISHED_STONE_SLAB = new SlabBlock(Properties.from(POLISHED_STONE)).setRegistryName(new ResourceLocation("itnc", "polished_stone_slab"));
	public static final Block IRON_FRAME = new FrameBlock(Properties.from(Blocks.IRON_BLOCK).hardnessAndResistance(2.5f, 3.0F).notSolid()).setRegistryName("itnc", "iron_frame");
	public static final Block GOLD_FRAME = new FrameBlock(Properties.from(Blocks.GOLD_BLOCK).hardnessAndResistance(1.5f, 3.0F).notSolid()).setRegistryName("itnc", "gold_frame");
	public static final Block COPPER_ORE = create(Material.ROCK, MaterialColor.STONE, 3.0F, 3.0F, 1, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc","copper_ore"));
	public static final Block COPPER_BLOCK = new BeaconBaseBlock(Properties.create(Material.IRON, MaterialColor.ADOBE).hardnessAndResistance(4.0F, 6.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName(new ResourceLocation("itnc", "copper_block"));
	public static final Block COPPER_FRAME = new FrameBlock(Properties.from(COPPER_BLOCK).hardnessAndResistance(2.0F, 3.0F).notSolid()).setRegistryName("itnc","copper_frame");
	public static final Block TIN_ORE = create(Material.ROCK, MaterialColor.STONE, 3.0F, 3.0F, 1, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "tin_ore"));
	public static final Block TIN_BLOCK = new BeaconBaseBlock(Properties.create(Material.IRON, MaterialColor.LIGHT_BLUE_TERRACOTTA).hardnessAndResistance(3.0F, 6.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName(new ResourceLocation("itnc", "tin_block"));
	public static final Block TIN_FRAME = new FrameBlock(Properties.from(TIN_BLOCK).hardnessAndResistance(1.5F, 3.0F).notSolid()).setRegistryName("itnc", "tin_frame");
	public static final Block SILVER_ORE = create(Material.ROCK, 3.0F, 2, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "silver_ore"));
	public static final Block SILVER_BLOCK = new BeaconBaseBlock(Properties.create(Material.IRON, MaterialColor.WOOL).hardnessAndResistance(4.0F, 6.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName(new ResourceLocation("itnc", "silver_block"));
	public static final Block SILVER_FRAME = new FrameBlock(Properties.from(SILVER_BLOCK).hardnessAndResistance(2.0F, 3.0F).notSolid()).setRegistryName("itnc", "silver_frame");
	public static final Block LEAD_ORE = create(Material.ROCK, 3.0F, 1, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "lead_ore"));
	public static final Block LEAD_BLOCK = new BeaconBaseBlock(Properties.create(Material.IRON, MaterialColor.PURPLE_TERRACOTTA).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL)).setRegistryName("itnc", "lead_block");
	public static final Block LIGNITE_ORE = createOre(Material.ROCK, 3.0F, 3.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "lignite_ore"), 0, 2);
	public static final Block LIGNITE_BLOCK = create(Material.ROCK, MaterialColor.BROWN_TERRACOTTA, 3.5F, 6.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "lignite_block"));
	public static final Block OILSHALE_ORE = new FallingExpBlock(Properties.from(Blocks.SAND).hardnessAndResistance(0.75F), 1, 3, 2171176, 14406560).setRegistryName("itnc", "oilshale_ore");
	public static final Block NETHER_GOLD_ORE = create(Material.ROCK, MaterialColor.NETHERRACK, 3.0F, 3.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "nether_gold_ore"));
	public static final Block NETHER_IRON_ORE = create(Material.ROCK, MaterialColor.NETHERRACK, 3.0F, 3.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "nether_iron_ore"));
	public static final Block NETHER_COPPER_ORE = create(Material.ROCK, MaterialColor.NETHERRACK, 3.0F, 3.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "nether_copper_ore"));
	public static final Block END_TIN_ORE = create(Material.ROCK, MaterialColor.SAND, 4.0F, 7.5F, 1, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "end_tin_ore"));
	public static final Block END_SILVER_ORE = create(Material.ROCK, MaterialColor.SAND, 4.0F, 7.5F, 1, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "end_silver_ore"));
	public static final Block NETHER_LEAD_ORE = create(Material.ROCK, MaterialColor.NETHERRACK, 3.0F, 3.0F, 0, ToolType.PICKAXE, SoundType.STONE, new ResourceLocation("itnc", "nether_lead_ore"));
	public static final Block WHITE_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.WHITE_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "white_wool_wire"));
	public static final Block ORANGE_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.ORANGE_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "orange_wool_wire"));
	public static final Block MAGENTA_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.MAGENTA_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "magenta_wool_wire"));
	public static final Block LIGHT_BLUE_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.LIGHT_BLUE_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "light_blue_wool_wire"));
	public static final Block YELLOW_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.YELLOW_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "yellow_wool_wire"));
	public static final Block LIME_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.LIME_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "lime_wool_wire"));
	public static final Block PINK_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.PINK_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "pink_wool_wire"));
	public static final Block GRAY_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.GRAY_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "gray_wool_wire"));
	public static final Block LIGHT_GRAY_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.LIGHT_GRAY_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "light_gray_wool_wire"));
	public static final Block CYAN_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.CYAN_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "cyan_wool_wire"));
	public static final Block PURPLE_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.PURPLE_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "purple_wool_wire"));
	public static final Block BLUE_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.BLUE_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "blue_wool_wire"));
	public static final Block BROWN_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.BROWN_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "brown_wool_wire"));
	public static final Block GREEN_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.GREEN_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "green_wool_wire"));
	public static final Block RED_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.RED_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "red_wool_wire"));
	public static final Block BLACK_WOOL_WIRE = new FiberBlock(Properties.from(Blocks.BLACK_WOOL).notSolid().hardnessAndResistance(0.25f, 0.2f)).setRegistryName(new ResourceLocation("itnc", "black_wool_wire"));
	
	private static void initalizeBlocks() {
		LIST.add(POLISHED_STONE);
		LIST.add(POLISHED_STONE_SLAB);
		LIST.add(IRON_FRAME);
		LIST.add(GOLD_FRAME);
		LIST.add(COPPER_ORE);
		LIST.add(TIN_ORE);
		LIST.add(SILVER_ORE);
		LIST.add(LEAD_ORE);
		LIST.add(LIGNITE_ORE);
		LIST.add(OILSHALE_ORE);
		LIST.add(COPPER_BLOCK);
		LIST.add(TIN_BLOCK);
		LIST.add(SILVER_BLOCK);
		LIST.add(LEAD_BLOCK);
		LIST.add(LIGNITE_BLOCK);
		LIST.add(COPPER_FRAME);
		LIST.add(TIN_FRAME);
		LIST.add(SILVER_FRAME);
		LIST.add(NETHER_IRON_ORE);
		LIST.add(NETHER_GOLD_ORE);
		LIST.add(NETHER_COPPER_ORE);
		LIST.add(NETHER_LEAD_ORE);
		LIST.add(END_TIN_ORE);
		LIST.add(END_SILVER_ORE);
		LIST.add(WHITE_WOOL_WIRE);
		LIST.add(ORANGE_WOOL_WIRE);
		LIST.add(MAGENTA_WOOL_WIRE);
		LIST.add(LIGHT_BLUE_WOOL_WIRE);
		LIST.add(YELLOW_WOOL_WIRE);
		LIST.add(LIME_WOOL_WIRE);
		LIST.add(PINK_WOOL_WIRE);
		LIST.add(GRAY_WOOL_WIRE);
		LIST.add(LIGHT_GRAY_WOOL_WIRE);
		LIST.add(CYAN_WOOL_WIRE);
		LIST.add(PURPLE_WOOL_WIRE);
		LIST.add(BLUE_WOOL_WIRE);
		LIST.add(BROWN_WOOL_WIRE);
		LIST.add(GREEN_WOOL_WIRE);
		LIST.add(RED_WOOL_WIRE);
		LIST.add(BLACK_WOOL_WIRE);
		addFireInfo();
	}
	
	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		initalizeBlocks();
		IForgeRegistry<Block> blockRegistry = blockRegistryEvent.getRegistry();
		blockRegistry.registerAll(LIST.toArray(new Block[0]));
	}

	public static Block create(Material material, MaterialColor map, float h, float r, int l, ToolType type, SoundType sound, ResourceLocation loc) {
		Properties propeties = Properties.create(material);
		propeties.hardnessAndResistance(h, r).harvestLevel(l).harvestTool(type);
		propeties.sound(sound);
		Block block = new Block(propeties);
		block.setRegistryName(loc);
		return block;
	}
	
	public static Block create(Material material, float har, int l, ToolType type, SoundType sound, ResourceLocation loc) {
		return create(material, material.getColor(), har, har, l, type, sound, loc);
	}
	
	public static Block create(ResourceLocation loc) {
		return create(Material.ROCK, 0.0f, -1, null, SoundType.STONE, loc);
	}

	public static Block createOre(Material material, float f, float g, int i, ToolType type, SoundType sound,
			ResourceLocation resourceLocation, int min, int max) {
		Properties propeties = Properties.create(material);
		propeties.hardnessAndResistance(f, g).harvestLevel(i).harvestTool(type);
		propeties.sound(sound);
		Block block = new ExperienceBlock(propeties, min, max);
		block.setRegistryName(resourceLocation);
		return block;
	}
	
	public static void addFireInfo() {
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFireInfo(LIGNITE_BLOCK, 10, 10);
		fire.setFireInfo(WHITE_WOOL_WIRE, 20, 40);
		fire.setFireInfo(ORANGE_WOOL_WIRE, 20, 40);
		fire.setFireInfo(MAGENTA_WOOL_WIRE, 20, 40);
		fire.setFireInfo(LIGHT_BLUE_WOOL_WIRE, 20, 40);
		fire.setFireInfo(YELLOW_WOOL_WIRE, 20, 40);
		fire.setFireInfo(LIME_WOOL_WIRE, 20, 40);
		fire.setFireInfo(PINK_WOOL_WIRE, 20, 40);
		fire.setFireInfo(GRAY_WOOL_WIRE, 20, 40);
		fire.setFireInfo(LIGHT_GRAY_WOOL_WIRE, 20, 40);
		fire.setFireInfo(CYAN_WOOL_WIRE, 20, 40);
		fire.setFireInfo(PURPLE_WOOL_WIRE, 20, 40);
		fire.setFireInfo(BLUE_WOOL_WIRE, 20, 40);
		fire.setFireInfo(BROWN_WOOL_WIRE, 20, 40);
		fire.setFireInfo(GREEN_WOOL_WIRE, 20, 40);
		fire.setFireInfo(RED_WOOL_WIRE, 20, 40);
		fire.setFireInfo(BLACK_WOOL_WIRE, 20, 40);
	}
}
