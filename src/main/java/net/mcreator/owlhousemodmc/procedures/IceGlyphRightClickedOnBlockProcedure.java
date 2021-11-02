package net.mcreator.owlhousemodmc.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.IceGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

@OwlhousemodmcModElements.ModElement.Tag
public class IceGlyphRightClickedOnBlockProcedure extends OwlhousemodmcModElements.ModElement {
	public IceGlyphRightClickedOnBlockProcedure(OwlhousemodmcModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure IceGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure IceGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure IceGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure IceGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure IceGlyphRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(IceGlyphItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(IceGlyphItem.block, (int) (1));
				_setstack.setCount(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(IceGlyphItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(IceGlyphItem.block, (int) (1));
				_setstack.setCount(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
		if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP)) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
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
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", (y + 1));
						$_dependencies.put("z", z);
						BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
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
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", (y + 2));
						$_dependencies.put("z", z);
						BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
		} else {
			if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.DOWN)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y - 2));
					$_dependencies.put("z", z);
					BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
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
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y - 3));
							$_dependencies.put("z", z);
							BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 10);
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
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y - 4));
							$_dependencies.put("z", z);
							BuildIceGlyphUpProcedure.executeProcedure($_dependencies);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 10);
			} else {
				if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.NORTH)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						BuildIceGlyphNorthProcedure.executeProcedure($_dependencies);
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
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", (z - 1));
								BuildIceGlyphNorthProcedure.executeProcedure($_dependencies);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
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
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", (z - 2));
								BuildIceGlyphNorthProcedure.executeProcedure($_dependencies);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else {
					if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.SOUTH)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							BuildIceGlyphSouthProcedure.executeProcedure($_dependencies);
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
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", (z + 1));
									BuildIceGlyphSouthProcedure.executeProcedure($_dependencies);
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
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
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", (z + 2));
									BuildIceGlyphSouthProcedure.executeProcedure($_dependencies);
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
					} else {
						if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("entity", entity);
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								FireGlyphRightClickedOnBlockProcedure.executeProcedure($_dependencies);
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
										Map<String, Object> $_dependencies = new HashMap<>();
										$_dependencies.put("world", world);
										$_dependencies.put("x", (x - 1));
										$_dependencies.put("y", y);
										$_dependencies.put("z", z);
										BuildIceGlyphWestProcedure.executeProcedure($_dependencies);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 10);
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
										Map<String, Object> $_dependencies = new HashMap<>();
										$_dependencies.put("world", world);
										$_dependencies.put("x", (x - 2));
										$_dependencies.put("y", y);
										$_dependencies.put("z", z);
										BuildIceGlyphWestProcedure.executeProcedure($_dependencies);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 10);
						} else {
							if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.EAST)) {
								{
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", z);
									BuildIceGlyphEastProcedure.executeProcedure($_dependencies);
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
											Map<String, Object> $_dependencies = new HashMap<>();
											$_dependencies.put("world", world);
											$_dependencies.put("x", (x + 1));
											$_dependencies.put("y", y);
											$_dependencies.put("z", z);
											BuildIceGlyphEastProcedure.executeProcedure($_dependencies);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 10);
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
											Map<String, Object> $_dependencies = new HashMap<>();
											$_dependencies.put("world", world);
											$_dependencies.put("x", (x + 2));
											$_dependencies.put("y", y);
											$_dependencies.put("z", z);
											BuildIceGlyphEastProcedure.executeProcedure($_dependencies);
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 10);
							}
						}
					}
				}
			}
		}
	}
}
