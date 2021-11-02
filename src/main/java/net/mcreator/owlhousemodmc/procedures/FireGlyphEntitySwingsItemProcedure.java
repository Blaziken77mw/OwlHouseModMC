package net.mcreator.owlhousemodmc.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.FireGlyphProjectileItem;
import net.mcreator.owlhousemodmc.item.FireGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Random;
import java.util.Map;

@OwlhousemodmcModElements.ModElement.Tag
public class FireGlyphEntitySwingsItemProcedure extends OwlhousemodmcModElements.ModElement {
	public FireGlyphEntitySwingsItemProcedure(OwlhousemodmcModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure FireGlyphEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FireGlyphItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(FireGlyphItem.block, (int) (1));
				_setstack.setCount(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FireGlyphItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(FireGlyphItem.block, (int) (1));
				_setstack.setCount(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
								- 1));
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
		if ((((entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new OwlhousemodmcModVariables.PlayerVariables())).GlyphCooldown) <= 0)) {
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					FireGlyphProjectileItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 3, (int) 2);
				}
			}
			{
				double _setval = (double) 10;
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GlyphCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
