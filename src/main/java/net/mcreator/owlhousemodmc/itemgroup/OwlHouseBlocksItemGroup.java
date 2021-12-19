
package net.mcreator.owlhousemodmc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.owlhousemodmc.block.GlyphWorkbenchBlock;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlHouseBlocksItemGroup extends OwlhousemodmcModElements.ModElement {
	public OwlHouseBlocksItemGroup(OwlhousemodmcModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabowl_house_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlyphWorkbenchBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
