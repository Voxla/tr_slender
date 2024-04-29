
package net.mcreator.trslender.block;

import net.minecraftforge.common.util.ForgeSoundType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Collections;

public class TaintedStairsBlock extends StairBlock {
	public TaintedStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(),
				BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")), () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_step")),
								() -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")), () -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break")),
								() -> new SoundEvent(new ResourceLocation("tr_slender:tainted_wood_break"))))
						.strength(3f, 1200f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 1200f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState p_56947_) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
