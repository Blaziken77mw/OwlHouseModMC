package net.mcreator.owlhousemodmc.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.particle.SpellCircleParticle;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class SpellCastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure SpellCast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure SpellCast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure SpellCast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure SpellCast!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure SpellCast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (false);
			entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SpellRecharging = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("owlhousemodmc:spellcast")),
					SoundCategory.PLAYERS, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("owlhousemodmc:spellcast")),
					SoundCategory.PLAYERS, (float) 1, (float) 1, false);
		}
		if ((entity.getHorizontalFacing()) == Direction.NORTH) {
			world.addParticle(SpellCircleParticle.particle, x, (y + 1.5), (z - 1), 0, 0, 0);
		} else {
			if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
				world.addParticle(SpellCircleParticle.particle, x, (y + 1.5), (z + 1), 0, 0, 0);
			} else {
				if ((entity.getHorizontalFacing()) == Direction.WEST) {
					world.addParticle(SpellCircleParticle.particle, (x - 1), (y + 1.5), z, 0, 0, 0);
				} else {
					if ((entity.getHorizontalFacing()) == Direction.EAST) {
						world.addParticle(SpellCircleParticle.particle, (x + 1), (y + 1.5), z, 0, 0, 0);
					} else {
						world.addParticle(SpellCircleParticle.particle, x, (y + 1.5), z, 0, 0, 0);
					}
				}
			}
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				{
					boolean _setval = (true);
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpellRecharging = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
