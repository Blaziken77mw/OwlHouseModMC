
package net.mcreator.owlhousemodmc.world.dimension;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.owlhousemodmc.procedures.BoilingIslesPlayerEntersDimensionProcedure;
import net.mcreator.owlhousemodmc.OwlhousemodmcModElements;

import java.util.stream.Stream;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.AbstractMap;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

import com.google.common.collect.ImmutableSet;

@OwlhousemodmcModElements.ModElement.Tag
public class BoilingIslesDimension extends OwlhousemodmcModElements.ModElement {
	public BoilingIslesDimension(OwlhousemodmcModElements instance) {
		super(instance, 26);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Set<Block> replaceableBlocks = new HashSet<>();
		replaceableBlocks.add(Blocks.STONE);
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:forest_boiling_isles")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:forest_boiling_isles")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:plainsboilingisles_2")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:plainsboilingisles_2")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:palistrom_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:palistrom_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:forestboilingisles_2")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:forestboilingisles_2")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:eclipse_lake")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:eclipse_lake")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:plains_boiling_isles")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("owlhousemodmc:plains_boiling_isles")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
			@Override
			public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
				return color.mul(sunHeight * 0.94 + 0.06, sunHeight * 0.94 + 0.06, sunHeight * 0.91 + 0.09);
			}

			@Override
			public boolean func_230493_a_(int x, int y) {
				return false;
			}
		};
		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper
						.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("owlhousemodmc:boiling_isles"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getPlayer();
		World world = entity.world;
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		if (event.getTo() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("owlhousemodmc:boiling_isles"))) {

			BoilingIslesPlayerEntersDimensionProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
							new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
