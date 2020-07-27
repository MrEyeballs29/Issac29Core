package com.mreyeballs29.itnc.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber()
public class ItemActions {
	private static Set<Block> logs = Sets.newHashSet(
			Blocks.OAK_LOG,
			Blocks.BIRCH_LOG,
			Blocks.ACACIA_LOG,
			Blocks.SPRUCE_LOG,
			Blocks.JUNGLE_LOG,
			Blocks.DARK_OAK_LOG,
			Blocks.OAK_WOOD,
			Blocks.BIRCH_WOOD,
			Blocks.ACACIA_WOOD,
			Blocks.SPRUCE_WOOD,
			Blocks.JUNGLE_WOOD,
			Blocks.DARK_OAK_WOOD
	);
	
	@SubscribeEvent
	public static void onItemRightClick(RightClickBlock clickBlock) {
		if (clickBlock.equals(clickBlock)) return;
		ItemStack stack = clickBlock.getItemStack();
		Item item = stack.getItem();
		@SuppressWarnings("resource")
		World world = clickBlock.getWorld();
		BlockState state = world.getBlockState(clickBlock.getPos());
		if (item instanceof AxeItem && logs.contains(state.getBlock())) {
			PlayerEntity player = clickBlock.getPlayer();
			ItemEntity itemEntity = new ItemEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), new ItemStack(INCItems.BRONZE_DUST));
			world.addEntity(itemEntity);
		}
	}
}
