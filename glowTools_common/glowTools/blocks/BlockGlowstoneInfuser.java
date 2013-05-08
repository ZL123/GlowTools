/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import glowTools.GlowTools;
import glowTools.tileentity.TileEntityGsInfuser;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowstoneInfuser extends BlockContainer
{
    private final Random infuserRand = new Random();

    private final boolean isActive;

    @SideOnly(Side.CLIENT)
    private Icon infuserIconTop;
    @SideOnly(Side.CLIENT)
    private Icon infuserIconFront;

    protected BlockGlowstoneInfuser(int par1, boolean par2)
    {
        super(par1, Material.glass);
        this.isActive = par2;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GTBlocks.blockGlowstoneInfuser.blockID;
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
    	return par1 == 1 ? this.infuserIconTop : (par1 == 0 ? this.infuserIconTop : (par1 != par2 ? this.blockIcon : this.infuserIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("glowTools:tile.GlowstoneInfuser_sides");
        this.infuserIconFront = par1IconRegister.registerIcon(this.isActive ? "glowTools:tile.GlowstoneInfuser_front_active" : "glowTools:tile.GlowstoneInfuser_front");
        this.infuserIconTop = par1IconRegister.registerIcon("glowTools:tile.GlowstoneInfuser_sides");
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
        player.openGui(GlowTools.instance, 1, world, x, y, z);
        return true;
    }

    public static void updateInfuserBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, GTBlocks.blockGlowstoneInfuserActive.blockID);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, GTBlocks.blockGlowstoneInfuser.blockID);
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityGsInfuser();
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityGsInfuser)par1World.getBlockTileEntity(par2, par3, par4)).func_94129_a(par6ItemStack.getDisplayName());
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
            dropItems(world, x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
    }
    
    private void dropItems(World world, int x, int y, int z){
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack item = inventory.getStackInSlot(i);

                if (item != null && item.stackSize > 0) {
                        float rx = infuserRand.nextFloat() * 0.8F + 0.1F;
                        float ry = infuserRand.nextFloat() * 0.8F + 0.1F;
                        float rz = infuserRand.nextFloat() * 0.8F + 0.1F;

                        EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz,
                        new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                        float factor = 0.05F;
                        entityItem.motionX = infuserRand.nextGaussian() * factor;
                        entityItem.motionY = infuserRand.nextGaussian() * factor + 0.2F;
                        entityItem.motionZ = infuserRand.nextGaussian() * factor;
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                }
        }
}

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return GTBlocks.blockGlowstoneInfuser.blockID;
    }
}
