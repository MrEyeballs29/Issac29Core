package com.mreyeballs29.itnc.tileentity;

import com.mreyeballs29.itnc.inventory.CrateContainer;
import com.mreyeballs29.itnc.tileentity.item.ManualWrapper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

public class CrateTileEntity extends TileEntity implements INamedContainerProvider {
	
	private LazyOptional<ManualWrapper> handler = LazyOptional.of(this::createHandler);
	
	public CrateTileEntity() {
		super(INCTileEntityTypes.CRATE);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		CompoundNBT nbtinv = compound.getCompound("items");
		handler.ifPresent(h -> h.deserializeNBT(nbtinv));
		super.read(compound);
	}
	
	public ManualWrapper getContents() {
		ManualWrapper wrapper = new ManualWrapper(15);
		handler.ifPresent(h -> { for (int i = 0; i < wrapper.getSlots(); i++) wrapper.setStackInSlot(i, h.getStackInSlot(i));});
		return wrapper;
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		handler.ifPresent(h -> {CompoundNBT nbt = h.serializeNBT(); compound.put("items", nbt);});
		return super.write(compound);
	}
	
	private ManualWrapper createHandler() {
		return new ManualWrapper(15);
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type) {
		return true;
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		return new CrateContainer(p_createMenu_1_, world, pos, p_createMenu_2_, p_createMenu_3_);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.crate");
	}
	
}
