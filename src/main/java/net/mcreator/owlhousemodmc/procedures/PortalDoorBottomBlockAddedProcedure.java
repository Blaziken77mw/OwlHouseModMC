package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.owlhousemodmc.block.PortalDoorTopOpenBlock;
import net.mcreator.owlhousemodmc.block.PortalDoorTopBlock;
import net.mcreator.owlhousemodmc.block.PortalDoorBottomBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class PortalDoorBottomBlockAddedProcedure extends OwlhousemodmcModElements.ModElement {
	public PortalDoorBottomBlockAddedProcedure(OwlhousemodmcModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure PortalDoorBottomBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure PortalDoorBottomBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure PortalDoorBottomBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure PortalDoorBottomBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock()))
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == PortalDoorTopOpenBlock.block.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PortalDoorTopBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, (new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (property != null)
									return _bs.get(property);
								return Direction.getFacingFromAxisDirection(
										_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
										Direction.AxisDirection.POSITIVE);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z)))), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), (new Object() {
								public Direction getDirection(BlockPos pos) {
									try {
										BlockState _bs = world.getBlockState(pos);
										DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
										if (property != null)
											return _bs.get(property);
										return Direction.getFacingFromAxisDirection(
												_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
												Direction.AxisDirection.POSITIVE);
									} catch (Exception e) {
										return Direction.NORTH;
									}
								}
							}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getAxis()), 3);
				}
			} catch (Exception e) {
			}
		} else {
			world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(PortalDoorBottomBlock.block.getDefaultState()));
		}
	}
}
