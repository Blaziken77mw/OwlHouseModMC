package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class SpellbookItemItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure SpellbookItemItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("spell1"));
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Spell1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("spell2"));
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Spell2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("spell3"));
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Spell2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("spell4"));
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Spell3 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
