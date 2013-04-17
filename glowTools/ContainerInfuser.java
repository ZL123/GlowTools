package glowTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfuser extends Container
{
    private TileEntityGsInfuser infuser;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;
    private int lastGlowAmount = 0;

    public ContainerInfuser(InventoryPlayer par1InventoryPlayer, TileEntityGsInfuser par2TileEntityInfuser)
    {
        this.infuser = par2TileEntityInfuser;
        this.addSlotToContainer(new Slot(par2TileEntityInfuser, 0, 59, 17)); // Blocks
        this.addSlotToContainer(new Slot(par2TileEntityInfuser, 1, 35, 17)); // Glowing Fuel
        this.addSlotToContainer(new Slot(par2TileEntityInfuser, 2, 59, 53)); // Fuel
        this.addSlotToContainer(new SlotInfuser(par1InventoryPlayer.player, par2TileEntityInfuser, 3, 126, 35));
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
        par1ICrafting.sendProgressBarUpdate(this, 3, this.infuser.currentItemGlowAmount);
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
            
            if (this.lastGlowAmount != this.infuser.currentItemGlowAmount)
            {
            	icrafting.sendProgressBarUpdate(this, 3, this.infuser.currentItemGlowAmount);
            }
        }

        this.lastCookTime = this.infuser.infuserCookTime;
        this.lastBurnTime = this.infuser.infuserBurnTime;
        this.lastItemBurnTime = this.infuser.currentItemBurnTime;
        this.lastGlowAmount = this.infuser.currentItemGlowAmount;
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
        	this.infuser.currentItemGlowAmount = par2;
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
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
            	
                if (InfuserRecipes.infusing().getInfusingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGsInfuser.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 2, 3, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityGsInfuser.isGlowFuel(itemstack1))
                {
                	if (!this.mergeItemStack(itemstack1, 1, 2, false))
                	{
                		return null;
                	}
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 31 && par2 < 40 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 4, 39, false))
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
