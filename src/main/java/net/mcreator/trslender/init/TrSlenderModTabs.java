
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.trslender.TrSlenderMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrSlenderModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TrSlenderMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TrSlenderModBlocks.TAINTED_LOG.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_WOOD.get().asItem());
			tabData.accept(TrSlenderModBlocks.STRIPPED_TAINTED_LOG.get().asItem());
			tabData.accept(TrSlenderModBlocks.STRIPPED_TAINTED_WOOD.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_PLANKS.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_STAIRS.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_SLAB.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_FENCE.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_FENCE_GATE.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_DOOR.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_TRAPDOOR.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_PRESSURE_PLATE.get().asItem());
			tabData.accept(TrSlenderModBlocks.TAINTED_BUTTON.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(TrSlenderModItems.SLENDERMAN_SPAWN_EGG.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TrSlenderModBlocks.PAGE.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(TrSlenderModBlocks.TAINTED_LEAVES.get().asItem());
		}
	}
}
