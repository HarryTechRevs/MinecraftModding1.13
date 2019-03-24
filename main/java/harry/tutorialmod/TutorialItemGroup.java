package harry.tutorialmod;

import harry.tutorialmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TutorialItemGroup extends ItemGroup
{
	public TutorialItemGroup() 
	{
		super("tutorial");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.tutorial_item);
	}
}
