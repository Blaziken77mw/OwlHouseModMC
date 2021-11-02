package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.owlhousemodmc.block.TempIceBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class BuildIceGlyphEastProcedure extends OwlhousemodmcModElements.ModElement {
	public BuildIceGlyphEastProcedure(OwlhousemodmcModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure BuildIceGlyphEast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure BuildIceGlyphEast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure BuildIceGlyphEast!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure BuildIceGlyphEast!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)), TempIceBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)), TempIceBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + (-1)), (int) (z + 0)))).getBlock() == Blocks.AIR.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + (-1)), (int) (z + 0)))).getBlock() == Blocks.CAVE_AIR
						.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + (-1)), (int) (z + 0)), TempIceBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)), TempIceBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + (-1))))).getBlock() == Blocks.AIR.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + (-1))))).getBlock() == Blocks.CAVE_AIR
						.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + (-1))), TempIceBlock.block.getDefaultState(), 3);
		}
	}
}
