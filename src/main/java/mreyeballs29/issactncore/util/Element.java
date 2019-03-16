package mreyeballs29.issactncore.util;

/**
 * 0-399: Elements <br>
 * 400: Magic <br>
 * 401-439: Wood <br>
 * 440-449: Silicates <br>
 * 450-499: Stone <br>
 * 500-524: Alloys <br>
 * 525-599: Cheap Materials <br>
 * 600-MAX_ELEMENTS: Reserved For Future Use <br>
 * MAX_ELEMENTS = 999
 */
public class Element extends Object {

	public static final Integer MAX_ELEMENTS = 999;
	public static final Double AVOGADROS_NUMBER = 6.0221409e23;
	
	/**
	 * A null element
	 */
	public static final Element EMPTY = new Element("empty", 0);
	public static final Element CARBON = new Element("carbon", 6);
	public static final Element ALUMINIUM = new Element("aluminium", 13);
	public static final Element SILICON = new Element("silicon", 14);
	public static final Element TITANIUM = new Element("titanium", 22);
	public static final Element CHROMIUM = new Element("chrome", 24);
	public static final Element MANGANESE = new Element("manganese", 25);
	public static final Element IRON = new Element("iron", 26);
	public static final Element COBALT = new Element("cobalt", 27);
	public static final Element NICKEL = new Element("nickel", 28);
	public static final Element COPPER = new Element("copper", 29);
	public static final Element ZINC = new Element("zinc", 30);
	public static final Element SILVER = new Element("silver", 47);
	public static final Element TIN = new Element("tin", 50);
	public static final Element TUNGSTEN = new Element("tungsten", 74);
	public static final Element OSMIUM = new Element("osmium", 76);
	public static final Element IRIDIUM = new Element("iridium", 77);
	public static final Element PLATINUM = new Element("platinum", 78);
	public static final Element GOLD = new Element("gold", 79);
	public static final Element LEAD = new Element("lead", 82);
	public static final Element BISMUTH = new Element("bismuth", 83);
	public static final Element MAGIC = new Element("magic", 400);
	public static final Element WOOD = new Element("wood", 401);
	public static final Element OAK = new Element("oak", 402);
	public static final Element SPRUCE = new Element("spruce", 403);
	public static final Element BIRCH = new Element("birch", 404);
	public static final Element TROPICAL = new Element("jungle", 405);
	public static final Element ACACIA = new Element("acacia", 406);
	public static final Element DOAK = new Element("dark_oak", 407);
	public static final Element LARCH = new Element("larch", 408);
	public static final Element TEAK = new Element("teak", 409);
	public static final Element DACACIA = new Element("dessert_acacia", 410);
	public static final Element LIMEWOOD = new Element("lime_wood", 411);
	public static final Element CHESTNUT = new Element("chestnut", 412);
	public static final Element WENGE = new Element("wenge", 413);
	public static final Element BAOBAB = new Element("baobab", 414);
	public static final Element GSEQUOIA = new Element("giant_sequoia", 415);
	public static final Element SEQUOIA = new Element("sequoia", 416);
	public static final Element KAPOK = new Element("kapok", 417);
	public static final Element EBONY = new Element("ebony", 418);
	public static final Element MAHOGANY = new Element("mahogany", 419);
	public static final Element BALSA = new Element("balsa", 420);
	public static final Element WILLOW = new Element("willow", 421);
	public static final Element WALNUT = new Element("walnut", 422);
	public static final Element GREENHEART = new Element("greenheart", 423);
	public static final Element CHERRY = new Element("cherry", 424);
	public static final Element MAHOE = new Element("mahoe", 425);
	public static final Element POPLAR = new Element("poplar", 426);
	public static final Element PALM = new Element("palm", 427);
	public static final Element PAPAYA = new Element("papaya", 428);
	public static final Element PINE = new Element("pine", 429);
	public static final Element PLUM = new Element("plum", 430);
	public static final Element MAPLE = new Element("maple", 431);
	public static final Element CITRUS = new Element("citrus", 432);
	public static final Element IPE = new Element("ipe", 433);
	public static final Element PADAUK = new Element("padauk", 434);
	public static final Element COCOBOLO = new Element("cocobolo", 435);
	public static final Element ZEBRAWOOD = new Element("zebrawood", 436);
	public static final Element RWOOD = new Element("rubber_wood", 437);
	public static final Element TWOOD = new Element("treated_wood", 438);
	public static final Element PWOOD = new Element("polished_wood", 439);
	public static final Element SIDIOXIDE = new Element("silicon_dioxide", 440);
	public static final Element SAND = new Element("sand", 442);
	public static final Element RSAND = new Element("red_sand", 441);
	public static final Element GLASS = new Element("glass", 443);
	public static final Element FLINT = new Element("flint", 444);
	public static final Element QUARTZ = new Element("quartz", 445);
	public static final Element NQUARTZ = new Element("nether_quartz", 446);
	public static final Element ELECTRUM = new Element("electrum", 500);
	public static final Element SSLIVER = new Element("sterling_silver", 501);
	public static final Element RGOLD = new Element("rose_gold", 502);
	public static final Element BRONZE = new Element("bronze", 503);
	public static final Element BBRONZE = new Element("black_bronze", 504);
	public static final Element BIBRONZE = new Element("bismuth_bronze", 505);
	public static final Element BRASS = new Element("brass", 506);
	public static final Element CBRASS = new Element("cobalt_brass", 507);
	public static final Element STEEL = new Element("steel", 508);
	public static final Element BLSTEEL = new Element("black_steel", 509);
	public static final Element RSTEEL = new Element("red_steel", 510);
	public static final Element BSTEEL = new Element("blue_steel", 511);
	public static final Element WSTEEL = new Element("tungsten_steel", 512);
	public static final Element SSTEEL = new Element("stainless_steel", 513);
	public static final Element INVAR = new Element("invar", 514);
	public static final Element CONSTANTAN = new Element("constantan", 515);
	public static final Element OSMIRIDIUM = new Element("osmiridium", 516);
	
	private final String name;
	private final int index;
	
	public Element(String name, int index) {
		this.name = name;
		this.index = Math.max(index, 0) <= MAX_ELEMENTS ? Math.max(index, 0) : 0;
	}
	
	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
	
	public String toString(boolean unlocalized) {
		if (unlocalized) {
			String str1 = this.getName().toLowerCase();
			str1 = str1.replaceAll("_", " ");
			String[] starr1 = str1.split(" ");
			str1 = "";
			for (String str2 : starr1) {
				str1 += (str2.substring(0,1).toUpperCase()+str2.substring(1));
			}
			return str1;
		}
		return this.getName();
	}
	
	@Override
	public String toString() {
		return this.toString(true);
	}
	
	public boolean isEmpty() {
		return this == Element.EMPTY || this.index == 0 && this.name == null;
	}
	
	@Override
	public int hashCode() {
		return this.index * 128;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * A method overriding from class Object
	 * @return {@code true} if super equals the same reference otherwise if the object is not an element
	 * will be {@code false}. The name of the element must match with the id.
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (!(obj instanceof Element)) return false;
		Element el = (Element) obj;	
		return this.name.equals(el.name) && this.index == el.index;
	}
}
