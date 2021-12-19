
package net.mcreator.owlhousemodmc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.procedures.StaffItemRightClickedProcedure;
import net.mcreator.owlhousemodmc.procedures.StaffItemInHandProcedure;
import net.mcreator.owlhousemodmc.itemgroup.OwlHouseStaffsItemGroup;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@OwlhousemodmcModElements.ModElement.Tag
public class MechanicalstaffItem extends OwlhousemodmcModElements.ModElement {
	@ObjectHolder("owlhousemodmc:mechanicalstaff")
	public static final Item block = null;

	public MechanicalstaffItem(OwlhousemodmcModElements instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseStaffsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("mechanicalstaff");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			StaffItemRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected)

				StaffItemInHandProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
