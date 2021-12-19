
package net.mcreator.owlhousemodmc.item;

@OwlhousemodmcModElements.ModElement.Tag
public class TrainingWandItem extends OwlhousemodmcModElements.ModElement {

	@ObjectHolder("owlhousemodmc:training_wand")
	public static final Item block = null;

	public TrainingWandItem(OwlhousemodmcModElements instance) {
		super(instance, 104);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseItemsItemGroup.tab).maxDamage(50).rarity(Rarity.COMMON));
			setRegistryName("training_wand");
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
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Warning! as of right now using this without using the spellbook first will crash!"));
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
				$_dependencies.put("itemstack", itemstack);

				TrainingWandRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

	}

}
