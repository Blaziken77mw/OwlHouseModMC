
package net.mcreator.owlhousemodmc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.owlhousemodmc.procedures.OwlBeastCurseLivingEntityIsHitWithItemProcedure;
import net.mcreator.owlhousemodmc.procedures.OwlBeastCurseLivingEntityIsHitWithItem2Procedure;
import net.mcreator.owlhousemodmc.itemgroup.OwlHouseCursesItemGroup;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@OwlhousemodmcModElements.ModElement.Tag
public class OwlBeastCurseItem extends OwlhousemodmcModElements.ModElement {
	@ObjectHolder("owlhousemodmc:owl_beast_curse")
	public static final Item block = null;
	public OwlBeastCurseItem(OwlhousemodmcModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OwlHouseCursesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("owl_beast_curse");
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
			list.add(new StringTextComponent(
					"Left click an entity to curse them. They will transform into the owl beast every 10 minutes and will be unable to use magic! Of course you could curse yourself by right clicking..."));
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
				$_dependencies.put("world", world);
				OwlBeastCurseLivingEntityIsHitWithItemProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			boolean retval = super.hitEntity(itemstack, entity, sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				OwlBeastCurseLivingEntityIsHitWithItem2Procedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
