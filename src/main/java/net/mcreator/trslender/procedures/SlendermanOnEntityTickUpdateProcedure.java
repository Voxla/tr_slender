package net.mcreator.trslender.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.trslender.network.TrSlenderModVariables;
import net.mcreator.trslender.init.TrSlenderModMobEffects;
import net.mcreator.trslender.init.TrSlenderModBlocks;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Comparator;

public class SlendermanOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double loopNum = 0;
		double itemNum = 0;
		double teleportXpos = 0;
		double teleportZpos = 0;
		double slenderteleporttimer = 0;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).isEmpty()) {
			if ((new Object() {
				public Entity func(Entity player, double entityReach) {
					double distance = entityReach * entityReach;
					Vec3 eyePos = player.getEyePosition(1.0f);
					HitResult hitResult = entity.pick(entityReach, 1.0f, false);
					if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
						distance = hitResult.getLocation().distanceToSqr(eyePos);
						double blockReach = 5;
						if (distance > blockReach * blockReach) {
							Vec3 pos = hitResult.getLocation();
							hitResult = BlockHitResult.miss(pos, Direction.getNearest(eyePos.x, eyePos.y, eyePos.z), BlockPos.containing(pos));
						}
					}
					Vec3 viewVec = player.getViewVector(1.0F);
					Vec3 toVec = eyePos.add(viewVec.x * entityReach, viewVec.y * entityReach, viewVec.z * entityReach);
					AABB aabb = entity.getBoundingBox().expandTowards(viewVec.scale(entityReach)).inflate(1.0D, 1.0D, 1.0D);
					EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyePos, toVec, aabb, (p_234237_) -> {
						return !p_234237_.isSpectator();
					}, distance);
					if (entityhitresult != null) {
						Entity entity1 = entityhitresult.getEntity();
						Vec3 targetPos = entityhitresult.getLocation();
						double distanceToTarget = eyePos.distanceToSqr(targetPos);
						if (distanceToTarget > distance || distanceToTarget > entityReach * entityReach) {
							hitResult = BlockHitResult.miss(targetPos, Direction.getNearest(viewVec.x, viewVec.y, viewVec.z), BlockPos.containing(targetPos));
						} else if (distanceToTarget < distance) {
							hitResult = entityhitresult;
						}
					}
					if (hitResult.getType() == HitResult.Type.ENTITY) {
						return ((EntityHitResult) hitResult).getEntity();
					}
					return null;
				}
			}.func(entity, 7)) instanceof Player) {
				if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TrSlenderModMobEffects.SLENDER_STATIC.get(), 20, 0, false, false));
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TrSlenderModMobEffects.SLENDERS_DISAPPEAR_EFFECT.get()) ? _livEnt.getEffect(TrSlenderModMobEffects.SLENDERS_DISAPPEAR_EFFECT.get()).getDuration() : 0) == 1) {
			if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if (itemNum >= 8) {
				if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
		loopNum = 0;
		itemNum = 0;
		for (int index0 = 0; index0 < 36; index0++) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
				if (TrSlenderModBlocks.PAGE.get().asItem() == (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) loopNum, ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)))).getItem()) {
					itemNum = itemNum + (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
							return _retval.get();
						}
					}.getItemStack((int) loopNum, ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)))).getCount();
				}
			}
			loopNum = loopNum + 1;
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
			{
				double _setval = itemNum;
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerpagenumber = _setval;
					capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)));
				});
			}
		}
		if (itemNum >= 8) {
			if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 14, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 100);
			}
		} else if (itemNum == 7) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 12, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 150);
			}
		} else if (itemNum == 6) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 10, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 250);
			}
		} else if (itemNum == 5) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 7, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 400);
			}
		} else if (itemNum == 4) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 5, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 600);
			}
		} else if (itemNum == 3) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 4, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 700);
			}
		} else if (itemNum == 2) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 3, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 900);
			}
		} else if (itemNum == 1) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
			}
			if (entity.getPersistentData().getDouble("slenderteleporttimer") == 0) {
				entity.getPersistentData().putDouble("slenderteleporttimer", 1100);
			}
		}
		if (!(itemNum >= 8)) {
			if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 255, false, false));
			}
		}
		if (itemNum >= 8) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 255, false, false));
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
			teleportXpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -20, 20);
			teleportZpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -20, 20);
		}
		if (entity.getPersistentData().getDouble("slenderteleporttimer") > 0) {
			entity.getPersistentData().putDouble("slenderteleporttimer", (entity.getPersistentData().getDouble("slenderteleporttimer") - 1));
		}
		if (entity.getPersistentData().getDouble("slenderteleporttimer") == 1) {
			if (itemNum >= 8) {
				if (!world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
						{
							Entity _ent = entity;
							_ent.teleportTo(teleportXpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) teleportXpos, (int) teleportZpos)), teleportZpos);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(teleportXpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) teleportXpos, (int) teleportZpos)), teleportZpos, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			} else if (itemNum < 8) {
				if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("tr_slender:tainted_forest"))) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
						{
							Entity _ent = entity;
							_ent.teleportTo(teleportXpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) teleportXpos, (int) teleportZpos)), teleportZpos);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(teleportXpos, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) teleportXpos, (int) teleportZpos)), teleportZpos, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())));
		}
		if (entity.isPassenger()) {
			(entity.getVehicle()).hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 200);
			if (entity.isPassenger()) {
				entity.stopRiding();
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
			if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
		}
	}
}
