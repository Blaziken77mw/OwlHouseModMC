
package net.mcreator.owlhousemodmc.item;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlStaffItem extends OwlhousemodmcModElements.ModElement {

	@ObjectHolder("owlhousemodmc:owl_staff")
	public static final Item block = null;

	public OwlStaffItem(OwlhousemodmcModElements instance) {
		super(instance, 46);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseStaffsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("owl_staff");
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
