package com.github.harrytechrevs.tutorialmod;

import com.github.harrytechrevs.tutorialmod.init.TutorialItems;

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
		return new ItemStack(TutorialItems.tutorial_item);
	}
}
