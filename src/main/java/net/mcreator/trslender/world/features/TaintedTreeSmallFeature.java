
package net.mcreator.trslender.world.features;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import net.mcreator.trslender.procedures.TaintedTreeLargeAdditionalGenerationConditionProcedure;
import net.mcreator.trslender.init.TrSlenderModBlocks;

import java.util.Set;
import java.util.List;

public class TaintedTreeSmallFeature extends Feature<NoneFeatureConfiguration> {
	public static TaintedTreeSmallFeature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new TaintedTreeSmallFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tr_slender:tainted_tree_small", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("tr_slender:tainted_tree_small", CONFIGURED_FEATURE, List.of());
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("tr_slender:tainted_forests"), new ResourceLocation("tr_slender:tainted_forest"));
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD, ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("tr_slender:slender_gamemode")));
	private final List<Block> base_blocks;
	private StructureTemplate template = null;

	public TaintedTreeSmallFeature() {
		super(NoneFeatureConfiguration.CODEC);
		base_blocks = List.of(Blocks.GRASS_BLOCK, TrSlenderModBlocks.TAINTED_GRASS_BLOCK.get());
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;
		if (template == null)
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("tr_slender", "taintedtreesmall"));
		if (template == null)
			return false;
		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 600000) {
			int count = context.random().nextInt(4) + 13;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);
				int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k) - 1;
				if (!base_blocks.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock()))
					continue;
				BlockPos spawnTo = new BlockPos(i + -3, j + -2, k + -3);
				WorldGenLevel world = context.level();
				int x = spawnTo.getX();
				int y = spawnTo.getY();
				int z = spawnTo.getZ();
				if (!TaintedTreeLargeAdditionalGenerationConditionProcedure.execute(world, x, y, z))
					continue;
				if (template.placeInWorld(context.level(), spawnTo, spawnTo, new StructurePlaceSettings().setMirror(Mirror.values()[context.random().nextInt(2)]).setRotation(Rotation.values()[context.random().nextInt(3)]).setRandom(context.random())
						.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), context.random(), 2)) {
					anyPlaced = true;
				}
			}
		}
		return anyPlaced;
	}
}
