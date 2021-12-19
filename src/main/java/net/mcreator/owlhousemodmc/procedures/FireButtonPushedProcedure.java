package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

public class FireButtonPushedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireButtonPushed!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency guistate for procedure FireButtonPushed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell1");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("spell1",
					"fire");
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell2");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("spell2",
					"fire");
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell3");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("spell3",
					"fire");
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell4");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("spell4",
					"fire");
		}
	}
}
