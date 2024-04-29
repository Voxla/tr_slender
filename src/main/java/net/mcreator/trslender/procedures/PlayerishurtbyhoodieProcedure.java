package net.mcreator.trslender.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trslender.init.TrSlenderModMobEffects;
import net.mcreator.trslender.entity.ProxyEntity;
import net.mcreator.trslender.entity.HoodieEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerishurtbyhoodieProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player && (sourceentity instanceof HoodieEntity || sourceentity instanceof ProxyEntity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TrSlenderModMobEffects.HALLUCINATIONS.get(), 60, 0, false, false));
		}
	}
}
