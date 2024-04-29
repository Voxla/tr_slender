
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trslender.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.trslender.entity.SlendermanEntity;
import net.mcreator.trslender.entity.ProxyEntity;
import net.mcreator.trslender.entity.HoodieEntity;
import net.mcreator.trslender.TrSlenderMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrSlenderModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, TrSlenderMod.MODID);
	public static final RegistryObject<EntityType<SlendermanEntity>> SLENDERMAN = register("slenderman", EntityType.Builder.<SlendermanEntity>of(SlendermanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(200)
			.setUpdateInterval(3).setCustomClientFactory(SlendermanEntity::new).fireImmune().sized(0.6f, 2.8f));
	public static final RegistryObject<EntityType<ProxyEntity>> PROXY = register("proxy",
			EntityType.Builder.<ProxyEntity>of(ProxyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ProxyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HoodieEntity>> HOODIE = register("hoodie",
			EntityType.Builder.<HoodieEntity>of(HoodieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HoodieEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SlendermanEntity.init();
			ProxyEntity.init();
			HoodieEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SLENDERMAN.get(), SlendermanEntity.createAttributes().build());
		event.put(PROXY.get(), ProxyEntity.createAttributes().build());
		event.put(HOODIE.get(), HoodieEntity.createAttributes().build());
	}
}
