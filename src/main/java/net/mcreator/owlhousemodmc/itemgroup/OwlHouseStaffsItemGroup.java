
package net.mcreator.owlhousemodmc.itemgroup;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlHouseStaffsItemGroup extends OwlhousemodmcModElements.ModElement {

	public OwlHouseStaffsItemGroup(OwlhousemodmcModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabowl_house_staffs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PortalKeyItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
