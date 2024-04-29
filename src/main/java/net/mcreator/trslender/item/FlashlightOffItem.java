
package net.mcreator.trslender.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.trslender.procedures.FlashlightOffRightclickedProcedure;

public class FlashlightOffItem extends Item {
	public FlashlightOffItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(1000).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FlashlightOffRightclickedProcedure.execute(world, x, y, z, entity, itemstack);
		return ar;
	}
}
