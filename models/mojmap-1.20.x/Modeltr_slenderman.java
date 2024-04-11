// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltr_slenderman<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tr_slenderman"), "main");
	private final ModelPart tr_slenderman;

	public Modeltr_slenderman(ModelPart root) {
		this.tr_slenderman = root.getChild("tr_slenderman");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tr_slenderman = partdefinition.addOrReplaceChild("tr_slenderman", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = tr_slenderman.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(
				-4.0F, -39.0F, -2.0F, 8.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F,
				-47.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition l_arm = body.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(24, 16).addBox(4.0F,
				-39.0F, -1.5F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition r_arm = body.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F,
				-39.0F, -1.5F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition l_leg = tr_slenderman.addOrReplaceChild("l_leg", CubeListBuilder.create().texOffs(36, 0).addBox(
				0.5F, -23.0F, -1.5F, 3.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition r_leg = tr_slenderman.addOrReplaceChild("r_leg", CubeListBuilder.create().texOffs(12, 36).addBox(
				-3.5F, -23.0F, -1.5F, 3.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		tr_slenderman.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}