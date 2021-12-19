package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.block.PortalDoorTopOpenBlock;
import net.mcreator.owlhousemodmc.block.PortalDoorBottomOpenBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class PortalDoorBottomOnBlockRightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure PortalDoorBottomOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure PortalDoorBottomOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure PortalDoorBottomOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure PortalDoorBottomOnBlockRightClicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = PortalDoorBottomOpenBlock.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlockState(_bp, _bs, 3);
		}
		{
			BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
			BlockState _bs = PortalDoorTopOpenBlock.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlockState(_bp, _bs, 3);
		}
		if (world instanceof World)
			((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
					((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock());
		if (world instanceof World)
			((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) (y + 1), (int) z),
					((World) world).getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).getBlock());
	}
}
