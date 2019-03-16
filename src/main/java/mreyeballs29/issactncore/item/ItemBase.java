package mreyeballs29.issactncore.item;

import mreyeballs29.issactncore.util.EnumSeries;

public abstract class ItemBase extends ItemElement {

	@Override
	public EnumSeries getSeries() {
		return EnumSeries.BASE;
	}
	
	protected ItemBase() {
		this.setHasSubtypes(true);
	}
}
