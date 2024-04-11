
package net.mcreator.trslender.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.trslender.entity.SlendermanEntity;
import net.mcreator.trslender.client.model.Modeltr_slenderman;

public class SlendermanRenderer extends MobRenderer<SlendermanEntity, Modeltr_slenderman<SlendermanEntity>> {
	public SlendermanRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltr_slenderman(context.bakeLayer(Modeltr_slenderman.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SlendermanEntity entity) {
		return new ResourceLocation("tr_slender:textures/entities/tr_slenderman.png");
	}
}
