package glowTools.items;

import glowTools.GlowTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class GlironArmor extends ItemArmor implements IArmorTextureProvider
{
	public GlironArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
	
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == GlowTools.GlironHelm.itemID ||itemstack.itemID == GlowTools.GlironChest.itemID ||itemstack.itemID == GlowTools.GlironBoots.itemID)
		{return "/mods/glowTools/textures/models/glowiron_1.png";}
		if(itemstack.itemID == GlowTools.GlironLegs.itemID)
		{return "/mods/glowTools/textures/models/glowiron_2.png";}
		else return "/glowTools/textures/models/glowiron_2.png";
	}
}