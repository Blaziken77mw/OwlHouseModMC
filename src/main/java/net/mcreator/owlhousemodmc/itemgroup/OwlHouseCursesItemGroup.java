
package net.mcreator.owlhousemodmc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlHouseCursesItemGroup extends OwlhousemodmcModElements.ModElement {
	public OwlHouseCursesItemGroup(OwlhousemodmcModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabowl_house_curses") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.PAPER);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
