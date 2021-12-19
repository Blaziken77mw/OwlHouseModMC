package net.mcreator.owlhousemodmc.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.OwlBeastCurseItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class OwlBeastCurseLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure OwlBeastCurseLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure OwlBeastCurseLivingEntityIsHitWithItem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(OwlBeastCurseItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		while (true) {
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
					for (int index1 = 0; index1 < (int) (2400); index1++) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 2, (int) 2));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 2, (int) 2));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 2, (int) 2));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 2, (int) 1));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 2, (int) 2));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 2, (int) 1));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 1));
						{
							boolean _setval = (false);
							entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SpellRecharging = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SpellCharge = _setval;
								capability.syncPlayerVariables(entity);
							});
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
						}.start(world, (int) 1);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 12000);
		}
	}
}
