package net.mcreator.owlhousemodmc.procedures;

public class RemovecurseEffectStartedappliedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure RemovecurseEffectStartedapplied!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
	}

}
