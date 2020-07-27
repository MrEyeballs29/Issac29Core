package com.mreyeballs29.itnc.tileentity;

import com.mreyeballs29.itnc.block.INCBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class INCTileEntityTypes {

	public static final TileEntityType<CrateTileEntity> CRATE = TileEntityType.Builder.create(CrateTileEntity::new, INCBlocks.OAK_CRATE, INCBlocks.SPRUCE_CRATE, INCBlocks.BIRCH_CRATE, INCBlocks.JUNGLE_CRATE, INCBlocks.ACACIA_CRATE, INCBlocks.DARK_OAK_CRATE).build(null);
	public static final TileEntityType<TankTileEntity> TANK = TileEntityType.Builder.create(TankTileEntity::new, INCBlocks.TANK).build(null); 
	
	@SubscribeEvent
	public static void onTileEntityTypeRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityTypeRegistryEvent) {
		IForgeRegistry<TileEntityType<?>> forgeRegistry = tileEntityTypeRegistryEvent.getRegistry();
		forgeRegistry.register(CRATE.setRegistryName("itnc:crate")); //$NON-NLS-1$
		forgeRegistry.register(TANK.setRegistryName("itnc:tank")); //$NON-NLS-1$
	}

}
