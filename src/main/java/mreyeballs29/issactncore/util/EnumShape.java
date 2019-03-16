package mreyeballs29.issactncore.util;

public enum EnumShape {
	INGOT,
	PLATE,
	ROD,
	NUGGET,
	GEAR,
	DUST,
	ORE,
	BLOCK,
	TINY_DUST,
	HELMET,
	CHESTPLATE,
	LEGGINGS,
	BOOTS,
	PICKAXE,
	AXE,
	SHOVEL,
	HOE,
	SWORD,
	FOIL,
	UNKNOWN, STICK;
	
	@Override
	public String toString() {
		String str1 = this.name().toLowerCase();
		str1 = str1.replaceAll("_", " ");
		String[] starr1 = str1.split(" ");
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (String str2 : starr1) {
			i += 1;
			if (i == starr1.length) {
				builder.append(str2);
			} else {
				builder.append(str2 + "_");
			}
		}
		return builder.toString();
	}
}
