package net.mcreator.trslender.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.trslender.TrSlenderMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrSlenderModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TrSlenderMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			if (!event.isWasDeath()) {
				clone.staticnorm = original.staticnorm;
				clone.staticlowpac = original.staticlowpac;
				clone.pondermusicnumber = original.pondermusicnumber;
				clone.playerpagenumber = original.playerpagenumber;
				clone.playerslendermusictimer = original.playerslendermusictimer;
				clone.pagecollected1and2 = original.pagecollected1and2;
				clone.pagecollected3and4 = original.pagecollected3and4;
				clone.pagecollected5and6 = original.pagecollected5and6;
				clone.pagecollected7 = original.pagecollected7;
				clone.loopnumber = original.loopnumber;
				clone.crazytimer = original.crazytimer;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("tr_slender", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double staticnorm = 0;
		public double staticlowpac = 0;
		public double pondermusicnumber = 0;
		public double playerpagenumber = 0;
		public double playerslendermusictimer = 0;
		public double pagecollected1and2 = 0;
		public double pagecollected3and4 = 0;
		public double pagecollected5and6 = 0;
		public double pagecollected7 = 0;
		public double loopnumber = 0;
		public double crazytimer = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TrSlenderMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("staticnorm", staticnorm);
			nbt.putDouble("staticlowpac", staticlowpac);
			nbt.putDouble("pondermusicnumber", pondermusicnumber);
			nbt.putDouble("playerpagenumber", playerpagenumber);
			nbt.putDouble("playerslendermusictimer", playerslendermusictimer);
			nbt.putDouble("pagecollected1and2", pagecollected1and2);
			nbt.putDouble("pagecollected3and4", pagecollected3and4);
			nbt.putDouble("pagecollected5and6", pagecollected5and6);
			nbt.putDouble("pagecollected7", pagecollected7);
			nbt.putDouble("loopnumber", loopnumber);
			nbt.putDouble("crazytimer", crazytimer);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			staticnorm = nbt.getDouble("staticnorm");
			staticlowpac = nbt.getDouble("staticlowpac");
			pondermusicnumber = nbt.getDouble("pondermusicnumber");
			playerpagenumber = nbt.getDouble("playerpagenumber");
			playerslendermusictimer = nbt.getDouble("playerslendermusictimer");
			pagecollected1and2 = nbt.getDouble("pagecollected1and2");
			pagecollected3and4 = nbt.getDouble("pagecollected3and4");
			pagecollected5and6 = nbt.getDouble("pagecollected5and6");
			pagecollected7 = nbt.getDouble("pagecollected7");
			loopnumber = nbt.getDouble("loopnumber");
			crazytimer = nbt.getDouble("crazytimer");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.staticnorm = message.data.staticnorm;
					variables.staticlowpac = message.data.staticlowpac;
					variables.pondermusicnumber = message.data.pondermusicnumber;
					variables.playerpagenumber = message.data.playerpagenumber;
					variables.playerslendermusictimer = message.data.playerslendermusictimer;
					variables.pagecollected1and2 = message.data.pagecollected1and2;
					variables.pagecollected3and4 = message.data.pagecollected3and4;
					variables.pagecollected5and6 = message.data.pagecollected5and6;
					variables.pagecollected7 = message.data.pagecollected7;
					variables.loopnumber = message.data.loopnumber;
					variables.crazytimer = message.data.crazytimer;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
