package mreyeballs29.issactncore.item;

import mreyeballs29.issactncore.util.EnumSeries;

public abstract class ItemWood extends ItemElement {
	@Override
	public EnumSeries getSeries() {
		return EnumSeries.WOOD;
	}
	
	protected ItemWood() {
		this.setHasSubtypes(true);
	}
}