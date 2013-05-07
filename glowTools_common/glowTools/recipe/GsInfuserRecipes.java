/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.recipe;

import glowTools.blocks.GTBlocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class GsInfuserRecipes
{
    private static final GsInfuserRecipes infusingBase = new GsInfuserRecipes();

    private Map infusingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaInfusingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();
    private float normalxp = 0.8F;
    
    public static final GsInfuserRecipes infusing()
    {
        return infusingBase;
    }

    private GsInfuserRecipes()
    {
        this.addInfusing(Block.sand.blockID, new ItemStack(GTBlocks.blockGlowSand), normalxp);
        this.addInfusing(Block.cobblestone.blockID, new ItemStack(GTBlocks.blockGlowCobble), normalxp);
        this.addInfusing(Block.stone.blockID, new ItemStack(GTBlocks.blockGlowingStone), normalxp);
        this.addInfusing(Block.glass.blockID, new ItemStack(GTBlocks.blockGlowGlass), normalxp);
        this.addInfusing(Block.dirt.blockID, new ItemStack(GTBlocks.blockGlowDirt), normalxp);
        this.addInfusing(Block.sandStone.blockID, 0, new ItemStack(GTBlocks.blockGlowSandstone, 1, 0), normalxp);
    }

    public void addInfusing(int id, ItemStack stack, float xp)
    {
        this.infusingList.put(Integer.valueOf(id), stack);
        this.experienceList.put(Integer.valueOf(stack.itemID), Float.valueOf(xp));
    }
    
    public Map getInfusingList()
    {
        return this.infusingList;
    }

    public void addInfusing(int id, int meta, ItemStack stack, float xp)
    {
        metaInfusingList.put(Arrays.asList(id, meta), stack);
        metaExperience.put(Arrays.asList(id, meta), xp);
    }

    public ItemStack getInfusingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaInfusingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)infusingList.get(Integer.valueOf(item.itemID));
    }

    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaInfusingList()
    {
        return metaInfusingList;
    }
}