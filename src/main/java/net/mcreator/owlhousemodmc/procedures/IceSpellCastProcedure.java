package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class IceSpellCastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure IceSpellCast!");
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
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure IceSpellCast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge >= 15) {
			{
				double _setval = ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new OwlhousemodmcModVariables.PlayerVariables())).SpellCharge - 15);
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpellCharge = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			SpellCastProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (!((world
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
													.getBlock() == Blocks.AIR
					|| (world
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
													.getBlock() == Blocks.AIR)) {
				if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP) {
					IceGlyphUpFullProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world),
									new AbstractMap.SimpleEntry<>("x",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX())),
									new AbstractMap.SimpleEntry<>("y",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())),
									new AbstractMap.SimpleEntry<>("z",
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
															entity.getLook(1f).z * 7),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else {
					if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.DOWN) {
						IceGlyphDownFullProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world",
										world),
										new AbstractMap.SimpleEntry<>("x", (entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX())),
										new AbstractMap.SimpleEntry<>("y", (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
														entity.getLook(1f).z * 7),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()
												- 2)),
										new AbstractMap.SimpleEntry<>("z",
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																entity.getLook(1f).z * 7),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else {
						if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.NORTH) {
							IceGlyphNorthFullProcedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world),
											new AbstractMap.SimpleEntry<>("x",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX())),
											new AbstractMap.SimpleEntry<>("y",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY())),
											new AbstractMap.SimpleEntry<>("z",
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																	entity.getLook(1f).z * 7),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getZ())))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else {
							if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.SOUTH) {
								IceGlyphSouthFullProcedure
										.executeProcedure(Stream
												.of(new AbstractMap.SimpleEntry<>("world", world),
														new AbstractMap.SimpleEntry<>("x", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX())),
														new AbstractMap.SimpleEntry<>("y", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY())),
														new AbstractMap.SimpleEntry<>("z", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ())))
												.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							} else {
								if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST) {
									IceGlyphWestFullProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world),
													new AbstractMap.SimpleEntry<>(
															"x",
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																			entity.getLook(1f).z * 7),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX())),
													new AbstractMap.SimpleEntry<>("y",
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																			entity.getLook(1f).z * 7),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY())),
													new AbstractMap.SimpleEntry<>("z",
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
																			entity.getLook(1f).z * 7),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								} else {
									if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 7, entity.getLook(1f).y * 7,
													entity.getLook(1f).z * 7),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getFace()) == Direction.EAST) {
										IceGlyphEastFullProcedure.executeProcedure(Stream
												.of(new AbstractMap.SimpleEntry<>("world", world),
														new AbstractMap.SimpleEntry<>("x", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX())),
														new AbstractMap.SimpleEntry<>("y", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY())),
														new AbstractMap.SimpleEntry<>("z", (entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 7,
																				entity.getLook(1f).y * 7, entity.getLook(1f).z * 7),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ())))
												.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
