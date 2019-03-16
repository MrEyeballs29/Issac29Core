package mreyeballs29.issactncore.init;

import java.util.ArrayList;
import java.util.List;

import mreyeballs29.issactncore.block.BlockFrame;
import mreyeballs29.issactncore.block.BlockPlate;
import mreyeballs29.issactncore.block.BlockWoodPlank;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class I29CBlocks {
	static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final BlockFrame IRON_FRAME = new BlockFrame(MapColor.IRON, true);
	public static final BlockFrame GOLD_FRAME = new BlockFrame(MapColor.GOLD, true);
	public static final Block IRON_PLATE_BLOCK = new BlockPlate();
	public static final Block GOLD_PLATE_BLOCK = new BlockPlate();
	public static final BlockWoodPlank WOOD_PLANK = new BlockWoodPlank();

	private static boolean initalized = false;

	public static void InitalizeBlocks() {
		if (initalized)
		{
			return;
		}
		IRON_FRAME.setUnlocalizedName("frameIron").setRegistryName(new ResourceLocation("i29c", "iron_frame")).setHardness(2.5F).setResistance(7.5F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHarvestLevel("pickaxe", 1);
		GOLD_FRAME.setUnlocalizedName("frameGold").setRegistryName(new ResourceLocation("i29c", "gold_frame")).setHardness(1.5F).setResistance(7.5F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHarvestLevel("pickaxe", 2);
		WOOD_PLANK.setUnlocalizedName("wood").setRegistryName(new ResourceLocation("i29c", "planks")).setHardness(2.0F).setResistance(5.0F).setHarvestLevel("axe", 0);
		IRON_PLATE_BLOCK.setUnlocalizedName("structureIron").setRegistryName(new ResourceLocation("i29c", "iron_plate_block")).setHardness(5.0F).setResistance(10.0F).setHarvestLevel("pickaxe", 1);
		GOLD_PLATE_BLOCK.setUnlocalizedName("structureGold").setRegistryName(new ResourceLocation("i29c", "gold_plate_block")).setHardness(3.0F).setResistance(10.0F).setHarvestLevel("pickaxe", 2);
		BLOCKS.add(IRON_FRAME);
		BLOCKS.add(GOLD_FRAME);
		BLOCKS.add(WOOD_PLANK);
		BLOCKS.add(IRON_PLATE_BLOCK);
		BLOCKS.add(GOLD_PLATE_BLOCK);
		initalized = true;
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}
}
