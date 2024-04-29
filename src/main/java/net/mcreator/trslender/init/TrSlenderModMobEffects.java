
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.trslender.potion.SlendersDisappearEffectMobEffect;
import net.mcreator.trslender.potion.SlenderStaticMobEffect;
import net.mcreator.trslender.potion.MidnightCurseMobEffect;
import net.mcreator.trslender.potion.HallucinationsMobEffect;
import net.mcreator.trslender.TrSlenderMod;

public class TrSlenderModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TrSlenderMod.MODID);
	public static final RegistryObject<MobEffect> SLENDER_STATIC = REGISTRY.register("slender_static", () -> new SlenderStaticMobEffect());
	public static final RegistryObject<MobEffect> MIDNIGHT_CURSE = REGISTRY.register("midnight_curse", () -> new MidnightCurseMobEffect());
	public static final RegistryObject<MobEffect> SLENDERS_DISAPPEAR_EFFECT = REGISTRY.register("slenders_disappear_effect", () -> new SlendersDisappearEffectMobEffect());
	public static final RegistryObject<MobEffect> HALLUCINATIONS = REGISTRY.register("hallucinations", () -> new HallucinationsMobEffect());
}
