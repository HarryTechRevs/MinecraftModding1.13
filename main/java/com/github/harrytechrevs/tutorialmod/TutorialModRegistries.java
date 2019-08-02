package com.github.harrytechrevs.tutorialmod;

import org.apache.logging.log4j.Logger;

import com.github.harrytechrevs.tutorialmod.init.TutorialArmorMaterials;
import com.github.harrytechrevs.tutorialmod.init.TutorialBiomes;
import com.github.harrytechrevs.tutorialmod.init.TutorialBlocks;
import com.github.harrytechrevs.tutorialmod.init.TutorialEntities;
import com.github.harrytechrevs.tutorialmod.init.TutorialItems;
import com.github.harrytechrevs.tutorialmod.init.TutorialToolMaterials;
import com.github.harrytechrevs.tutorialmod.items.CustomAxeItem;
import com.github.harrytechrevs.tutorialmod.items.CustomPickaxeItem;
import com.github.harrytechrevs.tutorialmod.world.biome.TutorialBiome;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TutorialModRegistries 
{
	public static final ItemGroup TUTORIAL = TutorialMod.TUTORIAL;
	public static final Logger LOGGER = TutorialMod.LOGGER;
	public static final String MODID = TutorialMod.MODID;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			TutorialItems.tutorial_item = new Item(new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_item")),
			
			TutorialItems.tutorial_axe = new CustomAxeItem(TutorialToolMaterials.tutorial, -1.0f, 6.0f, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_axe")),
			TutorialItems.tutorial_hoe = new HoeItem(TutorialToolMaterials.tutorial, 6.0f, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_hoe")),
			TutorialItems.tutorial_pickaxe = new CustomPickaxeItem(TutorialToolMaterials.tutorial, -2, 6.0f, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_pickaxe")),
			TutorialItems.tutorial_shovel = new ShovelItem(TutorialToolMaterials.tutorial, -3.0f, 6.0f, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_shovel")),
			TutorialItems.tutorial_sword = new SwordItem(TutorialToolMaterials.tutorial, 0, 6.0f, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_sword")),
			
			TutorialItems.tutorial_helmet = new ArmorItem(TutorialArmorMaterials.tutorial, EquipmentSlotType.HEAD, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_helmet")),
			TutorialItems.tutorial_chestplate = new ArmorItem(TutorialArmorMaterials.tutorial, EquipmentSlotType.CHEST, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_chestplate")),
			TutorialItems.tutorial_leggings = new ArmorItem(TutorialArmorMaterials.tutorial, EquipmentSlotType.LEGS, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_leggings")),
			TutorialItems.tutorial_boots = new ArmorItem(TutorialArmorMaterials.tutorial, EquipmentSlotType.FEET, new Item.Properties().group(TUTORIAL)).setRegistryName(location("tutorial_boots")),
			
			TutorialItems.tutorial_block = new BlockItem(TutorialBlocks.tutorial_block, new Item.Properties().group(TUTORIAL)).setRegistryName(TutorialBlocks.tutorial_block.getRegistryName()),
			TutorialItems.tutorial_ore = new BlockItem(TutorialBlocks.tutorial_ore, new Item.Properties().group(TUTORIAL)).setRegistryName(TutorialBlocks.tutorial_ore.getRegistryName()),
			TutorialItems.tutorial_ore_nether = new BlockItem(TutorialBlocks.tutorial_ore_nether, new Item.Properties().group(TUTORIAL)).setRegistryName(TutorialBlocks.tutorial_ore_nether.getRegistryName()),
			TutorialItems.tutorial_ore_end = new BlockItem(TutorialBlocks.tutorial_ore_end, new Item.Properties().group(TUTORIAL)).setRegistryName(TutorialBlocks.tutorial_ore_end.getRegistryName())

		);
		
		TutorialEntities.registerEntitySpawnEggs(event);
		
		LOGGER.info("Items registered.");
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
			TutorialBlocks.tutorial_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_block")),
			TutorialBlocks.tutorial_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore")),
			TutorialBlocks.tutorial_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore_nether")),
			TutorialBlocks.tutorial_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore_end"))
		);
		
		LOGGER.info("Blocks registered.");
	}
	
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		event.getRegistry().registerAll
		(
			TutorialEntities.tutorial_entity
		);
		
		TutorialEntities.registerEntityWorldSpawns();
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MODID, name);
	}
}	

































