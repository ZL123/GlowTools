/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
*/ 

package glowTools.tileentity;

import glowTools.blocks.BlockGlowstoneInfuser;
import glowTools.items.GTItems;
import glowTools.recipe.GsInfuserRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityGsInfuser extends TileEntity implements ISidedInventory
{
    private static final int[] field_102010_d = new int[] {0, 3};
    private static final int[] field_102011_e = new int[] {2};
    private static final int[] field_102009_f = new int[] {1};

    private ItemStack[] infuserItemStacks = new ItemStack[4];

    public int infuserBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int infuserCookTime = 0;
    private String field_94130_e = "Glowstone Infuser";

    public int getSizeInventory()
    {
        return this.infuserItemStacks.length;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.infuserItemStacks[par1];
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.infuserItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.infuserItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.infuserItemStacks[par1];
                this.infuserItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.infuserItemStacks[par1].splitStack(par2);

                if (this.infuserItemStacks[par1].stackSize == 0)
                {
                    this.infuserItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.infuserItemStacks[par1] != null)
        {
            ItemStack itemstack = this.infuserItemStacks[par1];
            this.infuserItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.infuserItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return this.isInvNameLocalized() ? this.field_94130_e : "container.infuser";
    }

    public boolean isInvNameLocalized()
    {
        return this.field_94130_e != null && this.field_94130_e.length() > 0;
    }

    public void func_94129_a(String par1Str)
    {
        this.field_94130_e = par1Str;
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Inventory");
        this.infuserItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte slot = nbttagcompound1.getByte("Slot");

            if (slot >= 0 && slot < this.infuserItemStacks.length)
            {
                this.infuserItemStacks[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.infuserBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.infuserCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.infuserItemStacks[1]);

        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.field_94130_e = par1NBTTagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.infuserBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.infuserCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.infuserItemStacks.length; ++i)
        {
            if (this.infuserItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.infuserItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Inventory", nbttaglist);

        if (this.isInvNameLocalized())
        {
            par1NBTTagCompound.setString("CustomName", this.field_94130_e);
        }
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.infuserCookTime * par1 / 200;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.infuserBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.infuserBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.infuserBurnTime > 0;
        boolean flag1 = false;

        if (this.infuserBurnTime > 0)
        {
            --this.infuserBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.infuserBurnTime == 0 && this.canInfuse())
            {
                this.currentItemBurnTime = this.infuserBurnTime = getItemBurnTime(this.infuserItemStacks[1]);

                if (this.infuserBurnTime > 0)
                {
                    flag1 = true;

                    if (this.infuserItemStacks[1] != null)
                    {
                        --this.infuserItemStacks[1].stackSize;

                        if (this.infuserItemStacks[1].stackSize == 0)
                        {
                            this.infuserItemStacks[1] = this.infuserItemStacks[1].getItem().getContainerItemStack(infuserItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canInfuse())
            {
                ++this.infuserCookTime;

                if (this.infuserCookTime == 200)
                {
                    this.infuserCookTime = 0;
                    this.infuseItem();
                    flag1 = true;
                }
            }
            else
            {
                this.infuserCookTime = 0;
            }

            if (flag != this.infuserBurnTime > 0)
            {
                flag1 = true;
                BlockGlowstoneInfuser.updateInfuserBlockState(this.infuserBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.onInventoryChanged();
        }
    }

    private boolean canInfuse()
    {
        if (this.infuserItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = GsInfuserRecipes.infusing().getInfusingResult(this.infuserItemStacks[0]);
            if (itemstack == null) return false;
            if (this.infuserItemStacks[2] == null) return true;
            if (!this.infuserItemStacks[2].isItemEqual(itemstack)) return false;
            int result = infuserItemStacks[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public void infuseItem()
    {
        if (this.canInfuse())
        {
            ItemStack itemstack = GsInfuserRecipes.infusing().getInfusingResult(this.infuserItemStacks[0]);

            if (this.infuserItemStacks[2] == null)
            {
                this.infuserItemStacks[2] = itemstack.copy();
            }
            else if (this.infuserItemStacks[2].isItemEqual(itemstack))
            {
                infuserItemStacks[2].stackSize += itemstack.stackSize;
            }

            --this.infuserItemStacks[0].stackSize;

            if (this.infuserItemStacks[0].stackSize <= 0)
            {
                this.infuserItemStacks[0] = null;
            }
        }
    }

    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            int i = par0ItemStack.getItem().itemID;
            Item item = par0ItemStack.getItem();
            
            if (i == GTItems.InfernalCoalItem.itemID) return 2000;
            if (i == Item.netherStar.itemID) return 300000;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }

    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
    }
    
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? field_102011_e : (par1 == 1 ? field_102010_d : field_102009_f);
    }

    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isStackValidForSlot(par1, par2ItemStack);
    }

    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
    }
    
    static {
    	addMapping(TileEntityGsInfuser.class, "Glowstone Infuser");
    }
}
