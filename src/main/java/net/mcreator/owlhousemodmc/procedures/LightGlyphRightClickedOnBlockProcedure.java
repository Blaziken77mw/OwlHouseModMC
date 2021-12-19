package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.mcreator.owlhousemodmc.item.LightGlyphItem;
import net.mcreator.owlhousemodmc.block.LightGlyphBlockBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;

public class LightGlyphRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency world for procedure LightGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency x for procedure LightGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency y for procedure LightGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency z for procedure LightGlyphRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure LightGlyphRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == LightGlyphItem.block) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(LightGlyphItem.block);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == LightGlyphItem.block) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(LightGlyphItem.block);
					_setstack.setCount(
							(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
		if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.UP
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR
						|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), LightGlyphBlockBlock.block.getDefaultState(), 3);
		} else {
			if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.NORTH
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR
							|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), LightGlyphBlockBlock.block.getDefaultState(), 3);
			} else {
				if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
						entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.SOUTH
						&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR
								|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), LightGlyphBlockBlock.block.getDefaultState(), 3);
				} else {
					if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST
							&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
									|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), LightGlyphBlockBlock.block.getDefaultState(), 3);
					} else {
						if ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.EAST
								&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
										|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), LightGlyphBlockBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
		}
	}
}
