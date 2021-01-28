package com.mreyeballs29.itnc.item;

import java.util.ArrayList;
import java.util.List;

import com.mreyeballs29.itnc.block.INCBlocks;
import com.mreyeballs29.itnc.fluid.INCFluids;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("itnc")
public class INCItems {
	
	private static final List<Item> GENERIC = new ArrayList<>();
	private static final List<Item> BLOCK = new ArrayList<>();
	
	public static final Item POLISHED_STONE = importBlock(INCBlocks.POLISHED_STONE, ItemGroup.BUILDING_BLOCKS);
	public static final Item POLISHED_STONE_SLAB = importBlock(INCBlocks.POLISHED_STONE_SLAB, ItemGroup.BUILDING_BLOCKS);
	public static final Item POLISHED_STONE_STAIRS = importBlock(INCBlocks.POLISHED_STONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
	public static final Item IRON_FRAME = importBlock(INCBlocks.IRON_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "iron_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GOLD_FRAME = importBlock(INCBlocks.GOLD_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "gold_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_ORE = importBlock(INCBlocks.COPPER_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "copper_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_BLOCK = importBlock(INCBlocks.COPPER_BLOCK, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "copper_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_FRAME = importBlock(INCBlocks.COPPER_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "copper_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_ORE = importBlock(INCBlocks.TIN_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "tin_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_BLOCK = importBlock(INCBlocks.TIN_BLOCK, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "tin_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_FRAME = importBlock(INCBlocks.TIN_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "tin_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_ORE = importBlock(INCBlocks.SILVER_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "silver_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_BLOCK = importBlock(INCBlocks.SILVER_BLOCK, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "silver_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_FRAME = importBlock(INCBlocks.SILVER_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "silver_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_ORE = importBlock(INCBlocks.LEAD_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "lead_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_BLOCK = importBlock(INCBlocks.LEAD_BLOCK, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "lead_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_FRAME = importBlock(INCBlocks.LEAD_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "lead_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_BLOCK = importBlock(INCBlocks.BRONZE_BLOCK, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "bronze_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_FRAME = importBlock(INCBlocks.BRONZE_FRAME, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "bronze_frame")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIGNITE_ORE = importBlock(INCBlocks.LIGNITE_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "lignite_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIGNITE_BLOCK = importFuelBlock(INCBlocks.LIGNITE_BLOCK, ItemGroup.BUILDING_BLOCKS, 4000, new ResourceLocation("itnc", "lignite_block")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item OILSHALE_ORE = importBlock(INCBlocks.OILSHALE_ORE, ItemGroup.BUILDING_BLOCKS);
	public static final Item NETHER_GOLD_ORE = importBlock(INCBlocks.NETHER_GOLD_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "nether_gold_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item NETHER_IRON_ORE = importBlock(INCBlocks.NETHER_IRON_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "nether_iron_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item NETHER_COPPER_ORE = importBlock(INCBlocks.NETHER_COPPER_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "nether_copper_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item END_TIN_ORE = importBlock(INCBlocks.END_TIN_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "end_tin_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item END_SILVER_ORE = importBlock(INCBlocks.END_SILVER_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "end_silver_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item NETHER_LEAD_ORE = importBlock(INCBlocks.NETHER_LEAD_ORE, ItemGroup.BUILDING_BLOCKS, new ResourceLocation("itnc", "nether_lead_ore")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item WHITE_WOOL_WIRE = importFuelBlock(INCBlocks.WHITE_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "white_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item ORANGE_WOOL_WIRE = importFuelBlock(INCBlocks.ORANGE_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "orange_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item MAGENTA_WOOL_WIRE = importFuelBlock(INCBlocks.MAGENTA_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "magenta_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIGHT_BLUE_WOOL_WIRE = importFuelBlock(INCBlocks.LIGHT_BLUE_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "light_blue_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item YELLOW_WOOL_WIRE = importFuelBlock(INCBlocks.YELLOW_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "yellow_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIME_WOOL_WIRE = importFuelBlock(INCBlocks.LIME_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "lime_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item PINK_WOOL_WIRE = importFuelBlock(INCBlocks.PINK_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "pink_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GRAY_WOOL_WIRE = importFuelBlock(INCBlocks.GRAY_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "gray_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIGHT_GRAY_WOOL_WIRE = importFuelBlock(INCBlocks.LIGHT_GRAY_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "light_gray_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item CYAN_WOOL_WIRE = importFuelBlock(INCBlocks.CYAN_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "cyan_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item PURPLE_WOOL_WIRE = importFuelBlock(INCBlocks.PURPLE_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "purple_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BLUE_WOOL_WIRE = importFuelBlock(INCBlocks.BLUE_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "blue_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BROWN_WOOL_WIRE = importFuelBlock(INCBlocks.BROWN_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "brown_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GREEN_WOOL_WIRE = importFuelBlock(INCBlocks.GREEN_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "green_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item RED_WOOL_WIRE = importFuelBlock(INCBlocks.RED_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "red_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BLACK_WOOL_WIRE = importFuelBlock(INCBlocks.BLACK_WOOL_WIRE, ItemGroup.DECORATIONS, 50, new ResourceLocation("itnc", "black_wool_wire")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item OAK_CRATE = importFuelBlock(INCBlocks.OAK_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "oak_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SPRUCE_CRATE = importFuelBlock(INCBlocks.SPRUCE_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "spruce_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BIRCH_CRATE = importFuelBlock(INCBlocks.BIRCH_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "birch_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item JUNGLE_CRATE = importFuelBlock(INCBlocks.JUNGLE_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "jungle_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item ACACIA_CRATE = importFuelBlock(INCBlocks.ACACIA_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "acacia_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item DARK_OAK_CRATE = importFuelBlock(INCBlocks.DARK_OAK_CRATE, ItemGroup.DECORATIONS, 300, new ResourceLocation("itnc", "dark_oak_crate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TANK = importBlock(INCBlocks.TANK, ItemGroup.DECORATIONS, new ResourceLocation("itnc", "tank")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item IRON_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "iron_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GOLD_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "gold_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item IRON_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "iron_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GOLD_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "gold_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item IRON_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "iron_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GOLD_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "gold_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item IRON_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "iron_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item GOLD_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "gold_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_NUGGET = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_nugget")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_SHOVEL = createShovel(ItemTier.COPPER, ItemGroup.TOOLS, new ResourceLocation("itnc","copper")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_PICKAXE = createPickaxe(ItemTier.COPPER, ItemGroup.TOOLS, new ResourceLocation("itnc","copper")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_AXE = createAxe(ItemTier.COPPER, 6.5F, -3.1F, ItemGroup.TOOLS, new ResourceLocation("itnc","copper")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_SWORD = createSword(ItemTier.COPPER, ItemGroup.COMBAT, new ResourceLocation("itnc","copper")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_HOE = createHoe(ItemTier.COPPER, -1.5F, ItemGroup.TOOLS, new ResourceLocation("itnc","copper")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_HELMET = createArmor(ArmorMaterial.COPPER, EquipmentSlotType.HEAD, ItemGroup.COMBAT, new ResourceLocation("itnc", "copper_helmet")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_CHESTPLATE = createArmor(ArmorMaterial.COPPER, EquipmentSlotType.CHEST, ItemGroup.COMBAT, new ResourceLocation("itnc", "copper_chestplate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_LEGGINGS = createArmor(ArmorMaterial.COPPER, EquipmentSlotType.LEGS, ItemGroup.COMBAT, new ResourceLocation("itnc", "copper_leggings")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_BOOTS = createArmor(ArmorMaterial.COPPER, EquipmentSlotType.FEET, ItemGroup.COMBAT, new ResourceLocation("itnc", "copper_boots")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_HORSE_ARMOR = createHorseArmor(4, new ResourceLocation("itnc:textures/entity/horse/armor/horse_armor_copper.png"), ItemGroup.MISC, new ResourceLocation("itnc", "copper_horse_armor")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	public static final Item SILVER_HORSE_ARMOR = createHorseArmor(6, new ResourceLocation("itnc:textures/entity/horse/armor/horse_armor_silver.png"), ItemGroup.MISC, new ResourceLocation("itnc", "silver_horse_armor")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	public static final Item LEAD_HORSE_ARMOR = createHorseArmor(5, new ResourceLocation("itnc:textures/entity/horse/armor/horse_armor_lead.png"), ItemGroup.MISC, new ResourceLocation("itnc", "lead_horse_armor")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	public static final Item COPPER_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item COPPER_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "copper_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_NUGGET = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_nugget")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item TIN_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "tin_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_NUGGET = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_nugget")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_SHOVEL = createShovel(ItemTier.SILVER, ItemGroup.TOOLS, new ResourceLocation("itnc", "silver")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_PICKAXE = createPickaxe(ItemTier.SILVER, ItemGroup.TOOLS, new ResourceLocation("itnc", "silver")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_AXE = createAxe(ItemTier.SILVER, 6.0F, -3.0F, ItemGroup.TOOLS, new ResourceLocation("itnc", "silver")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_SWORD = createSword(ItemTier.SILVER, ItemGroup.COMBAT, new ResourceLocation("itnc","silver")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_HOE = createHoe(ItemTier.SILVER, -2F, ItemGroup.TOOLS, new ResourceLocation("itnc", "silver")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_HELMET = createArmor(ArmorMaterial.SILVER, EquipmentSlotType.HEAD, ItemGroup.COMBAT, new ResourceLocation("itnc", "silver_helmet")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_CHESTPLATE = createArmor(ArmorMaterial.SILVER, EquipmentSlotType.CHEST, ItemGroup.COMBAT, new ResourceLocation("itnc", "silver_chestplate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_LEGGINGS = createArmor(ArmorMaterial.SILVER, EquipmentSlotType.LEGS, ItemGroup.COMBAT, new ResourceLocation("itnc", "silver_leggings")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_BOOTS = createArmor(ArmorMaterial.SILVER, EquipmentSlotType.FEET, ItemGroup.COMBAT, new ResourceLocation("itnc", "silver_boots")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item SILVER_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "silver_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LIGNITE = new FuelItem(new Properties().group(ItemGroup.MATERIALS), 400).setRegistryName(new ResourceLocation("itnc", "lignite")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item MAGNETIC_IRON_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "magnetic_iron_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item OILSHALE_DUST =new FuelItem(new Properties().group(ItemGroup.MATERIALS), 400).setRegistryName("itnc", "oilshale_dust"); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_NUGGET = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_nugget")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_SHOVEL = createShovel(ItemTier.LEAD, ItemGroup.TOOLS, new ResourceLocation("itnc", "lead")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_PICKAXE = createPickaxe(ItemTier.LEAD, ItemGroup.TOOLS, new ResourceLocation("itnc", "lead")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_AXE = createAxe(ItemTier.LEAD, 5.5F, -3.1F, ItemGroup.TOOLS, new ResourceLocation("itnc", "lead")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_SWORD = createSword(ItemTier.LEAD, ItemGroup.COMBAT, new ResourceLocation("itnc","lead")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_HOE = createHoe(ItemTier.LEAD, -1.5F, ItemGroup.TOOLS, new ResourceLocation("itnc", "lead")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_HELMET = createArmor(ArmorMaterial.LEAD, EquipmentSlotType.HEAD, ItemGroup.COMBAT, new ResourceLocation("itnc", "lead_helmet")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_CHESTPLATE = createArmor(ArmorMaterial.LEAD, EquipmentSlotType.CHEST, ItemGroup.COMBAT, new ResourceLocation("itnc", "lead_chestplate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_LEGGINGS = createArmor(ArmorMaterial.LEAD, EquipmentSlotType.LEGS, ItemGroup.COMBAT, new ResourceLocation("itnc", "lead_leggings")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_BOOTS = createArmor(ArmorMaterial.LEAD, EquipmentSlotType.FEET, ItemGroup.COMBAT, new ResourceLocation("itnc", "lead_boots")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item LEAD_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "lead_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_MIXTURE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_mixture")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_DUST = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_dust")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_INGOT = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_ingot")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_NUGGET = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_nugget")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_PLATE = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_plate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_ROD = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_rod")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_GEAR = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "bronze_gear")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_SHOVEL = createShovel(ItemTier.BRONZE, ItemGroup.TOOLS, new ResourceLocation("itnc","bronze")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_PICKAXE = createPickaxe(ItemTier.BRONZE, ItemGroup.TOOLS, new ResourceLocation("itnc","bronze")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_AXE = createAxe(ItemTier.BRONZE, 6.0F, -3.1F, ItemGroup.TOOLS, new ResourceLocation("itnc","bronze")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_SWORD = createSword(ItemTier.BRONZE, ItemGroup.COMBAT, new ResourceLocation("itnc","bronze")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_HOE = createHoe(ItemTier.BRONZE, -1.0F, ItemGroup.TOOLS, new ResourceLocation("itnc","bronze")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_HELMET = createArmor(ArmorMaterial.BRONZE, EquipmentSlotType.HEAD, ItemGroup.COMBAT, new ResourceLocation("itnc", "bronze_helmet")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_CHESTPLATE = createArmor(ArmorMaterial.BRONZE, EquipmentSlotType.CHEST, ItemGroup.COMBAT, new ResourceLocation("itnc", "bronze_chestplate")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_LEGGINGS = createArmor(ArmorMaterial.BRONZE, EquipmentSlotType.LEGS, ItemGroup.COMBAT, new ResourceLocation("itnc", "bronze_leggings")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_BOOTS = createArmor(ArmorMaterial.BRONZE, EquipmentSlotType.FEET, ItemGroup.COMBAT, new ResourceLocation("itnc", "bronze_boots")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item BRONZE_HORSE_ARMOR = createHorseArmor(5, new ResourceLocation("itnc:textures/entity/horse/armor/horse_armor_bronze.png"), ItemGroup.MISC, new ResourceLocation("itnc", "bronze_horse_armor")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	public static final Item REDSTONE_CRYSTAL = create(ItemGroup.MATERIALS, new ResourceLocation("itnc", "redstone_crystal")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item FLINT_AND_IRON = new IgnitionItem(new Properties().maxDamage(32).group(ItemGroup.TOOLS)).setRegistryName(new ResourceLocation("itnc", "flint_and_iron")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item OIL_BUCKET = new BucketItem(INCFluids.OIL.delegate, new Properties().group(ItemGroup.MISC).maxStackSize(1).containerItem(Items.BUCKET)).setRegistryName("itnc", "oil_bucket"); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item STONE_BOWL = create(ItemGroup.MISC, new ResourceLocation("itnc", "stone_bowl")); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item MORTAR_AND_FLINT_PESTLE = new MortarItem(create(ItemGroup.TOOLS), 78).setRegistryName("itnc", "mortar_and_flint_pestle"); //$NON-NLS-1$ //$NON-NLS-2$
	public static final Item MORTAR_AND_IRON_PESTLE = new MortarItem(create(ItemGroup.TOOLS), 250);
	
	/**
	 * This organizes by the relavant of each item/block. Blocks come first then items.
	 */
	private static void initalizeItems() {
		BLOCK.add(POLISHED_STONE);
		BLOCK.add(POLISHED_STONE_STAIRS);
		BLOCK.add(POLISHED_STONE_SLAB);
		BLOCK.add(IRON_FRAME);
		BLOCK.add(GOLD_FRAME);
		BLOCK.add(COPPER_ORE);
		BLOCK.add(TIN_ORE);
		BLOCK.add(SILVER_ORE);
		BLOCK.add(LEAD_ORE);
		BLOCK.add(LIGNITE_ORE);
		BLOCK.add(OILSHALE_ORE);
		BLOCK.add(COPPER_BLOCK);
		BLOCK.add(TIN_BLOCK);
		BLOCK.add(SILVER_BLOCK);
		BLOCK.add(LEAD_BLOCK);
		BLOCK.add(BRONZE_BLOCK);
		BLOCK.add(LIGNITE_BLOCK);
		BLOCK.add(COPPER_FRAME);
		BLOCK.add(TIN_FRAME);
		BLOCK.add(SILVER_FRAME);
		BLOCK.add(LEAD_FRAME);
		BLOCK.add(BRONZE_FRAME);
		BLOCK.add(NETHER_IRON_ORE);
		BLOCK.add(NETHER_GOLD_ORE);
		BLOCK.add(NETHER_COPPER_ORE);
		/*
		 * Although lead comes after silver it is still a nether ore. 
		 */
		BLOCK.add(NETHER_LEAD_ORE);
		BLOCK.add(END_TIN_ORE);
		BLOCK.add(END_SILVER_ORE);
		BLOCK.add(WHITE_WOOL_WIRE);
		BLOCK.add(ORANGE_WOOL_WIRE);
		BLOCK.add(MAGENTA_WOOL_WIRE);
		BLOCK.add(LIGHT_BLUE_WOOL_WIRE);
		BLOCK.add(YELLOW_WOOL_WIRE);
		BLOCK.add(LIME_WOOL_WIRE);
		BLOCK.add(PINK_WOOL_WIRE);
		BLOCK.add(GRAY_WOOL_WIRE);
		BLOCK.add(LIGHT_GRAY_WOOL_WIRE);
		BLOCK.add(CYAN_WOOL_WIRE);
		BLOCK.add(PURPLE_WOOL_WIRE);
		BLOCK.add(BLUE_WOOL_WIRE);
		BLOCK.add(BROWN_WOOL_WIRE);
		BLOCK.add(GREEN_WOOL_WIRE);
		BLOCK.add(RED_WOOL_WIRE);
		BLOCK.add(BLACK_WOOL_WIRE);
		BLOCK.add(OAK_CRATE);
		BLOCK.add(SPRUCE_CRATE);
		BLOCK.add(BIRCH_CRATE);
		BLOCK.add(JUNGLE_CRATE);
		BLOCK.add(ACACIA_CRATE);
		BLOCK.add(DARK_OAK_CRATE);
		BLOCK.add(TANK);
		GENERIC.add(IRON_DUST);
		GENERIC.add(GOLD_DUST);
		GENERIC.add(IRON_PLATE);
		GENERIC.add(GOLD_PLATE);
		GENERIC.add(IRON_ROD);
		GENERIC.add(GOLD_ROD);
		GENERIC.add(IRON_GEAR);
		GENERIC.add(GOLD_GEAR);
		GENERIC.add(REDSTONE_CRYSTAL);
		GENERIC.add(STONE_BOWL);
		// Modded items must be after vanilla plus components
		GENERIC.add(COPPER_INGOT);
		GENERIC.add(TIN_INGOT);
		GENERIC.add(SILVER_INGOT);
		GENERIC.add(LEAD_INGOT);
		GENERIC.add(BRONZE_INGOT);
		GENERIC.add(MAGNETIC_IRON_INGOT);
		GENERIC.add(COPPER_NUGGET);
		GENERIC.add(TIN_NUGGET);
		GENERIC.add(SILVER_NUGGET);
		GENERIC.add(LEAD_NUGGET);
		GENERIC.add(BRONZE_NUGGET);
		GENERIC.add(LIGNITE);
		GENERIC.add(OIL_BUCKET);
		GENERIC.add(COPPER_DUST);
		GENERIC.add(TIN_DUST);
		GENERIC.add(SILVER_DUST);
		GENERIC.add(LEAD_DUST);
		GENERIC.add(BRONZE_DUST);
		GENERIC.add(OILSHALE_DUST);
		GENERIC.add(BRONZE_MIXTURE);
		GENERIC.add(COPPER_SHOVEL);
		GENERIC.add(COPPER_PICKAXE);
		GENERIC.add(COPPER_AXE);
		GENERIC.add(COPPER_SWORD);
		GENERIC.add(SILVER_SHOVEL);
		GENERIC.add(SILVER_PICKAXE);
		GENERIC.add(SILVER_AXE);
		GENERIC.add(SILVER_SWORD);
		GENERIC.add(LEAD_SHOVEL);
		GENERIC.add(LEAD_PICKAXE);
		GENERIC.add(LEAD_AXE);
		GENERIC.add(LEAD_SWORD);
		GENERIC.add(BRONZE_SHOVEL);
		GENERIC.add(BRONZE_PICKAXE);
		GENERIC.add(BRONZE_AXE);
		GENERIC.add(BRONZE_SWORD);
		GENERIC.add(COPPER_HOE);
	    GENERIC.add(SILVER_HOE);
	    GENERIC.add(LEAD_HOE);
	    GENERIC.add(BRONZE_HOE);
	    /*
	     * Flint and Tinder items should be after hoes
	     */
	    GENERIC.add(FLINT_AND_IRON);
	    /*
	     * Other Tool Related Items go here
	     */
	    GENERIC.add(MORTAR_AND_FLINT_PESTLE);
	    /*
	     * Armors including horse armors go here.
	     */
		GENERIC.add(COPPER_HELMET);
		GENERIC.add(COPPER_CHESTPLATE);
		GENERIC.add(COPPER_LEGGINGS);
		GENERIC.add(COPPER_BOOTS);
		GENERIC.add(SILVER_HELMET);
		GENERIC.add(SILVER_CHESTPLATE);
		GENERIC.add(SILVER_LEGGINGS);
		GENERIC.add(SILVER_BOOTS);
		GENERIC.add(LEAD_HELMET);
		GENERIC.add(LEAD_CHESTPLATE);
		GENERIC.add(LEAD_LEGGINGS);
		GENERIC.add(LEAD_BOOTS);
		GENERIC.add(BRONZE_HELMET);
		GENERIC.add(BRONZE_CHESTPLATE);
		GENERIC.add(BRONZE_LEGGINGS);
		GENERIC.add(BRONZE_BOOTS);
		GENERIC.add(COPPER_HORSE_ARMOR);
		GENERIC.add(SILVER_HORSE_ARMOR);
		GENERIC.add(LEAD_HORSE_ARMOR);
		GENERIC.add(BRONZE_HORSE_ARMOR);
		/*
		 * Other components should be after horse armors
		 */
		GENERIC.add(COPPER_PLATE);
		GENERIC.add(TIN_PLATE);
		GENERIC.add(SILVER_PLATE);
		GENERIC.add(LEAD_PLATE);
		GENERIC.add(BRONZE_PLATE);
		GENERIC.add(COPPER_ROD);
		GENERIC.add(TIN_ROD);
		GENERIC.add(SILVER_ROD);
		GENERIC.add(LEAD_ROD);
		GENERIC.add(BRONZE_ROD);
		GENERIC.add(COPPER_GEAR);
		GENERIC.add(TIN_GEAR);
		GENERIC.add(SILVER_GEAR);
		GENERIC.add(LEAD_GEAR);
		GENERIC.add(BRONZE_GEAR);
	}

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
		initalizeItems();
		IForgeRegistry<Item> itemRegistry = itemRegistryEvent.getRegistry();
		itemRegistry.registerAll(BLOCK.toArray(new Item[0]));
		itemRegistry.registerAll(GENERIC.toArray(new Item[0]));
	}
	
	private static Properties create(ItemGroup group) {
		Properties propeties = new Properties();
		propeties.group(group);
		return propeties;
	}
	
	public static Item create(ItemGroup group, ResourceLocation loc) {
		Item item = new Item(create(group));
		item.setRegistryName(loc);
		return item;
	}

	public static BlockItem importBlock(Block block, ItemGroup group, ResourceLocation loc) {
		BlockItem blockItem = new BlockItem(block, create(group));
		blockItem.setRegistryName(loc);
		return blockItem;
	}
	
	public static BlockItem importBlock(Block block, ItemGroup group) {
		return importBlock(block, group, block.getRegistryName());
	}
	
	public static PickaxeItem createPickaxe(IItemTier tier, ItemGroup group, ResourceLocation loc) {
		PickaxeItem pickaxeItem = new PickaxeItem(tier, 1, -2.8F, create(group));
		pickaxeItem.setRegistryName(loc + "_pickaxe"); //$NON-NLS-1$
		return pickaxeItem;
	}
	
	public static AxeItem createAxe(IItemTier tier, float damage, float speed, ItemGroup group, ResourceLocation loc) {
		AxeItem axeItem = new AxeItem(tier, damage, speed, create(group));
		axeItem.setRegistryName(loc + "_axe"); //$NON-NLS-1$
		return axeItem;
	}
	
	public static ShovelItem createShovel(IItemTier tier, ItemGroup group, ResourceLocation loc) {
		ShovelItem shovelItem = new ShovelItem(tier, 1.5F, -3.0F, create(group));
		shovelItem.setRegistryName(loc + "_shovel"); //$NON-NLS-1$
		return shovelItem;
	}
	
	public static HoeItem createHoe(IItemTier tier, float speed, ItemGroup group, ResourceLocation loc) {
		HoeItem hoeItem = new HoeItem(tier, speed, create(group));
		hoeItem.setRegistryName(loc + "_hoe"); //$NON-NLS-1$
		return hoeItem;
	}
	
	public static SwordItem createSword(IItemTier tier, ItemGroup group, ResourceLocation loc) {
		SwordItem swordItem = new SwordItem(tier, 3, -2.4F, create(group));
		swordItem.setRegistryName(loc + "_sword"); //$NON-NLS-1$
		return swordItem;
	}

	public static ArmorItem createArmor(IArmorMaterial materialIn, EquipmentSlotType slot, ItemGroup group, ResourceLocation loc) {
		ArmorItem armorItem = new ArmorItem(materialIn, slot, create(group));
		armorItem.setRegistryName(loc);
		return armorItem;
	}
	
	public static HorseArmorItem createHorseArmor(int points, ResourceLocation texture, ItemGroup group, ResourceLocation loc) {
		HorseArmorItem horseArmorItem = new HorseArmorItem(points, texture, create(group).maxStackSize(1));
		horseArmorItem.setRegistryName(loc);
		return horseArmorItem;
	}
	
	public static FuelBlockItem importFuelBlock(Block block, ItemGroup group, int time, ResourceLocation loc) {
		FuelBlockItem fuelBlockItem = new FuelBlockItem(block, create(group), time);
		fuelBlockItem.setRegistryName(loc);
		return fuelBlockItem;
	}
}
