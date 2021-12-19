
package net.mcreator.owlhousemodmc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.itemgroup.OwlHouseItemsItemGroup;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

@OwlhousemodmcModElements.ModElement.Tag
public class BrokenportalkeyItem extends OwlhousemodmcModElements.ModElement {
	@ObjectHolder("owlhousemodmc:brokenportalkey")
	public static final Item block = null;

	public BrokenportalkeyItem(OwlhousemodmcModElements instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("brokenportalkey");
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
	}
}
