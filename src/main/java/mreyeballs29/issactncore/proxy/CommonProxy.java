package mreyeballs29.issactncore.proxy;

import mreyeballs29.issactncore.util.EnumShape;
import net.minecraft.item.Item;

public class CommonProxy {

	public void preInit() {}
	
	public void init() {}
	
	public void postInit() {}

	public void registerModel(Item item, int meta, String type) {}

	public void registerModel(Item item, int meta, String type, EnumShape shape, String string) {}
}
