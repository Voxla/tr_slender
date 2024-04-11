package net.mcreator.trslender.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.trslender.entity.ProxyEntity;

public class ProxyPanicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof ProxyEntity) {
			if (entity.isOnFire()) {
				return true;
			}
		}
		return false;
	}
}
