package harry.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import harry.tutorialmod.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item tutorialItem = new ItemBase("tutorialItem", ItemGroup.MISC, 0);
}
