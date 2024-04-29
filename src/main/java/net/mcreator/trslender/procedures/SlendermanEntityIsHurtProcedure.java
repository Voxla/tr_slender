package net.mcreator.trslender.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

public class SlendermanEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!(sourceentity instanceof Player) && !(sourceentity instanceof ServerPlayer)) {
			sourceentity.hurt(DamageSource.OUT_OF_WORLD, 200);
		}
	}
}
