package glowTools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes
{
    private static final InfuserRecipes infusingBase = new InfuserRecipes();

    private Map infusingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaInfusingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final InfuserRecipes infusing()
    {
        return infusingBase;
    }

    private InfuserRecipes()
    {
        this.addInfusing(new ItemStack(Block.sand), new ItemStack(GlowTools.glowsandBlock), 0.9F);
        this.addInfusing(new ItemStack(Block.cobblestone), new ItemStack(GlowTools.GlowCobbleBlock), 0.9F);
        this.addInfusing(new ItemStack(Block.stone), new ItemStack(GlowTools.GlowingStoneBlock), 0.9F);
        this.addInfusing(new ItemStack(Block.glass), new ItemStack(GlowTools.GlowglassBlock), 0.9F);
        this.addInfusing(new ItemStack(Block.dirt), new ItemStack(GlowTools.GlowDirtBlock), 0.9F);
        this.addInfusing(new ItemStack(Block.sandStone, 1, 0), new ItemStack(GlowTools.GlowSandStoneBlock), 0.9F);
    }

    public void addInfusing(ItemStack par1ItemStack, ItemStack par2ItemStack, float par3)
    {
        this.infusingList.put(par1ItemStack, par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }
    
    public Map getInfusingList()
    {
        return this.infusingList;
    }

    public void addInfusing(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaInfusingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
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