package glowTools.items;

import glowTools.GlowTools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class glironpickItem extends ItemPickaxe
{

	public glironpickItem(int i, EnumToolMaterial enumToolMaterialGlowiron)
	{
		super(i, enumToolMaterialGlowiron);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
    	this.iconIndex = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}