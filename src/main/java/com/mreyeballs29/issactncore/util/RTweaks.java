package com.mreyeballs29.issactncore.util;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.IShapedRecipe;

public class RTweaks implements IShapedRecipe, IRecipe {

	private NonNullList<Ingredient> recipeItems;
	private int height;
	private int width;
	private String group;
	private ItemStack stack;
	private ResourceLocation regname;
	
	public RTweaks(int height, int width, ItemStack output, String group, Ingredient... ingredients) {
		this.height = Math.min(height, 3) > 0 ? Math.min(height, 3) : 0;
		this.width = Math.min(width, 3) > 0 ? Math.min(width, 3) : 0;
		if (ingredients.length == this.height*this.width) {
			this.recipeItems = NonNullList.from(Ingredient.EMPTY, ingredients);
		} else {
			throw new IllegalArgumentException("Not the right Ingredient Sets");
		}
		this.group = group;
		this.stack = output;
	}
	
	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		this.regname = name;
		return (RTweaks)this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return this.regname;
	}

	@Override
	public Class<IRecipe> getRegistryType() {
		return IRecipe.class;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		for (int i = 0; i <= inv.getWidth() - this.getRecipeWidth(); ++i) {
			for (int j = 0; j <= inv.getHeight() - this.getRecipeHeight(); ++j) {
				if (this.checkMatch(inv, i, j, true)) {
					return true;
				}
				if (this.checkMatch(inv, i, j, false)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkMatch(InventoryCrafting craftingInventory, int x, int y, boolean ifsetable) {
        for (int i = 0; i < craftingInventory.getWidth(); ++i)
        {
            for (int j = 0; j < craftingInventory.getHeight(); ++j)
            {
                int k = i - x;
                int l = j - y;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.getRecipeWidth() && l < this.getRecipeHeight())
                {
                    if (ifsetable)
                    {
                        ingredient = this.recipeItems.get(this.getRecipeWidth() - k - 1 + l * this.getRecipeWidth());
                    }
                    else
                    {
                        ingredient = this.recipeItems.get(k + l * this.getRecipeWidth());
                    }
                }

                if (!ingredient.apply(craftingInventory.getStackInRowAndColumn(i, j)))
                {
                    return false;
                }
            }
        }
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return this.stack.copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return width >= this.getRecipeWidth() && height >= this.getRecipeHeight();
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.stack;
	}
	
	@Override
	public int getRecipeWidth() {
		return this.width;
	}

	@Override
	public int getRecipeHeight() {
		return this.height;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.recipeItems;
	}
	
	@Override
	public String getGroup() {
		return this.group;
	}
	
	 
}
