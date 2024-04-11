
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.trslender.world.features.TaintedTreeSmallFeature;
import net.mcreator.trslender.world.features.TaintedTreeLargeFeature;
import net.mcreator.trslender.TrSlenderMod;

@Mod.EventBusSubscriber
public class TrSlenderModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TrSlenderMod.MODID);
	public static final RegistryObject<Feature<?>> TAINTED_TREE_LARGE = REGISTRY.register("tainted_tree_large", TaintedTreeLargeFeature::new);
	public static final RegistryObject<Feature<?>> TAINTED_TREE_SMALL = REGISTRY.register("tainted_tree_small", TaintedTreeSmallFeature::new);
}
