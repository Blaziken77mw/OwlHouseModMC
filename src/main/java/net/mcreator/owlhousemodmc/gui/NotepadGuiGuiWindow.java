
package net.mcreator.owlhousemodmc.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NotepadGuiGuiWindow extends ContainerScreen<NotepadGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NotepadGuiGui.guistate;
	public NotepadGuiGuiWindow(NotepadGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 250;
		this.ySize = 220;
	}
	private static final ResourceLocation texture = new ResourceLocation("owlhousemodmc:textures/notepad_gui.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/lightglyph.png"));
		this.blit(ms, this.guiLeft + 20, this.guiTop + 29, 0, 0, 33, 33, 33, 33);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/fireglyph.png"));
		this.blit(ms, this.guiLeft + 196, this.guiTop + 29, 0, 0, 33, 33, 33, 33);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/plantglyph.png"));
		this.blit(ms, this.guiLeft + 134, this.guiTop + 29, 0, 0, 33, 33, 33, 33);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/iceglyph.png"));
		this.blit(ms, this.guiLeft + 80, this.guiTop + 29, 0, 0, 33, 33, 33, 33);
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
		this.addButton(new Button(this.guiLeft + 11, this.guiTop + 67, 50, 20, new StringTextComponent("Light"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new NotepadGuiGui.ButtonPressedMessage(0, x, y, z));
				NotepadGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + 67, 40, 20, new StringTextComponent("Ice"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new NotepadGuiGui.ButtonPressedMessage(1, x, y, z));
				NotepadGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 125, this.guiTop + 67, 50, 20, new StringTextComponent("Plant"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new NotepadGuiGui.ButtonPressedMessage(2, x, y, z));
				NotepadGuiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 189, this.guiTop + 67, 45, 20, new StringTextComponent("Fire"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new NotepadGuiGui.ButtonPressedMessage(3, x, y, z));
				NotepadGuiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
