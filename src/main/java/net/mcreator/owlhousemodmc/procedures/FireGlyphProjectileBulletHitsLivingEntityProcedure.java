package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class FireGlyphProjectileBulletHitsLivingEntityProcedure extends OwlhousemodmcModElements.ModElement {
	public FireGlyphProjectileBulletHitsLivingEntityProcedure(OwlhousemodmcModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireGlyphProjectileBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
