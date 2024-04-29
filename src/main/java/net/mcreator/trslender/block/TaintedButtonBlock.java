
package net.mcreator.trslender.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Collections;

public class TaintedButtonBlock extends WoodButtonBlock {
	public TaintedButtonBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")), () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_step")),
						() -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")), () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")),
						() -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break"))))
				.strength(3f, 1200f));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
