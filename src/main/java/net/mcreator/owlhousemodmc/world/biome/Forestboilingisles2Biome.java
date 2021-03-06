
package net.mcreator.owlhousemodmc.world.biome;

import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@OwlhousemodmcModElements.ModElement.Tag
public class Forestboilingisles2Biome extends OwlhousemodmcModElements.ModElement {

	public static Biome biome;

	public Forestboilingisles2Biome(OwlhousemodmcModElements instance) {
		super(instance, 109);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-6750004).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(-6750004).withFoliageColor(-2204066).withGrassColor(-2282966)
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("owlhousemodmc:gromfright")), 12000, 24000, true))
						.build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
								Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));

				biomeGenerationSettings.withStructure(StructureFeatures.SHIPWRECK);

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.TREE
								.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
										new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
										new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
										new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build())
								.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(2));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
										ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(4));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withDesertDeadBushes(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CAVE_SPIDER, 10, 1, 3));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.STRAY, 20, 2, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 20, 4, 5));

				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0.1f).scale(0.3f).temperature(0.5f)
						.downfall(0.7000000000000001f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("owlhousemodmc:forestboilingisles_2"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

}
