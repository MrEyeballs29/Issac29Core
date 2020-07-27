package com.mreyeballs29.itnc.inventory;

import com.mreyeballs29.itnc.tileentity.TankTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TankContainer extends Container {
	
	private TileEntity tileEntity;
	private InvWrapper playerInventory;
	
	public TankContainer(int id, World world, BlockPos pos, PlayerInventory inv) {
		super(INContainerTypes.TANK, id);
		this.tileEntity = world.getTileEntity(pos);
		this.playerInventory = new InvWrapper(inv);
		this.addSlot(new SlotItemHandler(getTileEntity().getInput(), 0, 44, 48));
		this.addSlot(new SlotItemHandler(getTileEntity().getOutput(), 0, 116, 48));
		layoutPlayerInventorySlots(8, 80);
	}
	
	public TankTileEntity getTileEntity() {
		return (TankTileEntity) this.tileEntity;
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
    
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    	ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index < 2) {
	            if (!this.mergeItemStack(itemstack1, 2, this.inventorySlots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	            slot.onSlotChanged();
	         } else {
	        	if (itemstack1.getItem() instanceof BucketItem && ((BucketItem) itemstack1.getItem()).getFluid() == Fluids.EMPTY) {
	        		if (this.mergeItemStack(itemstack1, 1, 2, false)) return ItemStack.EMPTY;
	        	} else if (itemstack1.getItem() instanceof BucketItem && ((BucketItem) itemstack1.getItem()).getFluid() != Fluids.EMPTY) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 28) {
                    if (!this.mergeItemStack(itemstack1, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 37 && !this.mergeItemStack(itemstack1, 2, 28, false)) {
                    return ItemStack.EMPTY;
                }
	         }

	         if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
	         } else {
	            slot.onSlotChanged();
	         }
	      }

	      return itemstack;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(this.playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        addSlotRange(this.playerInventory, 0, leftCol, topRow + 58, 9, 18);
    }

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return !(playerIn.getDistanceSq(this.tileEntity.getPos().getX() + 0.5D, this.tileEntity.getPos().getY() + 0.5D, this.tileEntity.getPos().getZ() + 0.5D) > 64.0D);
	}

}
