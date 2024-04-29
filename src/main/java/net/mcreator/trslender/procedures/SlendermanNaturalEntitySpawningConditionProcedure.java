package net.mcreator.trslender.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.trslender.network.TrSlenderModVariables;
import net.mcreator.trslender.entity.SlendermanEntity;

import java.util.Comparator;

public class SlendermanNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y > 60) {
			if (!(!world.getEntitiesOfClass(SlendermanEntity.class, AABB.ofSize(new Vec3(x, y, z), 2000, 2000, 2000), e -> true).isEmpty())) {
				if (!(new ResourceLocation("tr_slender:tainted_forest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
						&& new ResourceLocation("tr_slender:tainted_forests").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName()))) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).isEmpty()) {
						if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber < 8) {
							if (Math.random() >= 0.9 && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
								return true;
							}
						} else if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 700, 700, 700), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(TrSlenderModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TrSlenderModVariables.PlayerVariables())).playerpagenumber >= 8) {
							if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
								return true;
							}
						}
					}
				} else if (new ResourceLocation("tr_slender:tainted_forest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
						|| new ResourceLocation("tr_slender:tainted_forests").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())) {
					if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
