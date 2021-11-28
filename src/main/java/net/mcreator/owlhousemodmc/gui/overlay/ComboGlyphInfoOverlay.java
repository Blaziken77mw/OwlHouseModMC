
package net.mcreator.owlhousemodmc.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.owlhousemodmc.procedures.ComboGlyphInfoDisplayOverlayIngameProcedure;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;

import com.google.common.collect.ImmutableMap;

@Mod.EventBusSubscriber
public class ComboGlyphInfoOverlay {
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
			if (ComboGlyphInfoDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"Medium: " + ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new OwlhousemodmcModVariables.PlayerVariables())).ComboGlyphMedium) + "",
								posX + 99, posY + 41, -65536);
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"Primary: " + ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new OwlhousemodmcModVariables.PlayerVariables())).ComboGlyphPrimary) + "",
								posX + 99, posY + 50, -65536);
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"Secondary: " + ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new OwlhousemodmcModVariables.PlayerVariables())).ComboGlyphSecondary) + "",
								posX + 99, posY + 59, -65536);
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"Modifier: " + ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new OwlhousemodmcModVariables.PlayerVariables())).ComboGlyphModifier) + "",
								posX + 99, posY + 68, -65536);
			}
		}
	}
}
