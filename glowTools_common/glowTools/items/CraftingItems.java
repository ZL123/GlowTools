package glowTools.items;

import java.util.List;

import glowTools.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CraftingItems extends GlowItem {
	
	private static final String[] ITEM_NAMES = new String[] {"itemGlowIron", "itemRedIron", "itemGlowMolt", "itemRedMolt", "itemGlowRed", "itemScepterTip",
				"itemRedIronHandle", "gemCandentinium", "nuggetGlowIron", "nuggetRedIron", "itemCalcitePure", "itemCloakCore", "itemLightReflector",
				"itemInfernalCoal", "shardBlueGlass"};

	public static final int glowingIronMetaNumber = 0;
	public static final int redIronMetaNumber = 1;
	public static final int glowMoltMetaNumber = 2;
	public static final int redMoltMetaNumber = 3;
	public static final int blazeMoltMetaNumber = 4;
	public static final int scepterTipMetaNumber = 5;
	public static final int redIronHandleMetaNumber = 6;
	public static final int candentiniumMetaNumber = 7;
	public static final int nuggetGlowIronMetaNumber = 8;
	public static final int nuggetRedIronMetaNumber = 9;
	public static final int pureCalciteMetaNumber = 10;
	public static final int cloakCoreMetaNumber = 11;
	public static final int lightReflectorMetaNumber = 12;
	public static final int infernalCoalMetaNumber = 13;
	public static final int blueGlassShardMetaNumber = 14;
	
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
	
	public CraftingItems(int id) {
		super(id);
		this.setHasSubtypes(true);
		this.setCreativeTab(Reference.CREATIVETAB);
		maxStackSize = 64;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack itemStack) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, ITEM_NAMES.length - 1);
        return "item." + ITEM_NAMES[meta];
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[ITEM_NAMES.length];
		for (int i = 0; i < ITEM_NAMES.length; ++i) {
            icons[i] = iconRegister.registerIcon("glowTools:item." + ITEM_NAMES[i]);
        }
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, ITEM_NAMES.length - 1);
        return icons[j];
    }
	
	@Override
	public int getMetadata(int par1) {
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tabs, List par3List)
	{
		for(int i = 0; i < ITEM_NAMES.length; i++)
		{
			par3List.add(new ItemStack(id, 1, i));
		}
	}
	
}