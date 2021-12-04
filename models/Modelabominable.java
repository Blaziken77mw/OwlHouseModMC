// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelabominable<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "abominable"), "main");
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Chest;

	public Modelabominable(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Head = root.getChild("Head");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.Chest = root.getChild("Chest");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(26, 16)
				.addBox(-3.0F, -2.0F, -3.5F, 6.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 7.0F, 0.5F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(52, 14)
				.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 7.0F, 0.5F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(19, 42)
				.addBox(-4.0F, -9.0F, -4.0F, 8.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -11.0F, -1.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-3.0F, -2.0F, -3.5F, 6.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(11.0F, -11.0F, 0.5F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(49, 37)
				.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-10.5F, -11.0F, 0.5F));

		PartDefinition Chest = partdefinition.addOrReplaceChild("Chest",
				CubeListBuilder.create().texOffs(46, 0)
						.addBox(-6.0F, 0.0F, -2.5F, 12.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, -9.0F, -3.5F, 16.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
		RightArm.render(poseStack, buffer, packedLight, packedOverlay);
		Chest.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}