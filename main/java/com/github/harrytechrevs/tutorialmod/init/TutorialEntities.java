package com.github.harrytechrevs.tutorialmod.init;

import com.github.harrytechrevs.tutorialmod.TutorialModRegistries;
import com.github.harrytechrevs.tutorialmod.entities.TutorialEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class TutorialEntities 
{
	public static EntityType<?> tutorial_entity = EntityType.Builder.create(TutorialEntity::new, EntityClassification.CREATURE).build(TutorialModRegistries.MODID + ":tutorial_entity").setRegistryName(TutorialModRegistries.location("tutorial_entity"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			TutorialItems.tutorial_entity_egg = registerEntitySpawnEgg(tutorial_entity, 0x2f5882, 0x6f1499, "tutorial_entity_egg")
		);
		
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(tutorial_entity, Biomes.PLAINS, Biomes.BEACH, Biomes.JUNGLE);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(TutorialModRegistries.TUTORIAL));
		item.setRegistryName(TutorialModRegistries.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
