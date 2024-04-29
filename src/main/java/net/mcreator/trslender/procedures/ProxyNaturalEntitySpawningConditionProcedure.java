package net.mcreator.trslender.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trslender.entity.ProxyEntity;

public class ProxyNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(ProxyEntity.class, AABB.ofSize(new Vec3(x, y, z), 3000, 3000, 3000), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
