package mreyeballs29.issactncore.item;

import mreyeballs29.issactncore.util.EnumSeries;
import mreyeballs29.issactncore.util.EnumShape;
import net.minecraft.item.Item;

public abstract class ItemElement extends Item {
	public abstract EnumSeries getSeries();
	
	public abstract EnumShape getShape();
	
	protected ItemElement() {}
}
