package mreyeballs29.issactncore.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumPreciousMetal {
	SILVER(0, "silver", "Silver", true, 47),
	NICKEL(1, "nickel", "Nickel", true, 28),
	ZINC(2, "zinc", "Zinc", false, 30),
	MANGANESE(3, "manganese", "Manganese", true, 25),
	CHROME(4, "chrome", "Chromium", true, 24),
	PLATINUM(5, "platinum", "Platinum", true, 78),
	OSMIUM(6, "osmium", "Osmium", true, 76),
	IRIDIUM(7, "iridium", "Iridium", true, 77),
	BRASS(8, "brass", "Brass", true, 506),
	INVAR(9, "invar", "Invar", true, 513),
	ELECTRUM(10, "electrum", "Electrum", true, 500),
	STERLINGSILVER(11, "sterling_silver", "SterlingSilver", true, 501),
	ROSEGOLD(12, "rose_gold", "RoseGold", true, 502),
	STAINLESSSTEEL(13, "stainless_steel", "StainlessSteel", true, 512),
	CONSTANTAN(14, "constantan", "Constantan", true, 514),
	OSMIRIDIUM(15, "osmiridium", "Osmiridium", true, 515);
	
	private int id;
	protected String unlocname;
	private boolean canbetool;
	protected String resource;
	private int elid;
	
	private EnumPreciousMetal(int id, String res, String unl, boolean tools, int eli) {
		this.id = id;
		this.elid = eli;
		this.unlocname = unl;
		this.resource = res;
		this.canbetool = tools;
	}

	public int getId() {
		return id;
	}

	public String getUnlocalizedName() {
		return unlocname;
	}

	public boolean isTool() {
		return canbetool;
	}

	@SideOnly(Side.CLIENT)
	public String getName() {
		return resource;
	}

	public static EnumPreciousMetal byMetadata(int id) {
		if (id < 0 || id >= values().length) {
			return values()[0];
		}
		return values()[id];
	}

	public int getElementId() {
		return elid;
	}
}
