package com.mreyeballs29.issactncore.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumBaseMetal {
	COPPER(0, "copper", "Copper", true, 29),
	TIN(1, "tin", "Tin", false, 50),
	LEAD(2, "lead", "Lead", true, 82),
	BISMUTH(3, "bismuth", "Bismuth", true, 83),
	ALUMINUM(4, "aluminum", "Aluminum", true, 13),
	TITANIUM(5, "titanium", "Titanium", true, 22),
	COBALT(6, "cobalt", "Cobalt", true, 27),
	TUNGSTEN(7, "tungsten", "Tungsten", true, 74),
	BRONZE(8, "bronze", "Bronze", true, 503),
	STEEL(9, "steel", "Steel", true, 507),
	BISMUTHBRONZE(10, "bismuth_bronze", "BismuthBronze", true, 505),
	BLACKBRONZE(11, "black_bronze", "BlackBronze", true, 504),
	BLACKSTEEL(12, "black_steel", "BlackSteel", true, 508),
	BLUESTEEL(13, "blue_steel", "BlueSteel", true, 509),
	REDSTEEL(14, "red_steel", "RedSteel", true, 510),
	TUNGSTENSTEEL(15, "tungsten_steel", "TungstenSteel", true, 511);
	
	private int id;
	protected String unlocname;
	private boolean canbetool;
	protected String resource;
	private int elementid;
	
	private EnumBaseMetal(int d, String res, String unlocn, boolean tools, int element) {
		this.id = d;
		this.elementid = element;
		this.resource = res;
		this.unlocname = unlocn;
		this.canbetool = tools;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUnlocalizedName() {
		return this.unlocname;
	}
	
	public boolean isTool() {
		return this.canbetool;
	}
	
	@SideOnly(Side.CLIENT)
	public String getName() {
		return this.resource;
	}
	
	public static EnumBaseMetal byMetadata(int id) {
		if (id < 0 || id >= values().length) {
			return values()[0];
		}
		return values()[id];
	}

	public int getElementid() {
		return elementid;
	}
}
