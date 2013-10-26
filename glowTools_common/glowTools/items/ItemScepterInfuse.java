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
import glowTools.blocks.BlockGlowingRock;
import glowTools.blocks.GTBlocks;
import glowTools.config.ConfigSettings;
import glowTools.tileentity.TileEntityGsInfuser;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScepterInfuse extends ItemTool {
	
	public static final Block[] effectiveAgainst = new Block[] {};
	
	public ItemScepterInfuse(int i, EnumToolMaterial par2EnumToolMaterial) {
		super(i, 0, par2EnumToolMaterial, effectiveAgainst);
		setMaxDamage(ConfigSettings.itemScepterInfuseDurability - 1);
		setCreativeTab(GlowTools.tabGlowTools);
		isDamageable();
		maxStackSize = 1;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitVecX, float hitVecY, float hitVecZ) {
		if (this.getDamage(stack) < this.getMaxDamage()) {
				int id = world.getBlockId(x, y, z);
				int meta = world.getBlockMetadata(x, y, z);
				
				if (id == Block.stone.blockID) {
					world.setBlock(x, y, z, GTBlocks.blockGlowingRock.blockID, BlockGlowingRock.stoneMetaNumber, 3);
					stack.damageItem(1, entityPlayer);
				}
				else if (id == Block.cobblestone.blockID) {
					world.setBlock(x, y, z, GTBlocks.blockGlowingRock.blockID, BlockGlowingRock.cobbleMetaNumber, 3);
					stack.damageItem(1, entityPlayer);
				}
				else if (id == Block.sandStone.blockID && meta == 0) {
					world.setBlock(x, y, z, GTBlocks.blockGlowingRock.blockID, BlockGlowingRock.sandStoneMetaNumber, 3);
					stack.damageItem(1, entityPlayer);
				}
				else if (id == Block.dirt.blockID) {
					world.setBlock(x, y, z, GTBlocks.blockGlowDirt.blockID);
					stack.damageItem(1, entityPlayer);
				}
				else if (id == Block.glass.blockID) {
					world.setBlock(x, y, z, GTBlocks.blockGlowGlass.blockID);
					stack.damageItem(1, entityPlayer);
				}
				else if (id == Block.sand.blockID) {
					world.setBlock(x, y, z, GTBlocks.blockGlowSand.blockID);
					stack.damageItem(1, entityPlayer);
				}
			}
			else if (entityPlayer.inventory != null) {
				for (int i = 0; i < entityPlayer.inventory.getSizeInventory(); i++) {
					ItemStack inSlot = entityPlayer.inventory.getStackInSlot(i);
					
					if (TileEntityGsInfuser.isGlowFuel(inSlot)) {
						this.setDamage(stack, getMaxDamage() - TileEntityGsInfuser.getItemGlowFuelAmount(inSlot));
						
						if (inSlot.stackSize > 1) {
							entityPlayer.inventory.setInventorySlotContents(i, new ItemStack(inSlot.itemID, inSlot.stackSize - 1, inSlot.getItemDamage()));
						}
						else if (inSlot.stackSize == 1) {
							entityPlayer.inventory.setInventorySlotContents(i, null);
						}
					}
				}
			}
		return true;
	}
	
	public boolean isFull3D()
    {
        return true;
    }
	
	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, net.minecraft.entity.EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            
        }
        return true;
    }	
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
        par3List.add("Glistens thine world to the");
        par3List.add("uttermost brightness.");
	}
	
	@Override
    public String getItemDisplayName(ItemStack stack) {
		return EnumChatFormatting.AQUA + super.getItemDisplayName(stack);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.itemIcon = par1IconRegister.registerIcon("glowTools:" + this.getUnlocalizedName());
    }
	
}