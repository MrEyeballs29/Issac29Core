package com.mreyeballs29.itnc.tileentity;

import com.mreyeballs29.itnc.inventory.TankContainer;
import com.mreyeballs29.itnc.item.WoodenBucketItem;
import com.mreyeballs29.itnc.tileentity.fluid.IFluidGetter;
import com.mreyeballs29.itnc.tileentity.fluid.ManualTank;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.ItemStackHandler;

public class TankTileEntity extends TileEntity implements INamedContainerProvider, ITickableTileEntity, IFluidGetter {

	ManualTank tank = new ManualTank(8000, this);
	ItemStackHandler input = new ItemStackHandler() {
		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			if (stack.getItem() instanceof BucketItem) {
				BucketItem item = (BucketItem) stack.getItem();
				return item.getFluid() != Fluids.EMPTY && !(item instanceof FishBucketItem);
			} else if (stack.getItem() instanceof WoodenBucketItem) {
				WoodenBucketItem item = (WoodenBucketItem) stack.getItem();
				return item.getFluid() != Fluids.EMPTY;
			}
			return false;
		}
	};
	ItemStackHandler output = new ItemStackHandler() {
		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			if (stack.getItem() instanceof BucketItem) {
				BucketItem item = (BucketItem) stack.getItem();
				if (item.getFluid() == Fluids.EMPTY) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		protected int getStackLimit(int slot, ItemStack stack) {
			return 1;
		}
	};
	private LazyOptional<IFluidHandler> optional = LazyOptional.of(() -> this.tank);
	
	public TankTileEntity() {
		super(INCTileEntityTypes.TANK);
	}
	
	public ItemStackHandler getInput() {
		return this.input;
	}
	
	public ItemStackHandler getOutput() {
		return this.output;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		CompoundNBT nbtfluid = compound.getCompound("tank"); //$NON-NLS-1$
		this.tank.readFromNBT(nbtfluid);
		this.input.deserializeNBT(compound.getCompound("input")); //$NON-NLS-1$
		this.output.deserializeNBT(compound.getCompound("output")); //$NON-NLS-1$
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("input", this.input.serializeNBT()); //$NON-NLS-1$
		compound.put("output", this.output.serializeNBT()); //$NON-NLS-1$
		compound.put("tank", this.tank.writeToNBT(new CompoundNBT())); //$NON-NLS-1$
		return super.write(compound);
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = super.getUpdateTag();
		return this.write(nbt);
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, -1, getUpdateTag());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		return true;

	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY ? this.optional.cast() : super.getCapability(cap);
	}

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		return new TankContainer(p_createMenu_1_, this.world, this.pos, p_createMenu_2_);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.tank"); //$NON-NLS-1$
	}
	
	@Override
	public FluidTank getTank() {
		return this.tank;
	}

	@Override
	public void tick() {
		if (this.tank.getSpace() >= 1000) {
			ItemStack input1 = this.input.getStackInSlot(0);
			if (input1.getItem() instanceof BucketItem) {
				BucketItem item = (BucketItem) input1.getItem();
				if (item.getFluid() == this.tank.getFluid().getFluid() && item.getFluid() != Fluids.EMPTY) {
					this.tank.addFluid(1000);
					this.input.setStackInSlot(0, new ItemStack(Items.BUCKET));
				} else if (this.tank.getFluidAmount() == 0 && item.getFluid() != Fluids.EMPTY) {
					this.tank.setFluid(new FluidStack(item.getFluid(), 1000));
					this.input.setStackInSlot(0, new ItemStack(Items.BUCKET));
				}
			} else if (input1.getItem() instanceof WoodenBucketItem) {
				WoodenBucketItem item = (WoodenBucketItem) input1.getItem();
				if (item.getFluid() == this.tank.getFluid().getFluid() && item.getFluid() != Fluids.EMPTY) {
					this.tank.addFluid(1000);
					this.input.setStackInSlot(0, new ItemStack(Items.BUCKET));
				}
			}
		}
		if (this.tank.getFluidAmount() >= 1000) {
			ItemStack output1 = this.output.getStackInSlot(0);
			if (output1.getItem() instanceof BucketItem) {
				FluidStack stack = this.tank.getFluid();
				BucketItem item = (BucketItem) output1.getItem();
				this.output.setStackInSlot(0, new ItemStack(stack.getFluid().getFilledBucket()));
				if (item.getFluid() == Fluids.EMPTY) this.tank.subtractFluid(1000);
			}
		}
	}
}
