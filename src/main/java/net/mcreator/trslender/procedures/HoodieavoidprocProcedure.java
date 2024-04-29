package net.mcreator.trslender.procedures;

import net.minecraft.world.entity.Entity;

public class HoodieavoidprocProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("hasthrownpotion") == true) {
			return true;
		}
		return false;
	}
}
