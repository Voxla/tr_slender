
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.trslender.TrSlenderMod;

public class TrSlenderModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TrSlenderMod.MODID);
	public static final RegistryObject<SoundEvent> PIANOSCARE = REGISTRY.register("pianoscare", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "pianoscare")));
	public static final RegistryObject<SoundEvent> PAGEGRAB = REGISTRY.register("pagegrab", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "pagegrab")));
	public static final RegistryObject<SoundEvent> PAGEHIT = REGISTRY.register("pagehit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "pagehit")));
	public static final RegistryObject<SoundEvent> SLENDERSTATIC = REGISTRY.register("slenderstatic", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "slenderstatic")));
	public static final RegistryObject<SoundEvent> PAGE1AND2 = REGISTRY.register("page1and2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "page1and2")));
	public static final RegistryObject<SoundEvent> PAGE3AND4 = REGISTRY.register("page3and4", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "page3and4")));
	public static final RegistryObject<SoundEvent> PAGE5AND6 = REGISTRY.register("page5and6", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "page5and6")));
	public static final RegistryObject<SoundEvent> PAGE7 = REGISTRY.register("page7", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "page7")));
	public static final RegistryObject<SoundEvent> PONDER = REGISTRY.register("ponder", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tr_slender", "ponder")));
}
