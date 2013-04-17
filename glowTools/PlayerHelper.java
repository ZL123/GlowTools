package glowTools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlayerHelper {

    public static void giveItemToPlayer(EntityPlayer player, ItemStack item) {
        World world = player.worldObj;
        if (item == null || item.stackSize <= 0 || world.isRemote) return;
        Entity entity = new EntityItem(world, player.posX, player.posY + 0.5, player.posZ, item.copy());
        world.spawnEntityInWorld(entity);
    }
}
