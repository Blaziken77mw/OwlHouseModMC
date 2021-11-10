
package net.mcreator.owlhousemodmc.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.owlhousemodmc.procedures.ChargeEmptyDisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.Charge75DisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.Charge50DisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.Charge25DisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.Charge10DisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.Charge100DisplayProcedure;
import net.mcreator.owlhousemodmc.procedures.BileChargeDisplayOverlayIngameProcedure;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@OwlhousemodmcModElements.ModElement.Tag
public class BileChargeOverlay extends OwlhousemodmcModElements.ModElement {
	public BileChargeOverlay(OwlhousemodmcModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (BileChargeDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				if (ChargeEmptyDisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged0.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
				if (Charge10DisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged10.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
				if (Charge25DisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged25.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
				if (Charge50DisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged50.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
				if (Charge75DisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged75.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
				if (Charge100DisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("owlhousemodmc:textures/charged100.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + -4, 0, 0, 44, 119, 44, 119);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
