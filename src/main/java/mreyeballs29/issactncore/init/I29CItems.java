package mreyeballs29.issactncore.init;

import java.util.ArrayList;
import java.util.List;

import mreyeballs29.issactncore.Issac29Core;
import mreyeballs29.issactncore.item.EnumBaseMetal;
import mreyeballs29.issactncore.item.EnumPreciousMetal;
import mreyeballs29.issactncore.item.ItemBase;
import mreyeballs29.issactncore.item.ItemBaseIngot;
import mreyeballs29.issactncore.item.ItemPrecious;
import mreyeballs29.issactncore.item.ItemPreciousIngot;
import mreyeballs29.issactncore.item.ItemStick;
import mreyeballs29.issactncore.item.ItemWood;
import mreyeballs29.issactncore.util.EnumShape;
import mreyeballs29.issactncore.util.RTweaks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public final class I29CItems {
	
	static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item IRON_GEAR = new Item();
	public static final Item GOLD_GEAR = new Item();
	public static final Item IRON_PLATE = new Item();
	public static final Item GOLD_PLATE = new Item();
	public static final Item IRON_ROD = new Item();
	public static final Item GOLD_ROD = new Item();
	public static final ItemBaseIngot BASE_INGOT = new ItemBaseIngot();
	public static final ItemPreciousIngot PRECIOUS_INGOT = new ItemPreciousIngot();
	public static final ItemStick TREE_STICK = new ItemStick();
	private static boolean initalized = false;
	
	
	public static void InitalizeItems() {
		if (initalized)
		{
			return;
		}
		IRON_GEAR.setRegistryName(new ResourceLocation("i29c", "iron_gear")).setCreativeTab(CreativeTabs.MISC);
		GOLD_GEAR.setUnlocalizedName("gearGold").setRegistryName(new ResourceLocation("i29c", "gold_gear")).setCreativeTab(CreativeTabs.MISC);
		IRON_PLATE.setUnlocalizedName("plateIron").setRegistryName(new ResourceLocation("i29c", "iron_plate")).setCreativeTab(CreativeTabs.MISC);
		GOLD_PLATE.setUnlocalizedName("plateGold").setRegistryName(new ResourceLocation("i29c", "gold_plate")).setCreativeTab(CreativeTabs.MISC);
		BASE_INGOT.setRegistryName(new ResourceLocation("i29c", "base_ingot")).setUnlocalizedName("ingotBase");
		PRECIOUS_INGOT.setRegistryName(new ResourceLocation("i29c", "precious_ingot")).setUnlocalizedName("ingotPrecious");
		TREE_STICK.setRegistryName(new ResourceLocation("i29c", "stick")).setUnlocalizedName("stickWood");
		IRON_ROD.setUnlocalizedName("rodIron").setRegistryName(new ResourceLocation("i29c", "iron_rod")).setCreativeTab(CreativeTabs.MISC);
		GOLD_ROD.setUnlocalizedName("rodGold").setRegistryName(new ResourceLocation("i29c", "gold_rod")).setCreativeTab(CreativeTabs.MISC);
		Items.REDSTONE.setUnlocalizedName("dustRedstone");
		Items.QUARTZ.setUnlocalizedName("netherQuartz");
		ITEMS.add(IRON_GEAR);
		ITEMS.add(GOLD_GEAR);
		ITEMS.add(IRON_PLATE);
		ITEMS.add(GOLD_PLATE);
		ITEMS.add(IRON_ROD);
		ITEMS.add(GOLD_ROD);
		ITEMS.add(AddBlock(I29CBlocks.IRON_FRAME));
		ITEMS.add(AddBlock(I29CBlocks.GOLD_FRAME));
		ITEMS.add(AddBlock(I29CBlocks.IRON_PLATE_BLOCK));
		ITEMS.add(AddBlock(I29CBlocks.GOLD_PLATE_BLOCK));
		ITEMS.add(TREE_STICK);
		ITEMS.add(AddBlock(I29CBlocks.WOOD_PLANK));
		ITEMS.add(BASE_INGOT);
		ITEMS.add(PRECIOUS_INGOT);
		initalized = true;
	}
	
	private static ItemBlock AddBlock(Block block)
	{
		if (I29CBlocks.BLOCKS.contains(block))
		{
			ItemBlock itbl = new ItemBlock(block);
			itbl.setRegistryName(block.getRegistryName());
			return itbl;
		}
		return null;
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		try {
			event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
		}
		catch (RuntimeException ruex) {
			System.err.println(ruex.getMessage());
		}
		finally {
			OreDictionary.registerOre("gemNetherQuartz", Items.QUARTZ);
		OreDictionary.registerOre("blockNetherQuartz", Blocks.QUARTZ_BLOCK);
		for (EnumType type : EnumType.values()) {
			OreDictionary.registerOre("plank"+str_m_01(type.getName()), new ItemStack(Blocks.PLANKS, 1, type.getMetadata()));
			OreDictionary.registerOre("stick"+str_m_01(type.getName()), new ItemStack(TREE_STICK, 1, type.getMetadata()));
			OreDictionary.registerOre("slab"+str_m_01(type.getName()), new ItemStack(Blocks.WOODEN_SLAB, 1, type.getMetadata()));
		}
		for (int i = 0; i < 4; i++) {
			OreDictionary.registerOre("log"+str_m_01(EnumType.byMetadata(i).getName()), new ItemStack(Blocks.LOG, 1, i));
		}
		for (int i = 0; i < 2; i++) {
			OreDictionary.registerOre("log"+str_m_01(EnumType.byMetadata(i+4).getName()), new ItemStack(Blocks.LOG2, 1, i));
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
	}
	
	private static String str_m_01(String str) {
		str = str.replaceAll("_", " ");
		String[] strarr = str.split(" ");
		str = "";
		for (String str1 : strarr) {
			str += str1.substring(0, 1).toUpperCase() + str1.substring(1);
		}
		return str;
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item it : ITEMS) {
			if (it.getHasSubtypes()) {
				if (it instanceof ItemBase) {
					for (int i = 0; i < 16; i++) {
						Issac29Core.proxy.registerModel(it, i, "inventory", EnumShape.INGOT, EnumBaseMetal.byMetadata(i).getName());
					}
				} 
				else if (it instanceof ItemPrecious) {
					for (int i = 0; i < 16; i++) {
						Issac29Core.proxy.registerModel(it, i, "inventory", EnumShape.INGOT, EnumPreciousMetal.byMetadata(i).getName());
					}
				}
				else if (it instanceof ItemWood) {
					for (int i = 0; i < 6; i++) {
						Issac29Core.proxy.registerModel(it, i, "inventory", EnumShape.STICK, EnumType.byMetadata(i).getName());
					}
				}
			} else {
				Issac29Core.proxy.registerModel(it, 0, "inventory");
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onTooltipRegister(ItemTooltipEvent event) {
		List<String> tooltips = event.getToolTip();
		if (event.getFlags().isAdvanced())
		{
			int i_array[] = OreDictionary.getOreIDs(event.getItemStack());
			for (int i : i_array) {
				tooltips.add(OreDictionary.getOreName(i));
			}
		}
	}
	
	@SubscribeEvent
	public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistryModifiable<IRecipe> modif = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
		modif.remove(new ResourceLocation("minecraft", "stick"));
		try {
			RTweaks recipe = new RTweaks(2, 1, new ItemStack(Items.STICK, 4), "stick", new Ingredient[] {new OreIngredient("plankWood"), new OreIngredient("plankWood")});
			recipe.setRegistryName(new ResourceLocation("minecraft:stick"));
			event.getRegistry().register(recipe);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
