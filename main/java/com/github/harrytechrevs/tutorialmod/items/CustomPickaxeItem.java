package com.github.harrytechrevs.tutorialmod.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class CustomPickaxeItem extends PickaxeItem
{
	public CustomPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
}
