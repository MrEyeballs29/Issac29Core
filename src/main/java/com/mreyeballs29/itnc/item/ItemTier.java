package com.mreyeballs29.itnc.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class ItemTier implements IItemTier {
	
	public static final IItemTier WOOD = net.minecraft.item.ItemTier.WOOD;
	public static final IItemTier STONE = net.minecraft.item.ItemTier.STONE;
	public static final IItemTier IRON = net.minecraft.item.ItemTier.IRON;
	public static final IItemTier GOLD = net.minecraft.item.ItemTier.GOLD;
	public static final IItemTier DIAMOND = net.minecraft.item.ItemTier.DIAMOND;
	
	public static final IItemTier COPPER = new ItemTier("Copper", 92, 5.0F, 1.5F, 1, 16, Ingredient.fromItems(INCItems.COPPER_INGOT)); //$NON-NLS-1$
	public static final IItemTier SILVER = new ItemTier("Silver", 56, 6.5F, 1.0F, 1, 19, Ingredient.fromItems(INCItems.SILVER_INGOT)); //$NON-NLS-1$
	public static final IItemTier LEAD = new ItemTier("Lead", 142, 4.5F, 1.5F, 1, 8, Ingredient.fromItems(INCItems.LEAD_INGOT)); //$NON-NLS-1$
	public static final IItemTier BRONZE = new ItemTier("Bronze", 188, 5.5F, 2.0F, 2, 14, Ingredient.fromItems(INCItems.BRONZE_INGOT)); //$NON-NLS-1$
	
	public static final IItemTier RED_DIAMOND = new ItemTier("Red Diamond", 1832, 9.0F, 4.0F, 4, 18, Ingredient.fromItems(INCItems.COPPER_FRAME)); //$NON-NLS-1$
	
	private final String name;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int havestLevel;
	private final int enchantability;
	private final Ingredient repairMaterial;
	
	public ItemTier(String name, int uses, float eff, float attack, int level, int enchant, Ingredient material) {
		this.name = name;
		this.maxUses = uses;
		this.efficiency = eff;
		this.attackDamage = attack;
		this.havestLevel = level;
		this.enchantability = enchant;
		this.repairMaterial = material;
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.havestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "Material: #" + this.hashCode(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public String getName() {
		return this.name;
	}
	
}
