
package net.mcreator.owlhousemodmc.gui;

import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

@OnlyIn(Dist.CLIENT)
public class InsidediaryGuiWindow extends ContainerScreen<InsidediaryGui.GuiContainerMod> {

	private World world;
	private int x, y, z;
	private PlayerEntity entity;

	private final static HashMap guistate = InsidediaryGui.guistate;

	public InsidediaryGuiWindow(InsidediaryGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("owlhousemodmc:textures/insidediary.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("owlhousemodmc:textures/static-assets-upload2874270387487832228.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -2, 0, 0, 197, 170, 197, 170);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);

		this.addButton(new Button(this.guiLeft + 106, this.guiTop + 146, 70, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new InsidediaryGui.ButtonPressedMessage(0, x, y, z));
				InsidediaryGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}

}