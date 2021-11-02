package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class FireGlyphItemInHandTickProcedure extends OwlhousemodmcModElements.ModElement {
	public FireGlyphItemInHandTickProcedure(OwlhousemodmcModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireGlyphItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).GlyphCooldown) > 0)) {
			{
				double _setval = (double) (((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new OwlhousemodmcModVariables.PlayerVariables())).GlyphCooldown) - 1);
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GlyphCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
