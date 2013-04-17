package glowTools.blocks;

import glowTools.GlowTools;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDarkDoor extends BlockDoor
{
    private static final String[] field_94467_a = new String[] {"glowTools:tile.doorDark_lower", "glowTools:tile.doorDark_upper"};
    private final int field_94465_b = 0;
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    public BlockDarkDoor(int par1)
    {
        super(par1, Material.iron);
        this.setHardness(5.0F);
        this.setLightOpacity(15);
    }
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return this.iconArray[this.field_94465_b];
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

            return this.iconArray[this.field_94465_b + (flag1 ? field_94467_a.length : 0) + (flag2 ? 1 : 0)];
        }
        else
        {
            return this.iconArray[this.field_94465_b];
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[field_94467_a.length * 2];

        for (int i = 0; i < field_94467_a.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(field_94467_a[i]);
            this.iconArray[i + field_94467_a.length] = new IconFlipped(this.iconArray[i], true, false);
        }
    }
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GlowTools.DarkDoorItem.itemID;
    }
    
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return GlowTools.DarkDoorItem.itemID;
    }
}
