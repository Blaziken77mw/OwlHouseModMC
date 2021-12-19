package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.FireGlyphProjectileItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class FireSpellCastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure FireSpellCast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure FireSpellCast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure FireSpellCast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure FireSpellCast!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireSpellCast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge >= 15) {
			{
				double _setval = ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge - 15);
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpellCharge = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					FireGlyphProjectileItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1.5, (float) 5, (int) 5);
				}
			}
			SpellCastProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
