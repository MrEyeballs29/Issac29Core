package com.mreyeballs29.issactncore;

import org.apache.logging.log4j.Logger;

import com.mreyeballs29.issactncore.init.I29CBlocks;
import com.mreyeballs29.issactncore.init.I29CItems;
import com.mreyeballs29.issactncore.item.EnumBaseMetal;
import com.mreyeballs29.issactncore.item.EnumPreciousMetal;
import com.mreyeballs29.issactncore.proxy.CommonProxy;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
/**
 * A instance class for a mod to start on. Also known as the root class
 * for just an ordinary class.
 * @author MrEyeballs29
 * @see net.minecraftforge.fml.common.Mod Mod
 */
@Mod(modid = "i29c", name = "Issac29 Core", version = "1.0.0", useMetadata = true, acceptedMinecraftVersions="1.12.2")
public class Issac29Core {
	
	/**
	 * A logger used for debugging or also for developers.
	 */
	public static Logger log;
	
	/**
	 * A proxy if some sides include server or client like tooltips
	 * only appear on client proxy
	 */
	@SidedProxy(clientSide="com.mreyeballs29.issactncore.proxy.ClientProxy", serverSide="com.mreyeballs29.issactncore.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	/**
	 * The preinitialization stage allows to setup variables and also 
	 * for blocks and items. Blocks have to register first otherwise it 
	 * will cause an fatal error. 
	 * 
	 * <p>
	 * The static method also has a log setup too.
	 * @param event Used for creating configuration files, logger, and
	 * for source files.
	 */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		proxy.preInit();
	}
	/**
	 * The initialization stage allows to add recipes setup tile entities
	 * and also for many other things that are after the block setup.
	 * @param event The parameter used for not really anything.
	 */
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
		OreDictionary.registerOre("gearIron", I29CItems.IRON_GEAR);
		OreDictionary.registerOre("gearGold", I29CItems.GOLD_GEAR);
		OreDictionary.registerOre("frameIron", I29CBlocks.IRON_FRAME);
		OreDictionary.registerOre("frameGold", I29CBlocks.GOLD_FRAME);
		OreDictionary.registerOre("plateIron", I29CItems.IRON_PLATE);
		OreDictionary.registerOre("plateGold", I29CItems.GOLD_PLATE);
		OreDictionary.registerOre("rodIron", I29CItems.IRON_ROD);
		OreDictionary.registerOre("stickIron", I29CItems.IRON_ROD);
		OreDictionary.registerOre("rodGold", I29CItems.GOLD_ROD);
		OreDictionary.registerOre("structureIron", I29CBlocks.IRON_PLATE_BLOCK);
		OreDictionary.registerOre("structureGold", I29CBlocks.GOLD_PLATE_BLOCK);
		OreDictionary.registerOre("plankWood", I29CBlocks.WOOD_PLANK);
		OreDictionary.registerOre("stickWood", new ItemStack(I29CItems.TREE_STICK, 1,
				OreDictionary.WILDCARD_VALUE));
		for (EnumBaseMetal metal : EnumBaseMetal.values()) {
			OreDictionary.registerOre("ingot"+metal.getUnlocalizedName(),
					new ItemStack(I29CItems.BASE_INGOT, 1, metal.getId()));
		}
		for (EnumPreciousMetal metal : EnumPreciousMetal.values()) {
			OreDictionary.registerOre("ingot"+metal.getUnlocalizedName(),
					new ItemStack(I29CItems.PRECIOUS_INGOT, 1, metal.getId()));
		}
		OreDictionary.registerOre("dustSand", new ItemStack(I29CItems.SAND, 1, OreDictionary.WILDCARD_VALUE));
		
		// Vanilla Extras
		
		for (EnumType type : EnumType.values()) {
			OreDictionary.registerOre(
				"plank"+str_sm_01(type.getName()), 
				new ItemStack(Blocks.PLANKS, 1, type.getMetadata()));
			OreDictionary.registerOre(
				"stick"+str_sm_01(type.getName()), 
				new ItemStack(I29CItems.TREE_STICK, 1, type.getMetadata()));
			OreDictionary.registerOre(
				"slab"+str_sm_01(type.getName()),
				new ItemStack(Blocks.WOODEN_SLAB, 1, type.getMetadata()));
		}
		for (int i = 0; i < 4; i++) {
			OreDictionary.registerOre(
				"log"+str_sm_01(EnumType.byMetadata(i).getName()),
				new ItemStack(Blocks.LOG, 1, i));
		}
		for (int i = 0; i < 2; i++) {
			OreDictionary.registerOre(
				"log"+str_sm_01(EnumType.byMetadata(i+4).getName()),
				new ItemStack(Blocks.LOG2, 1, i));
		}
	    OreDictionary.registerOre("stairOak",   Blocks.OAK_STAIRS);
	    OreDictionary.registerOre("stairSpruce",   Blocks.SPRUCE_STAIRS);
	    OreDictionary.registerOre("stairBirch",   Blocks.BIRCH_STAIRS);
	    OreDictionary.registerOre("stairJungle",   Blocks.JUNGLE_STAIRS);
	    OreDictionary.registerOre("stairAcacia",   Blocks.ACACIA_STAIRS);
	    OreDictionary.registerOre("stairDarkOak",   Blocks.DARK_OAK_STAIRS);
	    OreDictionary.registerOre("fenceOak", Blocks.OAK_FENCE);
	    OreDictionary.registerOre("fenceSpruce", Blocks.SPRUCE_FENCE);
	    OreDictionary.registerOre("fenceBirch", Blocks.BIRCH_FENCE);
	    OreDictionary.registerOre("fenceJungle", Blocks.JUNGLE_FENCE);
	    OreDictionary.registerOre("fenceDarkOak", Blocks.DARK_OAK_FENCE);
	    OreDictionary.registerOre("fenceAcacia", Blocks.ACACIA_FENCE);
	    OreDictionary.registerOre("fenceGateOak", Blocks.OAK_FENCE_GATE);
	    OreDictionary.registerOre("fenceGateSpruce", Blocks.SPRUCE_FENCE_GATE);
	    OreDictionary.registerOre("fenceGateBirch", Blocks.BIRCH_FENCE_GATE);
	    OreDictionary.registerOre("fenceGateJungle", Blocks.JUNGLE_FENCE_GATE);
	    OreDictionary.registerOre("fenceGateDarkOak", Blocks.DARK_OAK_FENCE_GATE);
	    OreDictionary.registerOre("fenceGateAcacia", Blocks.ACACIA_FENCE_GATE);
	    OreDictionary.registerOre("doorAcacia", Items.ACACIA_DOOR);
	    OreDictionary.registerOre("doorBirch", Items.BIRCH_DOOR);
	    OreDictionary.registerOre("doorDarkOak", Items.DARK_OAK_DOOR);
	    OreDictionary.registerOre("doorOak", Items.OAK_DOOR);
	    OreDictionary.registerOre("doorJungle", Items.JUNGLE_DOOR);
	    OreDictionary.registerOre("doorSpruce", Items.SPRUCE_DOOR);
	}
	
	private static String str_sm_01(String str) {
		str = str.replaceAll("_", " ");
		String[] strarr = str.split(" ");
		str = "";
		for (String str1 : strarr) {
			str += str1.substring(0, 1).toUpperCase() + str1.substring(1);
		}
		return str;
	}
	
	/**
	 * The postinitalization stage is the least important stage because
	 * not many programmers use this section for anything. This is meant
	 * for last event.
	 * @param event The parameter used for not really anything.
	 */
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
}