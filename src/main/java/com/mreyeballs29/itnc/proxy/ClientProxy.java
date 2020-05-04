package com.mreyeballs29.itnc.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@SuppressWarnings("resource")
	@Override
	public World getWorld() {
		return Minecraft.getInstance().world;
	}

	@SuppressWarnings("resource")
	@Override
	public PlayerEntity getPlayer() {
		return Minecraft.getInstance().player;
	}

}
