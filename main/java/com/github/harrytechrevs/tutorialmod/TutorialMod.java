package com.github.harrytechrevs.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.harrytechrevs.tutorialmod.client.renders.TutorialRenderRegistry;
import com.github.harrytechrevs.tutorialmod.config.Config;
import com.github.harrytechrevs.tutorialmod.world.TutorialWorldType;
import com.github.harrytechrevs.tutorialmod.world.gen.OreGeneration;

import net.minecraft.item.ItemGroup;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("tutorialmod")
public class TutorialMod 
{
	public static TutorialMod instance;
	public static final String MODID = "tutorialmod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup TUTORIAL = new TutorialItemGroup();
	
	public TutorialMod() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "tutorialmod-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "tutorialmod-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("tutorialmod-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		TutorialRenderRegistry.registryEntityRenders();
		LOGGER.info("clientRegistries method registered.");
	}
}
