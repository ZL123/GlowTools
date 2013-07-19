/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.inventory;

import glowTools.gui.GuiGsInfuser;
import glowTools.recipe.GsInfuserRecipes;
import glowTools.tileentity.TileEntityGsInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGsInfuser extends Container
{
    private TileEntityGsInfuser infuser;
    private GuiGsInfuser gui;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastGlowFuelAmount = 0;

    public ContainerGsInfuser(InventoryPlayer par1InventoryPlayer, TileEntityGsInfuser par2TileEntityGsInfuser)
    {
        this.infuser = par2TileEntityGsInfuser;
        this.addSlotToContainer(new Slot(par2TileEntityGsInfuser, 0, 59, 19));
        this.addSlotToContainer(new Slot(par2TileEntityGsInfuser, 1, 59, 55));
        this.addSlotToContainer(new SlotInfuser(par1InventoryPlayer.player, par2TileEntityGsInfuser, 2, 126, 37));
        this.addSlotToContainer(new Slot(par2TileEntityGsInfuser, 3, 35, 19));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.infuser.infuserCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.infuser.infuserBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.infuser.currentGlowFuelAmount);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.infuser.infuserCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.infuser.infuserCookTime);
            }

            if (this.lastBurnTime != this.infuser.infuserBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.infuser.infuserBurnTime);
            }

            if (this.lastItemBurnTime != this.infuser.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
            }
            
            if (this.lastGlowFuelAmount != this.infuser.currentGlowFuelAmount)
            {
            	icrafting.sendProgressBarUpdate(this, 3, this.infuser.currentGlowFuelAmount);
            }
            
        }
        
        this.lastCookTime = this.infuser.infuserCookTime;
        this.lastBurnTime = this.infuser.infuserBurnTime;
        this.lastItemBurnTime = this.infuser.currentItemBurnTime;
        this.lastGlowFuelAmount = this.infuser.currentGlowFuelAmount;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.infuser.infuserCookTime = par2;
        }

        if (par1 == 1)
        {
            this.infuser.infuserBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.infuser.currentItemBurnTime = par2;
        }
        
        if (par1 == 3)
        {
        	this.infuser.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.infuser.isUseableByPlayer(par1EntityPlayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 4, 40, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0 && par2 != 3)
            {
                if (GsInfuserRecipes.infusing().getInfusingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGsInfuser.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGsInfuser.isGlowFuel(itemstack1))
                {
                	if (!this.mergeItemStack(itemstack1, 3, 4, false))
                	{
                		return null;
                	}
                }
                else if (par2 >= 4 && par2 < 31)
                {
                    if (!this.mergeItemStack(itemstack1, 31, 40, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 31 && par2 < 40 && !this.mergeItemStack(itemstack1, 4, 31, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 4, 40, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}
