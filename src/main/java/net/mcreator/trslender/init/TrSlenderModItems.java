
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.trslender.TrSlenderMod;

public class TrSlenderModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TrSlenderMod.MODID);
	public static final RegistryObject<Item> SLENDERMAN_SPAWN_EGG = REGISTRY.register("slenderman_spawn_egg", () -> new ForgeSpawnEggItem(TrSlenderModEntities.SLENDERMAN, -13421773, -2236673, new Item.Properties()));
	public static final RegistryObject<Item> PAGE = block(TrSlenderModBlocks.PAGE);
	public static final RegistryObject<Item> TAINTED_LOG = block(TrSlenderModBlocks.TAINTED_LOG);
	public static final RegistryObject<Item> TAINTED_WOOD = block(TrSlenderModBlocks.TAINTED_WOOD);
	public static final RegistryObject<Item> STRIPPED_TAINTED_LOG = block(TrSlenderModBlocks.STRIPPED_TAINTED_LOG);
	public static final RegistryObject<Item> STRIPPED_TAINTED_WOOD = block(TrSlenderModBlocks.STRIPPED_TAINTED_WOOD);
	public static final RegistryObject<Item> TAINTED_PLANKS = block(TrSlenderModBlocks.TAINTED_PLANKS);
	public static final RegistryObject<Item> TAINTED_STAIRS = block(TrSlenderModBlocks.TAINTED_STAIRS);
	public static final RegistryObject<Item> TAINTED_SLAB = block(TrSlenderModBlocks.TAINTED_SLAB);
	public static final RegistryObject<Item> TAINTED_FENCE = block(TrSlenderModBlocks.TAINTED_FENCE);
	public static final RegistryObject<Item> TAINTED_FENCE_GATE = block(TrSlenderModBlocks.TAINTED_FENCE_GATE);
	public static final RegistryObject<Item> TAINTED_DOOR = doubleBlock(TrSlenderModBlocks.TAINTED_DOOR);
	public static final RegistryObject<Item> TAINTED_TRAPDOOR = block(TrSlenderModBlocks.TAINTED_TRAPDOOR);
	public static final RegistryObject<Item> TAINTED_PRESSURE_PLATE = block(TrSlenderModBlocks.TAINTED_PRESSURE_PLATE);
	public static final RegistryObject<Item> TAINTED_BUTTON = block(TrSlenderModBlocks.TAINTED_BUTTON);
	public static final RegistryObject<Item> TAINTED_LEAVES = block(TrSlenderModBlocks.TAINTED_LEAVES);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
