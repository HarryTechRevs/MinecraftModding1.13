package harry.tutorialmod.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemAxe;

public class ItemCustomAxe extends ItemAxe
{
	public ItemCustomAxe(IItemTier tier, float attackDamage, float attackSpeedIn, Properties builder) 
	{
		super(tier, attackDamage, attackSpeedIn, builder);
	}
}
