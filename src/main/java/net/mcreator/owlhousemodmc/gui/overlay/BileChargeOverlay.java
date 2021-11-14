
package net.mcreator.owlhousemodmc.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
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

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@Mod.EventBusSubscriber
public class BileChargeOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
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
