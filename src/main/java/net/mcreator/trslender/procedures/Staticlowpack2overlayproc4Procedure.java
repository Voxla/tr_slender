package net.mcreator.trslender.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.trslender.network.TrSlenderModVariables;
import net.mcreator.trslender.init.TrSlenderModMobEffects;

public class Staticlowpack2overlayproc4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TrSlenderModMobEffects.SLENDER_STATIC.get()) : false) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 290
						&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 437) {
					if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticlowpac == 3) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
