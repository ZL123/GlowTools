/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.recipe;

import glowTools.blocks.BlockGlowingRock;
import glowTools.blocks.BlockGlowingWood;
import glowTools.blocks.GTBlocks;
import glowTools.items.CraftingItems;
import glowTools.items.GTItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GsInfuserRecipes
{
    private static final GsInfuserRecipes infusingBase = new GsInfuserRecipes();

    private Map<Integer, ItemStack> infusingList = new HashMap<Integer, ItemStack>();
    private Map<Integer, Float> experienceList = new HashMap<Integer, Float>();
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
        this.addInfusing(Block.cobblestone.blockID, new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.cobbleMetaNumber), normalxp);
        this.addInfusing(Block.stone.blockID, new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.stoneMetaNumber), normalxp);
        this.addInfusing(Block.glass.blockID, new ItemStack(GTBlocks.blockGlowGlass), normalxp);
        this.addInfusing(Block.dirt.blockID, new ItemStack(GTBlocks.blockGlowDirt), normalxp);
        this.addInfusing(Block.sandStone.blockID, 0, new ItemStack(GTBlocks.blockGlowingRock, 1, BlockGlowingRock.sandStoneMetaNumber), normalxp);
        this.addInfusing(Item.ingotIron.itemID, new ItemStack(GTItems.craftingItems, 1, CraftingItems.glowingIronMetaNumber), normalxp);
        this.addInfusing(Block.blockIron.blockID, new ItemStack(GTBlocks.blockGlowIron), normalxp);
        this.addInfusing(Block.planks.blockID, 0, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankOakMetaNumber), normalxp);
        this.addInfusing(Block.planks.blockID, 1, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankSpruceMetaNumber), normalxp);
        this.addInfusing(Block.planks.blockID, 2, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankBirchMetaNumber), normalxp);
        this.addInfusing(Block.planks.blockID, 3, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.plankJungleMetaNumber), normalxp);
        this.addInfusing(Block.wood.blockID, 0, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logOakMetaNumber), normalxp);
        this.addInfusing(Block.wood.blockID, 1, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logSpruceMetaNumber), normalxp);
        this.addInfusing(Block.wood.blockID, 2, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logBirchMetaNumber), normalxp);
        this.addInfusing(Block.wood.blockID, 3, new ItemStack(GTBlocks.blockGlowingWood, 1, BlockGlowingWood.logJungleMetaNumber), normalxp);
    }

    public void addInfusing(int id, ItemStack stack, float xp)
    {
        this.infusingList.put(Integer.valueOf(id), stack);
        this.experienceList.put(Integer.valueOf(stack.itemID), Float.valueOf(xp));
    }
    
    public Map<Integer, ItemStack> getInfusingList()
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
        ItemStack ret = metaInfusingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return infusingList.get(Integer.valueOf(item.itemID));
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
            ret = experienceList.get(item.itemID).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaInfusingList()
    {
        return metaInfusingList;
    }
}