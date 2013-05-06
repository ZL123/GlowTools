/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.items;

import glowTools.GlowTools;
import glowTools.blocks.GTBlocks;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LightscepterItem extends GlowScepter
{
	public LightscepterItem(int i, EnumToolMaterial par2EnumToolMaterial)
	{
		super(i, par2EnumToolMaterial);
		this.setCreativeTab(GlowTools.tabGlowTools);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if (par7 == 0 || var12 != 0 || var11 != GTBlocks.CandentiniumBlock.blockID)
            {
                return false;
            }
            else
            {
                giveItemToPlayer(par2EntityPlayer, new ItemStack(GTItems.LightscepterItem));
                par3World.setBlockToAir(par4, par5, par6);
                return true;
            }
        }
	}
	
    public static void giveItemToPlayer(EntityPlayer player, ItemStack item) {
        World world = player.worldObj;
        if (item == null || item.stackSize <= 0 || world.isRemote) return;
        Entity entity = new EntityItem(world, player.posX, player.posY + 0.5, player.posZ, item.copy());
        world.spawnEntityInWorld(entity);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("Brings forth the light");
        par3List.add("so it shall shine upon thee.");
    }
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
}