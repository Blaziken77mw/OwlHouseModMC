package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

public class LightButtonPushedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure LightButtonPushed!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure LightButtonPushed!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency guistate for procedure LightButtonPushed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (world.isRemote()) {
			if (new Object() {
				public boolean getValue() {
					CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell1");
					if (checkbox != null) {
						return checkbox.isChecked();
					}
					return false;
				}
			}.getValue()) {
				{
					String _setval = "light";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Spell1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
				{
					String _setval = "light";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Spell2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
				{
					String _setval = "light";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Spell3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
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
				{
					String _setval = "light";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Spell4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (new Object() {
				public boolean getValue() {
					CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:Spell1");
					if (checkbox != null) {
						return checkbox.isChecked();
					}
					return false;
				}
			}.getValue()) {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("spell1", "light");
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
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("spell2", "light");
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
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("spell3", "light");
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
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("spell4", "light");
			}
		}
	}
}
