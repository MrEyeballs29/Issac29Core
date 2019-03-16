package mreyeballs29.issactncore;

import org.apache.logging.log4j.Logger;

import mreyeballs29.issactncore.init.I29CBlocks;
import mreyeballs29.issactncore.init.I29CItems;
import mreyeballs29.issactncore.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "i29c", name = "Issac29 Core", version = "1.0.0", useMetadata = true, acceptedMinecraftVersions="1.12.2")
public class Issac29Core {
	
	@Mod.Instance
	public static Issac29Core instance = new Issac29Core();
	
	public static Logger log;
	
	@SidedProxy(clientSide="mreyeballs29.issactncore.proxy.ClientProxy", serverSide="mreyeballs29.issactncore.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		I29CBlocks.InitalizeBlocks();
		I29CItems.InitalizeItems();
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
}