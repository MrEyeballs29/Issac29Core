package mreyeballs29.issactncore.item;

import mreyeballs29.issactncore.util.EnumShape;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBaseIngot extends ItemBase {
	
	public ItemBaseIngot() {
		super();
		this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + getShape() + EnumBaseMetal.byMetadata(stack.getMetadata()).getUnlocalizedName();
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < 16; ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public EnumShape getShape() {
		return EnumShape.INGOT;
	}
}
