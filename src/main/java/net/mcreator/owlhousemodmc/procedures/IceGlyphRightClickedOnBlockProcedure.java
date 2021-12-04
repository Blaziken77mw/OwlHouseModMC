package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.RayTraceContext;
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

import net.mcreator.owlhousemodmc.item.IceGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

public class IceGlyphRightClickedOnBlockProcedure {
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
		if ((!(new Object() {
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
		}.checkGamemode(entity)))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == IceGlyphItem.block)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(IceGlyphItem.block);
					_setstack.setCount(
							(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == IceGlyphItem.block)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(IceGlyphItem.block);
					_setstack.setCount(
							(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
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
				IceGlyphUpFullProcedure.executeProcedure($_dependencies);
			}
		} else {
			if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.DOWN)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					IceGlyphDownFullProcedure.executeProcedure($_dependencies);
				}
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
						IceGlyphNorthFullProcedure.executeProcedure($_dependencies);
					}
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
							IceGlyphSouthFullProcedure.executeProcedure($_dependencies);
						}
					} else {
						if (((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 10, entity.getLook(1f).y * 10, entity.getLook(1f).z * 10),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getFace()) == Direction.WEST)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								IceGlyphWestFullProcedure.executeProcedure($_dependencies);
							}
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
