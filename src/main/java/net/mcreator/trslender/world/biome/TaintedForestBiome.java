
package net.mcreator.trslender.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

public class TaintedForestBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, -0.1f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.16f, 1f), Climate.Parameter.span(-0.5f, 1f), Climate.Parameter.point(0.0f),
					Climate.Parameter.span(-0.35f, 0.35f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, -0.1f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.16f, 1f), Climate.Parameter.span(-0.5f, 1f), Climate.Parameter.point(1.0f),
					Climate.Parameter.span(-0.35f, 0.35f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(-12107173).waterFogColor(-12107173).skyColor(7972607).foliageColorOverride(-11895745).grassColorOverride(-12687307).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addSavannaGrass(biomeGenerationSettings);
		BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).temperature(2f).downfall(0f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}
