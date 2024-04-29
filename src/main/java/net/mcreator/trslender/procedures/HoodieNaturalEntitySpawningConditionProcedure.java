package net.mcreator.trslender.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trslender.entity.HoodieEntity;

public class HoodieNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() > 0.9) {
			if (!(!world.getEntitiesOfClass(HoodieEntity.class, AABB.ofSize(new Vec3(x, y, z), 3000, 3000, 3000), e -> true).isEmpty())) {
				return true;
			}
		}
		return false;
	}
}
