package harry.tutorialmod.items;

import harry.tutorialmod.ModConfig;
import harry.tutorialmod.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item 
{	
	public ItemBase(String name, ItemGroup creativeTab, int maxStackSize) 
	{
		super(new ItemProperties(maxStackSize, creativeTab));
		setRegistryName(new ResourceLocation(ModConfig.MODID, name));	
		ItemInit.ITEMS.add(this);
	}

	public static class ItemProperties extends Properties
	{
		public ItemProperties(int maxStackSize, ItemGroup creativeTab) 
		{
			maxStackSize(maxStackSize);
			group(creativeTab);
		}
	}
}