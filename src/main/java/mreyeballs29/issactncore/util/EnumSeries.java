package mreyeballs29.issactncore.util;

public enum EnumSeries {
	BASE,
	PRECOUS,
	NONMETAL,
	WOOD,
	GEM,
	STONE,
	UMKNOWN;
	
	@Override
	public String toString() {
		String str1 = this.name().toLowerCase();
		str1 = str1.replaceAll("_", " ");
		String[] starr1 = str1.split(" ");
		str1 = "";
		int i = 0;
		for (String str2 : starr1) {
			i += 1;
			if (i == starr1.length) {
				str1 += str2.toLowerCase();
			} else {
				str1 += str2.toLowerCase() + "_";
			}
		}
		return str1;
	}
}
