package com.mreyeballs29.issactncore.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemScanner extends Item {

	@SuppressWarnings("deprecation")
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		String resistance = String.valueOf(block.getExplosionResistance(worldIn, pos, player, null));
		String hardness = String.valueOf(block.getBlockHardness(state, worldIn, pos));
		String name = block.getLocalizedName();
		if (block.getMaterial(state) == Material.IRON) {
			worldIn.playSound(player, pos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.75f, 0.8F);
		} else {
			worldIn.playSound(player, pos, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.BLOCKS, 0.75F, 1.0F);
		}
		
		Minecraft.getMinecraft().ingameGUI.setOverlayMessage(name + ": " + hardness + ", " + resistance, false);
		return EnumActionResult.SUCCESS;
	}
}
