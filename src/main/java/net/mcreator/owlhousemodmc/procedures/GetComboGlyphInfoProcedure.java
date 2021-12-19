package net.mcreator.owlhousemodmc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.owlhousemodmc.item.ComboGlyphItem;
import net.mcreator.owlhousemodmc.OwlhousemodmcModVariables;
import net.mcreator.owlhousemodmc.OwlhousemodmcMod;

import java.util.Map;
import java.util.HashMap;

public class GetComboGlyphInfoProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OwlhousemodmcMod.LOGGER.warn("Failed to load dependency entity for procedure GetComboGlyphInfo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == ComboGlyphItem.block) {
			{
				String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getString("medium"));
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ComboGlyphMedium = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getString("primary"));
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ComboGlyphPrimary = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getString("secondary"));
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ComboGlyphSecondary = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getString("modifier"));
				entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ComboGlyphModifier = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == ComboGlyphItem.block) {
				{
					String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getOrCreateTag().getString("medium"));
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphMedium = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getOrCreateTag().getString("primary"));
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphPrimary = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getOrCreateTag().getString("secondary"));
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphSecondary = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getOrCreateTag().getString("modifier"));
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphModifier = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					String _setval = "";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphMedium = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphPrimary = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphSecondary = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "";
					entity.getCapability(OwlhousemodmcModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ComboGlyphModifier = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
