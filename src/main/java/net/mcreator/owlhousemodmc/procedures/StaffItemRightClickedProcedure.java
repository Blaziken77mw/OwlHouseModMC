package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class StaffItemRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure StaffItemRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double yaw = 0;
		double speed = 0;
		double pitch = 0;
		speed = 1.5;
		yaw = (entity.rotationYaw);
		pitch = (entity.rotationPitch);
		entity.setMotion((speed * Math.cos((yaw + 90) * Math.PI / 180)), (speed * (-1) * Math.sin(pitch / 180 * Math.PI)),
				(speed * Math.sin((yaw + 90) * Math.PI / 180)));
	}
}
