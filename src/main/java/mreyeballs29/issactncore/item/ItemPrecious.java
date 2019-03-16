package mreyeballs29.issactncore.item;

import mreyeballs29.issactncore.util.EnumSeries;

public abstract class ItemPrecious extends ItemElement {

	@Override
	public EnumSeries getSeries() {
		return EnumSeries.PRECOUS;
	}

	protected ItemPrecious() {
		this.hasSubtypes = true;
	}

}
