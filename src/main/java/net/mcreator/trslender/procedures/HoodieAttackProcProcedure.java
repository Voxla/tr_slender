package net.mcreator.trslender.procedures;

import net.minecraft.world.entity.Entity;

public class HoodieAttackProcProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("hasthrownpotion") == false) {
			return true;
		}
		return false;
	}
}
