package harry.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import harry.tutorialmod.items.ItemCustomAxe;
import harry.tutorialmod.items.ItemCustomPickaxe;
import harry.tutorialmod.lists.ArmourMaterialList;
import harry.tutorialmod.lists.BlockList;
import harry.tutorialmod.lists.ItemList;
import harry.tutorialmod.lists.ToolMaterialList;
import harry.tutorialmod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tutorialmod")
public class TutorialMod 
{
	public static TutorialMod instance;
	public static final String modid = "tutorialmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup tutorial = new TutorialItemGroup();
	
	public TutorialMod() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.tutorial_item = new Item(new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_item")),
				
				ItemList.tutorial_axe = new ItemCustomAxe(ToolMaterialList.tutorial, -1.0f, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_axe")),
				ItemList.tutorial_hoe = new ItemHoe(ToolMaterialList.tutorial, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_hoe")),
				ItemList.tutorial_pickaxe = new ItemCustomPickaxe(ToolMaterialList.tutorial, -2, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_pickaxe")),
				ItemList.tutorial_shovel = new ItemSpade(ToolMaterialList.tutorial, -3.0f, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_shovel")),
				ItemList.tutorial_sword = new ItemSword(ToolMaterialList.tutorial, 0, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_sword")),
				
				ItemList.tutorial_helmet = new ItemArmor(ArmourMaterialList.tutorial, EntityEquipmentSlot.HEAD, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_helmet")),
				ItemList.tutorial_chestplate = new ItemArmor(ArmourMaterialList.tutorial, EntityEquipmentSlot.CHEST, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_chestplate")),
				ItemList.tutorial_leggings = new ItemArmor(ArmourMaterialList.tutorial, EntityEquipmentSlot.LEGS, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_leggings")),
				ItemList.tutorial_boots = new ItemArmor(ArmourMaterialList.tutorial, EntityEquipmentSlot.FEET, new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_boots")),
				
				ItemList.tutorial_block = new ItemBlock(BlockList.tutorial_block, new Item.Properties().group(tutorial)).setRegistryName(BlockList.tutorial_block.getRegistryName()),
				ItemList.tutorial_ore = new ItemBlock(BlockList.tutorial_ore, new Item.Properties().group(tutorial)).setRegistryName(BlockList.tutorial_ore.getRegistryName()),
				ItemList.tutorial_ore_nether = new ItemBlock(BlockList.tutorial_ore_nether, new Item.Properties().group(tutorial)).setRegistryName(BlockList.tutorial_ore_nether.getRegistryName()),
				ItemList.tutorial_ore_end = new ItemBlock(BlockList.tutorial_ore_end, new Item.Properties().group(tutorial)).setRegistryName(BlockList.tutorial_ore_end.getRegistryName())

			);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.tutorial_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_block")),
				BlockList.tutorial_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore")),
				BlockList.tutorial_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore_nether")),
				BlockList.tutorial_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL)).setRegistryName(location("tutorial_ore_end"))
			);
			
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}	
}
