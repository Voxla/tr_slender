package net.mcreator.trslender.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.trslender.network.TrSlenderModVariables;
import net.mcreator.trslender.init.TrSlenderModMobEffects;
import net.mcreator.trslender.init.TrSlenderModEntities;
import net.mcreator.trslender.entity.SlendermanEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SlenderStillProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double itemNum = 0;
		double teleportXpos = 0;
		double teleportZpos = 0;
		double loopNum = 0;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @p at @s anchored eyes facing entity @e[distance=..200,type=tr_slender:slenderman] eyes anchored feet positioned ^ ^ ^1 rotated as @s positioned ^ ^ ^-1 if entity @s[distance=..1.00] run effect give @e[type=tr_slender:slenderman] minecraft:slowness 1 255 true");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @p at @s anchored eyes facing entity @e[distance=..25,type=tr_slender:slenderman] eyes anchored feet positioned ^ ^ ^1 rotated as @s positioned ^ ^ ^-1 if entity @s[distance=..1.00] run effect give @p tr_slender:slender_static 1 0 true");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @p at @s anchored eyes facing entity @e[distance=..100,type=tr_slender:slenderman] eyes anchored feet positioned ^ ^ ^1 rotated as @s positioned ^ ^ ^-1 if entity @s[distance=..1.00] run effect give @e[type=tr_slender:slenderman] tr_slender:slenders_disappear_effect 2 0 true");
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TrSlenderModMobEffects.MIDNIGHT_CURSE.get(), 1, 0, false, false));
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pondermusicnumber < 3) {
				{
					double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pondermusicnumber + 1;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pondermusicnumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pondermusicnumber == 2) {
				if (Math.random() > 0.9) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound tr_slender:ponder record @p ~ ~ ~ 1 1");
				}
			}
		} else if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pondermusicnumber > 0) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:ponder");
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pondermusicnumber = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/stopsound @p record tr_slender:page1and2");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/stopsound @p record tr_slender:page3and4");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/stopsound @p record tr_slender:page5and6");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/stopsound @p record tr_slender:page7");
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected1and2 > 0) {
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected1and2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected3and4 > 0) {
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected3and4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected5and6 > 0) {
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected5and6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected7 > 0) {
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 0
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber >= 8) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page1and2");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page3and4");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page5and6");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page7");
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 1
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 2) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page3and4");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page5and6");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page7");
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 4) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page1and2");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page5and6");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page7");
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 5
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 6) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page1and2");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page3and4");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page7");
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 7) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page1and2");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page3and4");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/stopsound @p record tr_slender:page5and6");
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber > 0
					&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer == 0) {
				{
					double _setval = 2400;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerslendermusictimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected1and2 == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected3and4 == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected5and6 == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected7 == 3) {
				{
					double _setval = 2400;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerslendermusictimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber > 0
					&& (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer > 0) {
				{
					double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer - 1;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerslendermusictimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 0) {
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected1and2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected3and4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected5and6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 1
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 2) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected1and2 < 4) {
					{
						double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected1and2 + 1;
						entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pagecollected1and2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected3and4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected5and6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 4) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected3and4 < 4) {
					{
						double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected3and4 + 1;
						entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pagecollected3and4 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected1and2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected5and6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 5
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 6) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected5and6 < 4) {
					{
						double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected5and6 + 1;
						entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pagecollected5and6 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected1and2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected3and4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected7 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 7) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected7 < 4) {
					{
						double _setval = (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).pagecollected7 + 1;
						entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pagecollected7 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected1and2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected3and4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.pagecollected5and6 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 1
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 2) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer == 2399) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound tr_slender:page1and2 record @p ~ ~ ~ 1 1");
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 3
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 4) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer == 2399) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound tr_slender:page3and4 record @p ~ ~ ~ 1 1");
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 5
					|| (entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 6) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer == 2399) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound tr_slender:page5and6 record @p ~ ~ ~ 1 1");
				}
			} else if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber == 7) {
				if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerslendermusictimer == 2399) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/playsound tr_slender:page7 record @p ~ ~ ~ 1 1");
				}
			}
			if (!(!world.getEntitiesOfClass(SlendermanEntity.class, AABB.ofSize(new Vec3(x, y, z), 3000, 3000, 3000), e -> true).isEmpty())) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if ((entity.getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber < 8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TrSlenderModEntities.SLENDERMAN.get().spawn(_level,
									BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -20, 20), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z + Mth.nextInt(RandomSource.create(), -20, 20)),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
		}
	}
}
