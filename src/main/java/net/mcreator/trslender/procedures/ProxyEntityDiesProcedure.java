package net.mcreator.trslender.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.trslender.TrSlenderMod;

public class ProxyEntityDiesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TrSlenderMod.queueServerWork(18, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 18, 0.3, 1, 0.3, 0.01);
		});
	}
}
