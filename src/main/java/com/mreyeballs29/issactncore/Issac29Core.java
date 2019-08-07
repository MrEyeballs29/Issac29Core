package com.mreyeballs29.issactncore;

import org.apache.logging.log4j.Logger;

import com.mreyeballs29.issactncore.init.I29CBlocks;
import com.mreyeballs29.issactncore.init.I29CItems;
import com.mreyeballs29.issactncore.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**
 * A instance class for a mod to start on. Also known as the root class
 * for just an ordinary class.
 * @author MrEyeballs29
 * @see net.minecraftforge.fml.common.Mod Mod
 */
@Mod(modid = "i29c", name = "Issac29 Core", version = "1.0.0", useMetadata = true, acceptedMinecraftVersions="1.12.2")
public class Issac29Core {
	
	/**
	 * This instance allows to use it for pretty much for the mod itself.
	 */
	@Instance
	public static Issac29Core instance = new Issac29Core();
	
	static {
		System.out.println("Debug");
		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	/**
	 * A logger used for debugging or also for developers.
	 */
	public static Logger log;
	
	/**
	 * A proxy if some sides include server or client like tooltips
	 * only appear on client proxy
	 */
	@SidedProxy(clientSide="com.mreyeballs29.issactncore.proxy.ClientProxy", serverSide="com.mreyeballs29.issactncore.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	/**
	 * The preinitialization stage allows to setup variables and also 
	 * for blocks and items. Blocks have to register first otherwise it 
	 * will cause an fatal error. 
	 * 
	 * <p>
	 * The static method also has a log setup too.
	 * @param event Used for creating configuration files, logger, and
	 * for source files.
	 */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		log.info("Fired 1");
		proxy.preInit();
	}
	/**
	 * The initialization stage allows to add recipes setup tile entities
	 * and also for many other things that are after the block setup.
	 * @param event The parameter used for not really anything.
	 */
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	/**
	 * The postinitalization stage is the least important stage because
	 * not many programmers use this section for anything. This is meant
	 * for last event.
	 * @param event The parameter used for not really anything.
	 */
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
}