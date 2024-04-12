package net.mcreator.trslender.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.trslender.init.TrSlenderModBlocks;

public class TaintedTreeLargeAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -6;
		found = false;
		for (int index0 = 0; index0 < 12; index0++) {
			sy = -6;
			for (int index1 = 0; index1 < 12; index1++) {
				sz = -6;
				for (int index2 = 0; index2 < 12; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.WATER
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BRICKS || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.WAXED_OXIDIZED_CUT_COPPER
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.POLISHED_ANDESITE
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TrSlenderModBlocks.TAINTED_PLANKS.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.SMOOTH_STONE || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TrSlenderModBlocks.PAGE.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			return false;
		}
		if (found == true) {
			return false;
		}
		return true;
	}
}
