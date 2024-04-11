package net.mcreator.trslender.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.trslender.network.TrSlenderModVariables;
import net.mcreator.trslender.init.TrSlenderModMobEffects;

public class Staticnormrender5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TrSlenderModMobEffects.SLENDER_STATIC.get())) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 30
						&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 33
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 30
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 32
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 27
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 29
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 18
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 20
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 14
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 16
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 10
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 12
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 8
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 10
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 6
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 8
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 4
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 6
						|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm > 2
								&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticnorm < 4) {
					if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).staticlowpac == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
