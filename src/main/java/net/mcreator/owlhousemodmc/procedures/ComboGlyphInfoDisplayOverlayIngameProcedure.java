package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.ComboGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class ComboGlyphInfoDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure ComboGlyphInfoDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ComboGlyphItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == ComboGlyphItem.block;
	}
}
