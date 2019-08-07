package com.mreyeballs29.issactncore.init;

import java.util.ArrayList;
import java.util.List;

import com.mreyeballs29.issactncore.Issac29Core;
import com.mreyeballs29.issactncore.block.BlockCobblestone;
import com.mreyeballs29.issactncore.block.BlockStone2;
import com.mreyeballs29.issactncore.item.ItemBaseIngot;
import com.mreyeballs29.issactncore.item.ItemBlockMeta;
import com.mreyeballs29.issactncore.item.ItemConcretePowder;
import com.mreyeballs29.issactncore.item.ItemElement;
import com.mreyeballs29.issactncore.item.ItemMeta;
import com.mreyeballs29.issactncore.item.ItemPreciousIngot;
import com.mreyeballs29.issactncore.item.ItemScanner;
import com.mreyeballs29.issactncore.item.ItemStick;
import com.mreyeballs29.issactncore.item.ItemBlockMeta.Operation;
import com.mreyeballs29.issactncore.util.RTweaks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.statemap.StateMap;
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
import net.minecraftforge.client.model.ModelLoader;
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
	public static final Item IRON_DUST = new Item();
	public static final Item GOLD_DUST = new Item();
	public static final ItemBaseIngot BASE_INGOT = new ItemBaseIngot();
	public static final ItemPreciousIngot PRECIOUS_INGOT = new ItemPreciousIngot();
	public static final ItemStick TREE_STICK = new ItemStick();
	public static final ItemMeta SAND = new ItemMeta(new String[] {null, "red"});
	public static final ItemConcretePowder DYED_CONCRETE_POWDER = new ItemConcretePowder();
	public static final Item CONCRETE_POWDER = new Item();
	public static final Item SCANNER = new ItemScanner();
	
	private static boolean initalized = false;
	
	
	public static void initalizeItems() {
		if (initalized)
		{
			Issac29Core.log.warn("Item intitalization has intitalized");
			return;
		}
		IRON_GEAR.setUnlocalizedName("gearIron").setRegistryName(new ResourceLocation("i29c", "iron_gear")).setCreativeTab(CreativeTabs.MISC);
		GOLD_GEAR.setUnlocalizedName("gearGold").setRegistryName(new ResourceLocation("i29c", "gold_gear")).setCreativeTab(CreativeTabs.MISC);
		IRON_PLATE.setUnlocalizedName("plateIron").setRegistryName(new ResourceLocation("i29c", "iron_plate")).setCreativeTab(CreativeTabs.MISC);
		GOLD_PLATE.setUnlocalizedName("plateGold").setRegistryName(new ResourceLocation("i29c", "gold_plate")).setCreativeTab(CreativeTabs.MISC);
		BASE_INGOT.setRegistryName(new ResourceLocation("i29c", "base_ingot")).setUnlocalizedName("ingotBase");
		PRECIOUS_INGOT.setRegistryName(new ResourceLocation("i29c", "precious_ingot")).setUnlocalizedName("ingotPrecious");
		TREE_STICK.setRegistryName(new ResourceLocation("i29c", "stick")).setUnlocalizedName("stickWood");
		IRON_ROD.setUnlocalizedName("rodIron").setRegistryName(new ResourceLocation("i29c", "iron_rod")).setCreativeTab(CreativeTabs.MISC);
		GOLD_ROD.setUnlocalizedName("rodGold").setRegistryName(new ResourceLocation("i29c", "gold_rod")).setCreativeTab(CreativeTabs.MISC);
		IRON_DUST.setRegistryName("i29c:iron_dust").setUnlocalizedName("dustIron").setCreativeTab(CreativeTabs.MISC);
		GOLD_DUST.setRegistryName("i29c:gold_dust").setUnlocalizedName("dustGold").setCreativeTab(CreativeTabs.MISC);
		SAND.setUnlocalizedName("sand").setRegistryName(new ResourceLocation("i29c", "sand")).setCreativeTab(CreativeTabs.MISC);
		DYED_CONCRETE_POWDER.setUnlocalizedName("concretePowder").setRegistryName(new ResourceLocation("i29c:concrete_powder")).setCreativeTab(CreativeTabs.MISC);
		CONCRETE_POWDER.setUnlocalizedName("concretePowder").setRegistryName("i29c:concrete_powder_plain").setCreativeTab(CreativeTabs.MISC);
		SCANNER.setRegistryName("i29c:scanner").setCreativeTab(CreativeTabs.TOOLS).setMaxStackSize(1).setUnlocalizedName("scannerPower");
		Items.REDSTONE.setUnlocalizedName("dustRedstone");
		Items.QUARTZ.setUnlocalizedName("quartz");
		ITEMS.add(IRON_GEAR);
		ITEMS.add(GOLD_GEAR);
		ITEMS.add(IRON_PLATE);
		ITEMS.add(GOLD_PLATE);
		ITEMS.add(IRON_ROD);
		ITEMS.add(GOLD_ROD);
		ITEMS.add(IRON_DUST);
		ITEMS.add(GOLD_DUST);
		ITEMS.add(addBlock(I29CBlocks.IRON_FRAME));
		ITEMS.add(addBlock(I29CBlocks.GOLD_FRAME));
		ITEMS.add(addBlock(I29CBlocks.IRON_PLATE_BLOCK));
		ITEMS.add(addBlock(I29CBlocks.GOLD_PLATE_BLOCK));
		ITEMS.add(addBlock(I29CBlocks.IRON_DUST));
		ITEMS.add(addBlock(I29CBlocks.GOLD_DUST));
		ITEMS.add(TREE_STICK);
		ITEMS.add(addBlock(I29CBlocks.WOOD));
		ITEMS.add(addBlock(I29CBlocks.WOOD_PLANK));
		ITEMS.add(addBlock(I29CBlocks.STONE));
		ITEMS.add(addBlockMeta(I29CBlocks.COBBLESTONE, (ItemStack t, boolean tran) -> {
				if (tran) {
					return BlockCobblestone.EnumType.byMetadata(t.getMetadata()).getUnlocalizedName();
				}
				return BlockCobblestone.EnumType.byMetadata(t.getMetadata()).getName();
			}, BlockCobblestone.EnumType.values().length, I29CBlocks.COBBLESTONE.getRegistryName().getResourcePath(),
			I29CBlocks.COBBLESTONE.getUnlocalizedName()
		));
		ITEMS.add(addBlock(I29CBlocks.BEDROCK_COBBLESTONE));
		ITEMS.add(addBlock(I29CBlocks.BEDROCK_SMOOTH));
		ITEMS.add(addBlockMeta(I29CBlocks.STONE2, (ItemStack t, boolean tran) -> {
			if (tran) {
				return BlockStone2.EnumType.byMetadata(t.getMetadata()).getUnlocalizedName();
			}
			return BlockStone2.EnumType.byMetadata(t.getMetadata()).getName();
		}, BlockStone2.EnumType.values().length, null, "tile.stone"));
		ITEMS.add(addBlock(I29CBlocks.CONCRETE));
		ITEMS.add(addBlock(I29CBlocks.CONCRETE_POWDER));
		ITEMS.add(BASE_INGOT);
		ITEMS.add(PRECIOUS_INGOT);
		ITEMS.add(SAND);
		ITEMS.add(DYED_CONCRETE_POWDER);
		ITEMS.add(CONCRETE_POWDER);
		ITEMS.add(SCANNER);
		initalized = true;
		Items.GUNPOWDER.setUnlocalizedName("gunpowder");
	}
	
	@SuppressWarnings("unused")
	private static ItemBlockMeta addBlockMeta(Block block, Operation fun, int length) {
		return addBlockMeta(block, fun, length, null, null);
	}

	private static ItemBlockMeta addBlockMeta(Block block, Operation fun, int length,
			String string, String name) {
		ItemBlockMeta itblm = new ItemBlockMeta(block, fun, length, string, name);
		itblm.setRegistryName(block.getRegistryName());
		return itblm;
	}
	
	private static ItemBlock addBlock(Block block)
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
		initalizeItems();
		Issac29Core.log.info("Fired 2");
		for (Item item : ITEMS) {
			Issac29Core.log.info(item);
		}
		try {
			event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
		}
		catch (RuntimeException ruex) {
			Issac29Core.log.fatal(ruex.getMessage());
			throw ruex;
		}
	}
	
	/**
	 * @param event Used on the model registry event
	 */
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModelLoader.setCustomStateMapper(I29CBlocks.COBBLESTONE, (new StateMap.Builder()).withName(BlockCobblestone.VARIANT).withSuffix("_cobblestone").build());
		ModelLoader.setCustomStateMapper(I29CBlocks.STONE2, (new StateMap.Builder()).withName(BlockStone2.VARIANT).build());
		for (Item it : ITEMS) {
			if (it instanceof ItemElement) {
				((ItemElement)it).registerModels();
			} else if (it instanceof ItemMeta) {
				((ItemMeta)it).registerModels();
			} else if (it instanceof ItemBlockMeta)	{
				((ItemBlockMeta)it).registerModels();
			} else {
				Issac29Core.proxy.registerModel(it, 0, "inventory");
			}
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onTooltipRegister(ItemTooltipEvent event) {
		List<String> tooltips = event.getToolTip();
		Item item = event.getItemStack().getItem();
		if (item == Item.getItemFromBlock(Blocks.IRON_ORE) ||
			item == Item.getItemFromBlock(Blocks.GOLD_ORE) ||
			item == Item.getItemFromBlock(Blocks.COAL_ORE) ||
			item == Item.getItemFromBlock(Blocks.LAPIS_ORE) ||
			item == Item.getItemFromBlock(Blocks.REDSTONE_ORE) ||
			item == Item.getItemFromBlock(Blocks.DIAMOND_ORE) ||
			item == Item.getItemFromBlock(Blocks.EMERALD_ORE)) {
			tooltips.add(Blocks.STONE.getLocalizedName());
		} else if (item == Item.getItemFromBlock(Blocks.QUARTZ_ORE)) {
			tooltips.add(Blocks.NETHERRACK.getLocalizedName());
		}
		if (event.getFlags().isAdvanced())
		{
			int i_array[] = OreDictionary.getOreIDs(event.getItemStack());
			if (i_array.length > 0) {
				tooltips.add(String.valueOf(' '));
				for (int i : i_array) {
					tooltips.add(OreDictionary.getOreName(i));
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistryModifiable<IRecipe> modif = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
		modif.remove(new ResourceLocation("minecraft", "stick"));
		modif.remove(new ResourceLocation("minecraft", "stonebrick"));
		RTweaks recipe = new RTweaks(2, 2, new ItemStack(I29CBlocks.WOOD_PLANK, 3), "wood_plank",
			new Ingredient[] {
				new OreIngredient("plankWood"), new OreIngredient("plankWood"),
				new OreIngredient("plankWood"), Ingredient.EMPTY
			});
		RTweaks stonepolished = new RTweaks(2, 2, new ItemStack(I29CBlocks.STONE, 4), "stone", 
			new Ingredient[] {
				new OreIngredient("stone"), new OreIngredient("stone"),
				new OreIngredient("stone"),	new OreIngredient("stone")
			}
		);
		recipe.setRegistryName(new ResourceLocation("minecraft:stick"));
		stonepolished.setRegistryName(new ResourceLocation("minecraft", "stonebrick"));
		event.getRegistry().register(recipe);
		event.getRegistry().register(stonepolished);
	}
}
