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
import glowTools.TileEntityGsInfuser;

import java.util.Random;

import api.EnumTag;
import api.IAspectSource;
import api.ObjectTags;

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
import net.minecraft.nbt.NBTTagCompound;
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
	
    private static boolean keepInfuserInventory = false;
    @SideOnly(Side.CLIENT)
    private Icon field_94458_cO;
    @SideOnly(Side.CLIENT)
    private Icon field_94459_cP;
	
	public BlockGlowstoneInfuser(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.setHardness(3.0F);
		this.setResistance(15.0F);
		this.setStepSound(soundGlassFootstep);
		this.setLightValue(0.75F);
		this.isActive = par2;
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return GTBlocks.GlowstoneInfuser.blockID;
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
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? this.field_94458_cO : (par1 == 0 ? this.field_94458_cO : (par1 != par2 ? this.blockIcon : this.field_94459_cP));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("glowTools:tile.GlowstoneInfuser_sides");
        this.field_94459_cP = par1IconRegister.registerIcon(this.isActive ? "glowTools:tile.GlowstoneInfuser_front_active" : "glowTools:tile.GlowstoneInfuser_front");
        this.field_94458_cO = par1IconRegister.registerIcon("glowTools:tile.GlowstoneInfuser_sides");
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityGsInfuser tileentitygsinfuser = (TileEntityGsInfuser)par1World.getBlockTileEntity(par2, par3, par4);

            if (tileentitygsinfuser != null)
            {
                par5EntityPlayer.openGui(GlowTools.instance, 1, par1World, par2, par3, par4);
            }
            
            return true;
        }
    }
    
    public static void updateInfuserBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
        keepInfuserInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, GTBlocks.GlowstoneInfuserActive.blockID);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, GTBlocks.GlowstoneInfuser.blockID);
        }

        keepInfuserInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }
    public TileEntity getBlockEntity()
    {
    	return new TileEntityGsInfuser();
    }
    
	@Override
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
	
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepInfuserInventory)
        {
            TileEntityGsInfuser tileentitygsinfuser = (TileEntityGsInfuser) par1World.getBlockTileEntity(par2, par3, par4);

            if (tileentitygsinfuser != null)
            {
                for (int j1 = 0; j1 < tileentitygsinfuser.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentitygsinfuser.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.infuserRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.infuserRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.infuserRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.infuserRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.infuserRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.infuserRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.infuserRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }
            }
        }
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
	public boolean func_96468_q_()
    {
        return true;
    }
	
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
    }
}
