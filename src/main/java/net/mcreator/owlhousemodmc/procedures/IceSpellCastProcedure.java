package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

public class IceSpellCastProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure IceSpellCast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure IceSpellCast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure IceSpellCast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure IceSpellCast!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure IceSpellCast!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge) >= 15)) {
			{
				double _setval = (double) (((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge) - 15);
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpellCharge = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SpellCastProcedure.executeProcedure($_dependencies);
			}
			if ((!(((world
					.getBlockState(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(
											new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
													.getBlock() == Blocks.AIR)
					|| ((world
							.getBlockState(new BlockPos(
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
													.getBlock() == Blocks.AIR)))) {
				if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x",
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()));
						$_dependencies.put("y",
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()));
						$_dependencies.put("z",
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
						IceGlyphUpFullProcedure.executeProcedure($_dependencies);
					}
				} else {
					if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.DOWN)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x",
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()));
							$_dependencies.put("y",
									((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - 2));
							$_dependencies.put("z",
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
							IceGlyphDownFullProcedure.executeProcedure($_dependencies);
						}
					} else {
						if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.NORTH)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x",
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
														entity.getLook(1f).z * 7),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()));
								$_dependencies.put("y",
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
														entity.getLook(1f).z * 7),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()));
								$_dependencies.put("z",
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
														entity.getLook(1f).z * 7),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
								IceGlyphNorthFullProcedure.executeProcedure($_dependencies);
							}
						} else {
							if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.SOUTH)) {
								{
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()));
									$_dependencies.put("y",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()));
									$_dependencies.put("z",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
									IceGlyphSouthFullProcedure.executeProcedure($_dependencies);
								}
							} else {
								if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST)) {
									{
										Map<String, Object> $_dependencies = new HashMap<>();
										$_dependencies.put("world", world);
										$_dependencies
												.put("x",
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()));
										$_dependencies
												.put("y",
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()));
										$_dependencies
												.put("z",
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()));
										IceGlyphWestFullProcedure.executeProcedure($_dependencies);
									}
								} else {
									if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getFace()) == Direction.EAST)) {
										{
											Map<String, Object> $_dependencies = new HashMap<>();
											$_dependencies.put("world", world);
											$_dependencies.put("x",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()));
											$_dependencies.put("y",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()));
											$_dependencies.put("z",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getZ()));
											IceGlyphEastFullProcedure.executeProcedure($_dependencies);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
