package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.world.GameType;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.owlhousemodmc.item.FireGlyphProjectileItem;
import net.mcreator.owlhousemodmc.item.FireGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Random;
import java.util.Map;

public class FireGlyphEntitySwingsItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireGlyphEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).GlyphCooldown <= 0) {
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
						.getItem() == FireGlyphItem.block) {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(FireGlyphItem.block);
						_setstack.setCount(
								(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getCount() - 1));
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == FireGlyphItem.block) {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(FireGlyphItem.block);
						_setstack.setCount(
								(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getCount() - 1));
						((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
			}
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					FireGlyphProjectileItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 3, (int) 2);
				}
			}
			{
				double _setval = 10;
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GlyphCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
