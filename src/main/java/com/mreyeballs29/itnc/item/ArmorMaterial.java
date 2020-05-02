package com.mreyeballs29.itnc.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorMaterial implements IArmorMaterial {

	public static final IArmorMaterial LEATHER = net.minecraft.item.ArmorMaterial.LEATHER;
	public static final IArmorMaterial CHAIN = net.minecraft.item.ArmorMaterial.CHAIN;
	public static final IArmorMaterial GOLD = net.minecraft.item.ArmorMaterial.GOLD;
	public static final IArmorMaterial IRON = net.minecraft.item.ArmorMaterial.IRON;
	public static final IArmorMaterial DIAMOND = net.minecraft.item.ArmorMaterial.DIAMOND;
	
	public static final IArmorMaterial COPPER = new ArmorMaterial("itnc:copper", 10, 1, 3, 4, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 14,
			Ingredient.fromItems(INCItems.COPPER_INGOT), 0.0F);
	public static final IArmorMaterial SILVER = new ArmorMaterial("itnc:silver", 8, 2, 3, 4, 1, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 18,
			Ingredient.fromItems(INCItems.SILVER_INGOT), 0.0F);
	public static final IArmorMaterial LEAD = new ArmorMaterial("itnc:lead", 12, 2, 3, 4, 2, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 11,
			Ingredient.fromItems(INCItems.LEAD_INGOT), 1.5F);
	
	private float toughness;
	private String name;
	private Ingredient repairMaterial;
	private SoundEvent soundEvent;
	private int enchantability;
	private int[] damageReductionAmountArray;
	private int maxDamageFactor;

	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	
	public ArmorMaterial(String name, int factor, int boots, int leggings, int chestplate, int helmet, SoundEvent sound, int enchant,
			Ingredient repairMaterial, float toughness) {
		this.name = name;
		this.maxDamageFactor = factor;
		this.damageReductionAmountArray = new int[] {boots, leggings, chestplate, helmet};
		this.soundEvent = sound;
		this.enchantability = enchant;
		this.repairMaterial = repairMaterial;
		this.toughness = toughness;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

}
