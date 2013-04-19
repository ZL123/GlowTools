package glowTools;

import glowTools.blocks.BlockGlowstoneInfuser;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;

public class TileEntityGsInfuser extends TileEntity implements ISidedInventory, net.minecraftforge.common.ISidedInventory
{
    private static final int[] field_102010_d = new int[] {0};
    private static final int[] field_102011_e = new int[] {2, 1};
    private static final int[] field_102009_f = new int[] {1};

    private ItemStack[] infuserItemStacks = new ItemStack[3];

    public int infuserBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int infuserCookTime = 0;
    private String field_94130_e;

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
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.infuserItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.infuserItemStacks.length)
            {
                this.infuserItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
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

        par1NBTTagCompound.setTag("Items", nbttaglist);

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
            if (this.infuserBurnTime == 0 && this.canSmelt())
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

            if (this.isBurning() && this.canSmelt())
            {
                ++this.infuserCookTime;

                if (this.infuserCookTime == 200)
                {
                    this.infuserCookTime = 0;
                    this.smeltItem();
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
    
    private boolean canSmelt()
    {
        if (this.infuserItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = InfuserRecipes.infusing().getInfusingResult(this.infuserItemStacks[0]);
            if (itemstack == null) return false;
            if (this.infuserItemStacks[2] == null) return true;
            if (!this.infuserItemStacks[2].isItemEqual(itemstack)) return false;
            int result = infuserItemStacks[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = InfuserRecipes.infusing().getInfusingResult(this.infuserItemStacks[0]);

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

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
            {
                Block block = Block.blocksList[i];

                if (block == Block.woodSingleSlab)
                {
                    return 150;
                }

                if (block.blockMaterial == Material.wood)
                {
                    return 300;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).func_77842_f().equals("WOOD")) return 200;
            if (i == Item.stick.itemID) return 100;
            if (i == Item.coal.itemID) return 1600;
            if (i == Item.bucketLava.itemID) return 20000;
            if (i == Block.sapling.blockID) return 100;
            if (i == Item.blazeRod.itemID) return 2400;
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

    public int[] getSizeInventorySide(int par1)
    {
        return par1 == 0 ? field_102011_e : (par1 == 1 ? field_102010_d : field_102009_f);
    }

    public boolean func_102007_a(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isStackValidForSlot(par1, par2ItemStack);
    }

    public boolean func_102008_b(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
    }

    @Override
    public int getStartInventorySide(ForgeDirection side)
    {
        if (ForgeDummyContainer.legacyFurnaceSides)
        {
            if (side == ForgeDirection.DOWN) return 1;
            if (side == ForgeDirection.UP) return 0;
            return 2;
        }
        else
        {
            if (side == ForgeDirection.DOWN) return 2;
            if (side == ForgeDirection.UP) return 0;
            return 1;
        }
    }

    @Override
    public int getSizeInventorySide(ForgeDirection side)
    {
        return 1;
    }
}