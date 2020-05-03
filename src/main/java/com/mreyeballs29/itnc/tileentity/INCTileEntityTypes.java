package com.mreyeballs29.itnc.tileentity;

import com.mreyeballs29.itnc.block.INCBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class INCTileEntityTypes {

	public static final TileEntityType<CrateTileEntity> CRATE = TileEntityType.Builder.create(CrateTileEntity::new, INCBlocks.OAK_CRATE).build(null);
	
	@SubscribeEvent
	public static void onTileEntityTypeRegistry(final RegistryEvent.Register<TileEntityType<?>> tileEntityTypeRegistryEvent) {
		IForgeRegistry<TileEntityType<?>> forgeRegistry = tileEntityTypeRegistryEvent.getRegistry();
		forgeRegistry.register(CRATE.setRegistryName("itnc:crate"));
	}

}
