package net.mcreator.trslender.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.trslender.init.TrSlenderModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HallucinationsEffects1OnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean Reset = false;
		if (world.isClientSide() && entity instanceof Player) {
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TrSlenderModMobEffects.HALLUCINATIONS.get()) : false) && Reset != true)) {
				if (!(Minecraft.getInstance().gameRenderer.currentEffect() == null)) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
					Reset = false;
				}
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TrSlenderModMobEffects.HALLUCINATIONS.get()) : false) {
				if (!(Minecraft.getInstance().gameRenderer.currentEffect() != null)) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/phosphor.json"));
					Reset = true;
				}
			}
		}
	}
}
