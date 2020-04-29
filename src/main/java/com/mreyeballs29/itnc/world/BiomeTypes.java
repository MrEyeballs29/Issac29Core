package com.mreyeballs29.itnc.world;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeTypes {
	/**
	 * Green Sapphires spawn in this biome set.
	 */
	public static final Set<Biome> GRASS_BIOMES = Sets.newHashSet(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
	/**
	 * Yellow Sapphires spawn in this biome set.
	 */
	public static final Set<Biome> DESERT_BIOMES = Sets.newHashSet(Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.DESERT_LAKES);
	/**
	 * Emeralds spawn in this biome set.
	 */
	public static final Set<Biome> MOUNTAIN_BIOMES = Sets.newHashSet(Biomes.MOUNTAINS, Biomes.MOUNTAIN_EDGE, Biomes.GRAVELLY_MOUNTAINS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.WOODED_MOUNTAINS);
	/**
	 * Green Sapphires also spawn in this biome set.
	 */
	public static final Set<Biome> FOREST_BIOMES = Sets.newHashSet(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.WOODED_HILLS);
	/**
	 * Red Garnets spawn it this biome set.
	 */
	public static final Set<Biome> BIRCH_FOREST_BIOMES = Sets.newHashSet(Biomes.BIRCH_FOREST, Biomes.TALL_BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.TALL_BIRCH_HILLS);
	/**
	 * Yellow Garnets spawn in this biome set.
	 */
	public static final Set<Biome> DARK_FOREST_BIOMES = Sets.newHashSet(Biomes.DARK_FOREST, Biomes.DARK_FOREST_HILLS);
	/**
	 * Opals spawn in this biome set.
	 */
	public static final Set<Biome> OCEAN_BIOMES = Sets.newHashSet(Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
	/**
	 * Rubies spawn in this biome set.
	 */
	public static final Set<Biome> NETHER_BIOMES = Sets.newHashSet(Biomes.NETHER);
	/**
	 * Amethysts spawn in this biome set.
	 */
	public static final Set<Biome> END_BIOMES = Sets.newHashSet(Biomes.THE_END, Biomes.END_BARRENS, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.SMALL_END_ISLANDS);
	/**
	 * Blue Topazes spawn in this biome set.
	 */
	public static final Set<Biome> FROZEN_BIOMES = Sets.newHashSet(Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.SNOWY_TAIGA, Biomes.ICE_SPIKES, Biomes.SNOWY_TAIGA_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.SNOWY_BEACH, Biomes.FROZEN_RIVER, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
	/**
	 * Olivines spawn in this biome set.
	 */
	public static final Set<Biome> JUNGLE_BIOMES = Sets.newHashSet(Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.BAMBOO_JUNGLE, Biomes.BAMBOO_JUNGLE_HILLS);
	/**
	 * Sapphires spawn in this biome set.
	 */
	public static final Set<Biome> TAIGA_BIOMES = Sets.newHashSet(Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS);
	/**
	 * Heliodors spawn in this biome set
	 */
	public static final Set<Biome> SAVANNA_BIOMES = Sets.newHashSet(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.SHATTERED_SAVANNA, Biomes.SHATTERED_SAVANNA_PLATEAU);
	/**
	 * Aquamarines spawn in this biome set.
	 */
	public static final Set<Biome> SWAMP_BIOMES = Sets.newHashSet(Biomes.SWAMP, Biomes.SWAMP_HILLS);
	/**
	 * Topazes spawn in this biome set.
	 */
	public static final Set<Biome> BADLANDS_BIOMES = Sets.newHashSet(Biomes.BADLANDS, Biomes.BADLANDS_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_BADLANDS_PLATEAU, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.WOODED_BADLANDS_PLATEAU);
	/**
	 * Purple Sapphires spawn in this biome set.
	 */
	public static final Set<Biome> MUSHROOM_BIOMES = Sets.newHashSet(Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE);
	/**
	 * No unique gems spawn in this biome set.
	 */
	public static final Set<Biome> OTHER_BIOMES = Sets.newHashSet(Biomes.BEACH, Biomes.RIVER, Biomes.THE_VOID, Biomes.STONE_SHORE);
	
	public static final Set<Biome> ALL_BIOMES = addAll();
	
	private static final Set<Biome> addAll() {
		Set<Biome> set = new HashSet<>();
		set.addAll(GRASS_BIOMES);
		set.addAll(DESERT_BIOMES);
		set.addAll(FOREST_BIOMES);
		set.addAll(BIRCH_FOREST_BIOMES);
		set.addAll(DARK_FOREST_BIOMES);
		set.addAll(JUNGLE_BIOMES);
		set.addAll(MUSHROOM_BIOMES);
		set.addAll(TAIGA_BIOMES);
		set.addAll(OCEAN_BIOMES);
		set.addAll(NETHER_BIOMES);
		set.addAll(END_BIOMES);
		set.addAll(FROZEN_BIOMES);
		set.addAll(SAVANNA_BIOMES);
		set.addAll(MOUNTAIN_BIOMES);
		set.addAll(BADLANDS_BIOMES);
		set.addAll(SWAMP_BIOMES);
		set.addAll(OTHER_BIOMES);
		return set;
	}
}
