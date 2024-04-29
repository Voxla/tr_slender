
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrSlenderModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SLENDER_THE_EIGHT_PAGES_MODE = GameRules.register("slenderTheEightPagesMode", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
