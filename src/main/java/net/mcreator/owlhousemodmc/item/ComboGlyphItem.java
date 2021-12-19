
package net.mcreator.owlhousemodmc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

@OwlhousemodmcModElements.ModElement.Tag
public class ComboGlyphItem extends OwlhousemodmcModElements.ModElement {
	@ObjectHolder("owlhousemodmc:combo_glyph")
	public static final Item block = null;

	public ComboGlyphItem(OwlhousemodmcModElements instance) {
		super(instance, 70);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("combo_glyph");
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
