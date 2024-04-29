
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.trslender.block.TaintedWoodBlock;
import net.mcreator.trslender.block.TaintedTrapdoorBlock;
import net.mcreator.trslender.block.TaintedStairsBlock;
import net.mcreator.trslender.block.TaintedSlabBlock;
import net.mcreator.trslender.block.TaintedPressurePlateBlock;
import net.mcreator.trslender.block.TaintedPlanksBlock;
import net.mcreator.trslender.block.TaintedLogBlock;
import net.mcreator.trslender.block.TaintedLeavesBlock;
import net.mcreator.trslender.block.TaintedGrassBlockBlock;
import net.mcreator.trslender.block.TaintedFenceGateBlock;
import net.mcreator.trslender.block.TaintedFenceBlock;
import net.mcreator.trslender.block.TaintedDoorBlock;
import net.mcreator.trslender.block.TaintedButtonBlock;
import net.mcreator.trslender.block.StrippedTaintedWoodBlock;
import net.mcreator.trslender.block.StrippedTaintedLogBlock;
import net.mcreator.trslender.block.PageBlock;
import net.mcreator.trslender.block.FlashlightLightBlock;
import net.mcreator.trslender.TrSlenderMod;

public class TrSlenderModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TrSlenderMod.MODID);
	public static final RegistryObject<Block> PAGE = REGISTRY.register("page", () -> new PageBlock());
	public static final RegistryObject<Block> TAINTED_LOG = REGISTRY.register("tainted_log", () -> new TaintedLogBlock());
	public static final RegistryObject<Block> TAINTED_WOOD = REGISTRY.register("tainted_wood", () -> new TaintedWoodBlock());
	public static final RegistryObject<Block> STRIPPED_TAINTED_LOG = REGISTRY.register("stripped_tainted_log", () -> new StrippedTaintedLogBlock());
	public static final RegistryObject<Block> STRIPPED_TAINTED_WOOD = REGISTRY.register("stripped_tainted_wood", () -> new StrippedTaintedWoodBlock());
	public static final RegistryObject<Block> TAINTED_PLANKS = REGISTRY.register("tainted_planks", () -> new TaintedPlanksBlock());
	public static final RegistryObject<Block> TAINTED_STAIRS = REGISTRY.register("tainted_stairs", () -> new TaintedStairsBlock());
	public static final RegistryObject<Block> TAINTED_SLAB = REGISTRY.register("tainted_slab", () -> new TaintedSlabBlock());
	public static final RegistryObject<Block> TAINTED_FENCE = REGISTRY.register("tainted_fence", () -> new TaintedFenceBlock());
	public static final RegistryObject<Block> TAINTED_FENCE_GATE = REGISTRY.register("tainted_fence_gate", () -> new TaintedFenceGateBlock());
	public static final RegistryObject<Block> TAINTED_DOOR = REGISTRY.register("tainted_door", () -> new TaintedDoorBlock());
	public static final RegistryObject<Block> TAINTED_TRAPDOOR = REGISTRY.register("tainted_trapdoor", () -> new TaintedTrapdoorBlock());
	public static final RegistryObject<Block> TAINTED_PRESSURE_PLATE = REGISTRY.register("tainted_pressure_plate", () -> new TaintedPressurePlateBlock());
	public static final RegistryObject<Block> TAINTED_BUTTON = REGISTRY.register("tainted_button", () -> new TaintedButtonBlock());
	public static final RegistryObject<Block> TAINTED_LEAVES = REGISTRY.register("tainted_leaves", () -> new TaintedLeavesBlock());
	public static final RegistryObject<Block> FLASHLIGHT_LIGHT = REGISTRY.register("flashlight_light", () -> new FlashlightLightBlock());
	public static final RegistryObject<Block> TAINTED_GRASS_BLOCK = REGISTRY.register("tainted_grass_block", () -> new TaintedGrassBlockBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PageBlock.registerRenderLayer();
			FlashlightLightBlock.registerRenderLayer();
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			TaintedLeavesBlock.blockColorLoad(event);
			TaintedGrassBlockBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(ColorHandlerEvent.Item event) {
			TaintedLeavesBlock.itemColorLoad(event);
			TaintedGrassBlockBlock.itemColorLoad(event);
		}
	}
}
