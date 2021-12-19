
package net.mcreator.owlhousemodmc.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SpellbookGuiGuiWindow extends ContainerScreen<SpellbookGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SpellbookGuiGui.guistate;
	CheckboxButton Spell1;
	CheckboxButton Spell3;
	CheckboxButton Spell4;
	CheckboxButton Spell2;

	public SpellbookGuiGuiWindow(SpellbookGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 280;
		this.ySize = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("owlhousemodmc:textures/spellbook_gui.png");

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
		Spell1 = new CheckboxButton(this.guiLeft + 31, this.guiTop + 16, 150, 20, new StringTextComponent("Primary spell"), false);
		SpellbookGuiGui.guistate.put("checkbox:Spell1", Spell1);
		this.addButton(Spell1);
		Spell3 = new CheckboxButton(this.guiLeft + 166, this.guiTop + 16, 150, 20, new StringTextComponent("Spell 3"), false);
		SpellbookGuiGui.guistate.put("checkbox:Spell3", Spell3);
		this.addButton(Spell3);
		Spell4 = new CheckboxButton(this.guiLeft + 166, this.guiTop + 43, 150, 20, new StringTextComponent("Spell 4"), false);
		SpellbookGuiGui.guistate.put("checkbox:Spell4", Spell4);
		this.addButton(Spell4);
		this.addButton(new Button(this.guiLeft + 13, this.guiTop + 79, 54, 20, new StringTextComponent("Light"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new SpellbookGuiGui.ButtonPressedMessage(0, x, y, z));
				SpellbookGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 13, this.guiTop + 106, 54, 20, new StringTextComponent("Ice"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new SpellbookGuiGui.ButtonPressedMessage(1, x, y, z));
				SpellbookGuiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 13, this.guiTop + 133, 54, 20, new StringTextComponent("Plant"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new SpellbookGuiGui.ButtonPressedMessage(2, x, y, z));
				SpellbookGuiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 13, this.guiTop + 160, 54, 20, new StringTextComponent("Fire"), e -> {
			if (true) {
				OwlhousemodmcMod.PACKET_HANDLER.sendToServer(new SpellbookGuiGui.ButtonPressedMessage(3, x, y, z));
				SpellbookGuiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		Spell2 = new CheckboxButton(this.guiLeft + 31, this.guiTop + 43, 150, 20, new StringTextComponent("Secondary spell"), false);
		SpellbookGuiGui.guistate.put("checkbox:Spell2", Spell2);
		this.addButton(Spell2);
	}
}
