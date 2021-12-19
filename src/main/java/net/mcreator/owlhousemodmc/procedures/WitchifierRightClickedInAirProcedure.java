package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class WitchifierRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure WitchifierRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (true);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SpellRecharging = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0;
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SpellCharge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0.5;
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RechargeRate = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
