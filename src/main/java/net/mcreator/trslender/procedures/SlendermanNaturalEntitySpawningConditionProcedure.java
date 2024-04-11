package net.mcreator.trslender.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.trslender.entity.SlendermanEntity;

import java.io.File;

public class SlendermanNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		File lurker = new File("");
		if (!(!world.getEntitiesOfClass(SlendermanEntity.class, AABB.ofSize(new Vec3(x, y, z), 2000, 2000, 2000), e -> true).isEmpty())) {
			if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (Math.random() >= 0.9 && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					return true;
				}
			}
		}
		return false;
	}
}
