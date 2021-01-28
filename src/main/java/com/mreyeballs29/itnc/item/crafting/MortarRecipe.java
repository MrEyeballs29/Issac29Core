package com.mreyeballs29.itnc.item.crafting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class MortarRecipe implements ICraftingRecipe {

	String group;
	private ResourceLocation id;
	ItemStack output;
	int teir;
	NonNullList<Ingredient> ingredients;
	static String[] levels = {"any", "basic", "advanced", "extreme", "ultimate"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	
	Ingredient input;
	
	public MortarRecipe(ResourceLocation idIn, String groupIn, int teir, ItemStack recipeOutputIn, Ingredient input) {
		this.group = groupIn;
		this.id = idIn;
		this.teir = teir;
		this.output = recipeOutputIn;
		this.ingredients = NonNullList.from(Ingredient.EMPTY, Ingredient.fromTag(new ItemTags.Wrapper(new ResourceLocation("itnc","mortar_and_" + levels[this.teir] + "_pestles"))), input); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		this.input = input;
	}
	
	@Override
	public boolean matches(CraftingInventory inv, World worldIn) {
		List<ItemStack> list = new ArrayList<>();
		
		for (int j = 0; j < inv.getSizeInventory(); j++) {
			ItemStack itemStack = inv.getStackInSlot(j);
			if (!itemStack.isEmpty()) {
				list.add(itemStack);
			}
		}
		return RecipeMatcher.findMatches(list, this.ingredients) != null;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	
	@Override
	public ItemStack getCraftingResult(CraftingInventory inv) {
		return this.output.copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	@Override
	public String getGroup() {
		return this.group;
	}
	
	@Override
	public ItemStack getRecipeOutput() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv) {
		NonNullList<ItemStack> nonnulllist = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

	      for(int i = 0; i < nonnulllist.size(); ++i) {
	         ItemStack item = inv.getStackInSlot(i);
	         if (item.hasContainerItem()) {
	            nonnulllist.set(i, item.getContainerItem());
	         }
	         if (item.isDamageable()) {
	        	 int current = item.getTag().getInt("Absored"); //$NON-NLS-1$
	        	 int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, item);
	        	 if (current >= lvl) {
	        		 item.getTag().remove("Absored"); //$NON-NLS-1$
	        		 item.setDamage(item.getDamage()+1);
	        	 } else {
	        		 current++;
	        		 item.getTag().putInt("Absored", current); //$NON-NLS-1$
	        	 }
	        	 if (item.getDamage() <= item.getMaxDamage()) {
	        		 nonnulllist.set(i, item.copy());
	        	 }
	         }
	      }

	      return nonnulllist;
	}
	
	@Override
	public IRecipeSerializer<?> getSerializer() {
		return INCRecipeSerializers.MORTAR;
	}
	
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<MortarRecipe>{

		@Override
		public MortarRecipe read(ResourceLocation recipeId, JsonObject json) {
			String string = JSONUtils.getString(json, "group", ""); //$NON-NLS-1$ //$NON-NLS-2$
			int i = JSONUtils.getInt(json, "teir", 0); //$NON-NLS-1$
			if (i >= MortarRecipe.levels.length) {
				throw new JsonParseException("level cannot execeed:" + (MortarRecipe.levels.length-1)); //$NON-NLS-1$
			}
			ItemStack itemStack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result")); //$NON-NLS-1$
			return new MortarRecipe(recipeId, string, i, itemStack, Ingredient.deserialize(JSONUtils.getJsonObject(json, "input"))); //$NON-NLS-1$
		}

		@Override
		public MortarRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			String group = buffer.readString(Short.MAX_VALUE);
			int tier = buffer.readInt();
			Ingredient input = Ingredient.read(buffer);
			ItemStack itemStack = buffer.readItemStack();
			return new MortarRecipe(recipeId, group, tier, itemStack, input);
		}

		@Override
		public void write(PacketBuffer buffer, MortarRecipe recipe) {
			buffer.writeString(recipe.group);
			buffer.writeInt(recipe.teir);
			recipe.input.write(buffer);
			
			buffer.writeItemStack(recipe.output);
		}
		
	}
}
