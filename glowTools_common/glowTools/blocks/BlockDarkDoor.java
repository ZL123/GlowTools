/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import glowTools.items.GTItems;

import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkDoor extends BlockDoor
{
    private static final String[] doorIconNames = new String[] {"glowTools:tile.doorDark_lower", "glowTools:tile.doorDark_upper"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    public BlockDarkDoor(int par1)
    {
        super(par1, Material.iron);
        this.setHardness(5.0F);
        this.setLightOpacity(15);
    }
    public Icon getIcon(int par1, int par2)
    {
        return this.iconArray[0];
    }
    
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 != 0 && par5 != 1)
        {
            int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && par5 == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return this.iconArray[0 + (flag1 ? doorIconNames.length : 0) + (flag2 ? 1 : 0)];
        }
        else
        {
            return this.iconArray[0];
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[doorIconNames.length * 2];

        for (int i = 0; i < doorIconNames.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(doorIconNames[i]);
            this.iconArray[i + doorIconNames.length] = new IconFlipped(this.iconArray[i], true, false);
        }
    }
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GTItems.itemDarkDoor.itemID;
    }
    
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return GTItems.itemDarkDoor.itemID;
    }
}
