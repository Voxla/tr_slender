
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
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.trslender.item.FlashlightOnItem;
import net.mcreator.trslender.item.FlashlightOffItem;
import net.mcreator.trslender.TrSlenderMod;

public class TrSlenderModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TrSlenderMod.MODID);
	public static final RegistryObject<Item> SLENDERMAN_SPAWN_EGG = REGISTRY.register("slenderman_spawn_egg", () -> new ForgeSpawnEggItem(TrSlenderModEntities.SLENDERMAN, -13421773, -2236673, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> PAGE = block(TrSlenderModBlocks.PAGE, CreativeModeTab.TAB_TOOLS);
	public static final RegistryObject<Item> TAINTED_LOG = block(TrSlenderModBlocks.TAINTED_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_WOOD = block(TrSlenderModBlocks.TAINTED_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STRIPPED_TAINTED_LOG = block(TrSlenderModBlocks.STRIPPED_TAINTED_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STRIPPED_TAINTED_WOOD = block(TrSlenderModBlocks.STRIPPED_TAINTED_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_PLANKS = block(TrSlenderModBlocks.TAINTED_PLANKS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_STAIRS = block(TrSlenderModBlocks.TAINTED_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_SLAB = block(TrSlenderModBlocks.TAINTED_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_FENCE = block(TrSlenderModBlocks.TAINTED_FENCE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_FENCE_GATE = block(TrSlenderModBlocks.TAINTED_FENCE_GATE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_DOOR = doubleBlock(TrSlenderModBlocks.TAINTED_DOOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_TRAPDOOR = block(TrSlenderModBlocks.TAINTED_TRAPDOOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_PRESSURE_PLATE = block(TrSlenderModBlocks.TAINTED_PRESSURE_PLATE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_BUTTON = block(TrSlenderModBlocks.TAINTED_BUTTON, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAINTED_LEAVES = block(TrSlenderModBlocks.TAINTED_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> PROXY_SPAWN_EGG = REGISTRY.register("proxy_spawn_egg", () -> new ForgeSpawnEggItem(TrSlenderModEntities.PROXY, -11321284, -12895429, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> FLASHLIGHT_LIGHT = block(TrSlenderModBlocks.FLASHLIGHT_LIGHT, null);
	public static final RegistryObject<Item> FLASHLIGHT_ON = REGISTRY.register("flashlight_on", () -> new FlashlightOnItem());
	public static final RegistryObject<Item> FLASHLIGHT_OFF = REGISTRY.register("flashlight_off", () -> new FlashlightOffItem());
	public static final RegistryObject<Item> HOODIE_SPAWN_EGG = REGISTRY.register("hoodie_spawn_egg", () -> new ForgeSpawnEggItem(TrSlenderModEntities.HOODIE, -4288198, -13549992, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TAINTED_GRASS_BLOCK = block(TrSlenderModBlocks.TAINTED_GRASS_BLOCK, CreativeModeTab.TAB_DECORATIONS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
