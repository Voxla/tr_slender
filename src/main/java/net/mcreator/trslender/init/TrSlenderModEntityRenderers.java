
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.trslender.client.renderer.SlendermanRenderer;
import net.mcreator.trslender.client.renderer.ProxyRenderer;
import net.mcreator.trslender.client.renderer.HoodieRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TrSlenderModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TrSlenderModEntities.SLENDERMAN.get(), SlendermanRenderer::new);
		event.registerEntityRenderer(TrSlenderModEntities.PROXY.get(), ProxyRenderer::new);
		event.registerEntityRenderer(TrSlenderModEntities.HOODIE.get(), HoodieRenderer::new);
	}
}
