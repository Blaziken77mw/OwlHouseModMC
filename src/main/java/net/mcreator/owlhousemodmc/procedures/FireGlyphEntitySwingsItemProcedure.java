package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.FireGlyphProjectileItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Random;
import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class FireGlyphEntitySwingsItemProcedure extends OwlhousemodmcModElements.ModElement {
	public FireGlyphEntitySwingsItemProcedure(OwlhousemodmcModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireGlyphEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).GlyphCooldown) <= 0)) {
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					FireGlyphProjectileItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 3, (int) 2);
				}
			}
			{
				double _setval = (double) 10;
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GlyphCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
