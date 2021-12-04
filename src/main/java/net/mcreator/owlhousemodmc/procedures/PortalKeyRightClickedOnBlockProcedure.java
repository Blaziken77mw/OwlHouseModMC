package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.block.PortalDoorBottomBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Random;
import java.util.Map;

public class PortalKeyRightClickedOnBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency itemstack for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure PortalKeyRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.world.getDimensionKey()) == (World.OVERWORLD))) {
			world.setBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("surfaceX")),
					(int) (((itemstack).getOrCreateTag().getDouble("surfaceY")) + 1), (int) ((itemstack).getOrCreateTag().getDouble("surfaceZ"))),
					Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("surfaceX")),
					(int) (((itemstack).getOrCreateTag().getDouble("surfaceY")) + 2), (int) ((itemstack).getOrCreateTag().getDouble("surfaceZ"))),
					Blocks.AIR.getDefaultState(), 3);
			(itemstack).getOrCreateTag().putDouble("surfaceX", x);
			(itemstack).getOrCreateTag().putDouble("surfaceY", y);
			(itemstack).getOrCreateTag().putDouble("surfaceZ", z);
			{
				ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else if (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("owlhousemodmc:boiling_isles"))))) {
			world.setBlockState(
					new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("islesX")),
							(int) (((itemstack).getOrCreateTag().getDouble("islesY")) + 1), (int) ((itemstack).getOrCreateTag().getDouble("islesZ"))),
					Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(
					new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("islesX")),
							(int) (((itemstack).getOrCreateTag().getDouble("islesY")) + 2), (int) ((itemstack).getOrCreateTag().getDouble("islesZ"))),
					Blocks.AIR.getDefaultState(), 3);
			(itemstack).getOrCreateTag().putDouble("islesX", x);
			(itemstack).getOrCreateTag().putDouble("islesY", y);
			(itemstack).getOrCreateTag().putDouble("islesZ", z);
			{
				ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
		if ((((entity.world.getDimensionKey()) == (World.OVERWORLD)) || ((entity.world.getDimensionKey()) == (RegistryKey
				.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("owlhousemodmc:boiling_isles")))))) {
			if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP)
					&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR)
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PortalDoorBottomBlock.block.getDefaultState(), 3);
				try {
					BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, (entity.getHorizontalFacing())), 3);
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
								_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
										(entity.getHorizontalFacing()).getAxis()),
								3);
					}
				} catch (Exception e) {
				}
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			} else {
				if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.NORTH)
						&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR)
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR)))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), PortalDoorBottomBlock.block.getDefaultState(), 3);
					try {
						BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
						DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (_property != null) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.NORTH), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
									_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
											Direction.NORTH.getAxis()),
									3);
						}
					} catch (Exception e) {
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.SOUTH)
							&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR)
									|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR)))) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), PortalDoorBottomBlock.block.getDefaultState(), 3);
						try {
							BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
							DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							if (_property != null) {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.SOUTH), 3);
							} else {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
										_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
												Direction.SOUTH.getAxis()),
										3);
							}
						} catch (Exception e) {
						}
						{
							ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
							if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
					} else {
						if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST)
								&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR)
										|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR)))) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), PortalDoorBottomBlock.block.getDefaultState(), 3);
							try {
								BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
								DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (_property != null) {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.WEST), 3);
								} else {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
											_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
													Direction.WEST.getAxis()),
											3);
								}
							} catch (Exception e) {
							}
							{
								ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
								if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
									_ist.shrink(1);
									_ist.setDamage(0);
								}
							}
						} else {
							if ((((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.EAST)
									&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR)
											|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR)))) {
								world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), PortalDoorBottomBlock.block.getDefaultState(), 3);
								try {
									BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
									DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (_property != null) {
										world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.EAST), 3);
									} else {
										world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
												_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
														Direction.EAST.getAxis()),
												3);
									}
								} catch (Exception e) {
								}
								{
									ItemStack _ist = ((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getHeldItemMainhand()
											: ItemStack.EMPTY);
									if (_ist.attemptDamageItem((int) 0.2, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
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
