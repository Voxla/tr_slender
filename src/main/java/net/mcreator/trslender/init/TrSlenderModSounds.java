
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrSlenderModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("tr_slender", "pianoscare"), new SoundEvent(new ResourceLocation("tr_slender", "pianoscare")));
		REGISTRY.put(new ResourceLocation("tr_slender", "pagegrab"), new SoundEvent(new ResourceLocation("tr_slender", "pagegrab")));
		REGISTRY.put(new ResourceLocation("tr_slender", "pagehit"), new SoundEvent(new ResourceLocation("tr_slender", "pagehit")));
		REGISTRY.put(new ResourceLocation("tr_slender", "slenderstatic"), new SoundEvent(new ResourceLocation("tr_slender", "slenderstatic")));
		REGISTRY.put(new ResourceLocation("tr_slender", "page1and2"), new SoundEvent(new ResourceLocation("tr_slender", "page1and2")));
		REGISTRY.put(new ResourceLocation("tr_slender", "page3and4"), new SoundEvent(new ResourceLocation("tr_slender", "page3and4")));
		REGISTRY.put(new ResourceLocation("tr_slender", "page5and6"), new SoundEvent(new ResourceLocation("tr_slender", "page5and6")));
		REGISTRY.put(new ResourceLocation("tr_slender", "page7"), new SoundEvent(new ResourceLocation("tr_slender", "page7")));
		REGISTRY.put(new ResourceLocation("tr_slender", "ponder"), new SoundEvent(new ResourceLocation("tr_slender", "ponder")));
		REGISTRY.put(new ResourceLocation("tr_slender", "tainted_wood_break"), new SoundEvent(new ResourceLocation("tr_slender", "tainted_wood_break")));
		REGISTRY.put(new ResourceLocation("tr_slender", "tainted_wood_step"), new SoundEvent(new ResourceLocation("tr_slender", "tainted_wood_step")));
		REGISTRY.put(new ResourceLocation("tr_slender", "forest_wind"), new SoundEvent(new ResourceLocation("tr_slender", "forest_wind")));
		REGISTRY.put(new ResourceLocation("tr_slender", "tainted_grass_step"), new SoundEvent(new ResourceLocation("tr_slender", "tainted_grass_step")));
		REGISTRY.put(new ResourceLocation("tr_slender", "forest_ambient"), new SoundEvent(new ResourceLocation("tr_slender", "forest_ambient")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
