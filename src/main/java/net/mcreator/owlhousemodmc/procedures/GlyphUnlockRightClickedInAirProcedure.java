package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class GlyphUnlockRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure GlyphUnlockRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LightGlyphFound = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IceGlyphFound = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlantGlyphFound = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FireGlyphFound = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
