
package net.mcreator.owlhousemodmc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlHouseItemsItemGroup extends OwlhousemodmcModElements.ModElement {
	public OwlHouseItemsItemGroup(OwlhousemodmcModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabowl_house_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.COBBLESTONE, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
