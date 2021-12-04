
package net.mcreator.owlhousemodmc.item;

@OwlhousemodmcModElements.ModElement.Tag
public class StrangeDiaryItem extends OwlhousemodmcModElements.ModElement {

	@ObjectHolder("owlhousemodmc:strange_diary")
	public static final Item block = null;

	public StrangeDiaryItem(OwlhousemodmcModElements instance) {
		super(instance, 101);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("strange_diary");
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

			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				StrangeDiaryRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

	}

}
