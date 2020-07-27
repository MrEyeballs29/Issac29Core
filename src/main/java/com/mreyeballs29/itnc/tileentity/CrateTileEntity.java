package com.mreyeballs29.itnc.tileentity;

import org.apache.logging.log4j.LogManager;

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
		CompoundNBT nbtinv = compound.getCompound("inventory"); //$NON-NLS-1$
		this.handler.ifPresent(h -> h.deserializeNBT(nbtinv));
		super.read(compound);
		LogManager.getLogger().info(this.getContents().getStackInSlot(0).getItem().getRegistryName());
	}
	
	public ManualWrapper getContents() {
		return this.handler.orElse(new ManualWrapper(15, this));
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		this.handler.ifPresent(h -> {CompoundNBT nbt = h.serializeNBT(); compound.put("inventory", nbt);}); //$NON-NLS-1$
		return super.write(compound);
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}
	
	private ManualWrapper createHandler() {
		return new ManualWrapper(15, this);
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return this.handler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type) {
		return true;
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		return new CrateContainer(p_createMenu_1_, this.world, this.pos, p_createMenu_2_);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.crate"); //$NON-NLS-1$
	}
	
}
