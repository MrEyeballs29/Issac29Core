package com.mreyeballs29.issactncore.proxy;

import java.util.Objects;

import com.mreyeballs29.issactncore.entity.EntityFallingPowder;
import com.mreyeballs29.issactncore.util.EnumShape;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFallingPowder.class, new Factory());
	}
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void postInit() {
	}
	
	@Override
	public void registerModel(Item item, int meta, String type, EnumShape shape, String elm) {
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation("i29c:" + elm + "_" + shape, type));
	}
	
	@Override
	public void registerModel(Item item, int meta, String type, String string) {
		ModelLoader.setCustomModelResourceLocation(
			item,
			meta, 
			new ModelResourceLocation(
				"i29c:" + string + "_" + item.getRegistryName().getResourcePath(),
				type
			)
		);
	}
	
	@Override
	public void registerModel(Item item, int meta, String type) {
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation(item.getRegistryName(), type));
	}

	@Override
	public void registerModel(Item item, int meta, String type, String apply, String custom) {
		if (Objects.isNull(custom)) {
			ModelLoader.setCustomModelResourceLocation(item, meta,
					new ModelResourceLocation("i29c:" + apply, type)
			);
		} else {
			ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation("i29c:" + apply + '_' + custom, type)
			);
		}
	}
	
	private static class Factory implements IRenderFactory<EntityFallingBlock> {

		@Override
		public Render<? super EntityFallingBlock> createRenderFor(RenderManager manager) {
			return new RenderFallingBlock(manager);
		}
		
	}
}
