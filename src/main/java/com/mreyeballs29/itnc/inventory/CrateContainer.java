package com.mreyeballs29.itnc.inventory;

import com.mreyeballs29.itnc.tileentity.CrateTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class CrateContainer extends Container {

	private CrateTileEntity tileEntity;
	private InvWrapper playerInventory;
	
	public CrateContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory) {
		super(INContainerTypes.CRATE, id);
		this.tileEntity = (CrateTileEntity) world.getTileEntity(pos);
		this.playerInventory = new InvWrapper(playerInventory);
		this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
			this.addRows(h);
		});
		layoutPlayerInventorySlots(8, 87);
	}

	private void addRows(IItemHandler h) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				this.addSlot(new ManualSlot(h,j + i * 5, 44 + j * 18, 19 + i * 18));
			}
		}
	}
	
	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        addSlotBox(this.playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
        addSlotRange(this.playerInventory, 0, leftCol, topRow + 58, 9, 18);
    }


	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
	     return !(playerIn.getDistanceSq(this.tileEntity.getPos().getX() + 0.5D, this.tileEntity.getPos().getY() + 0.5D, this.tileEntity.getPos().getZ() + 0.5D) > 64.0D);
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index < 15) {
	            if (!this.mergeItemStack(itemstack1, 15, this.inventorySlots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.mergeItemStack(itemstack1, 0, 15, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
	         } else {
	            slot.onSlotChanged();
	         }
	      }

	      return itemstack;
	   }

}
