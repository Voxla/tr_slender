
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.trslender.client.model.Modeltr_slenderman;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TrSlenderModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeltr_slenderman.LAYER_LOCATION, Modeltr_slenderman::createBodyLayer);
	}
}
