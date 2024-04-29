
package net.mcreator.trslender.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.trslender.procedures.ProxyPanicProcedure;
import net.mcreator.trslender.procedures.ProxyEntityDiesProcedure;
import net.mcreator.trslender.procedures.HoodieavoidprocProcedure;
import net.mcreator.trslender.procedures.HoodieOnInitialEntitySpawnProcedure;
import net.mcreator.trslender.procedures.HoodieOnEntityTickUpdateProcedure;
import net.mcreator.trslender.procedures.HoodieNaturalEntitySpawningConditionProcedure;
import net.mcreator.trslender.procedures.HoodieAttackProcProcedure;
import net.mcreator.trslender.init.TrSlenderModEntities;

import javax.annotation.Nullable;

import java.util.Set;

@Mod.EventBusSubscriber
public class HoodieEntity extends Monster {
	private static final Set<ResourceLocation> SPAWN_BIOMES = Set.of(new ResourceLocation("tr_slender:tainted_forests"), new ResourceLocation("tr_slender:tainted_forest"));

	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		if (SPAWN_BIOMES.contains(event.getName()))
			event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(TrSlenderModEntities.HOODIE.get(), 20, 1, 1));
	}

	public HoodieEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TrSlenderModEntities.HOODIE.get(), world);
	}

	public HoodieEntity(EntityType<HoodieEntity> type, Level world) {
		super(type, world);
		maxUpStep = 0.6f;
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, (float) 300, 1.7, 1.7) {
			@Override
			public boolean canUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canUse() && HoodieavoidprocProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canContinueToUse() && HoodieavoidprocProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new PanicGoal(this, 2) {
			@Override
			public boolean canUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canUse() && ProxyPanicProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canContinueToUse() && ProxyPanicProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ProxyEntity.class, true, false) {
			@Override
			public boolean canUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canUse() && HoodieAttackProcProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canContinueToUse() && HoodieAttackProcProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, true, false) {
			@Override
			public boolean canUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canUse() && HoodieAttackProcProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canContinueToUse() && HoodieAttackProcProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 4;
			}

			@Override
			public boolean canUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canUse() && HoodieAttackProcProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HoodieEntity.this.getX();
				double y = HoodieEntity.this.getY();
				double z = HoodieEntity.this.getZ();
				Entity entity = HoodieEntity.this;
				Level world = HoodieEntity.this.level;
				return super.canContinueToUse() && HoodieAttackProcProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		ProxyEntityDiesProcedure.execute(this.level, this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		HoodieOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HoodieOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
		SpawnPlacements.register(TrSlenderModEntities.HOODIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return HoodieNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.32);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 26);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
		return builder;
	}
}
