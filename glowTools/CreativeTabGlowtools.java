package glowTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabGlowtools extends CreativeTabs {

	public CreativeTabGlowtools(String label) {
		super(label);
	}
	
	public ItemStack getIconItemStack()
	{
		return new ItemStack(GlowTools.LightscepterItem);
	}

}
