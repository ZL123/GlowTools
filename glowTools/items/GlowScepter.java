package glowTools.items;

import glowTools.GlowTools;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class GlowScepter extends ItemSword
{
	public GlowScepter(int i, EnumToolMaterial par2EnumToolMaterial)
	{
		super(i, par2EnumToolMaterial);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	@SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if(this.itemID == GlowTools.OmniscepterItem.itemID)
        {
        	par3List.add("May you use thine precious");
        	par3List.add("staff bequeathen to thee");
        	par3List.add("as thine righteous guardian");
        	par3List.add("and protector to the fullness");
        	par3List.add("of all thine kingdom.");
        }
        else if(this.itemID == GlowTools.RegenscepterItem.itemID)
        {
        	par3List.add("Assists thee in thine");
        	par3List.add("beast-slaying duties.");
        }
        else if(this.itemID == GlowTools.Regenscepter2Item.itemID)
        {
        	par3List.add("Relieves thee of thine");
        	par3List.add("wounds of mortality.");
        }
    }
	
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}
