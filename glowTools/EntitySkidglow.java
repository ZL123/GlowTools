package glowTools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntitySkidglow extends EntityMob
{

	public EntitySkidglow(World par1World)
	{
		super(par1World);
		this.texture = "/glowTools/textures/models/Skidglow.png";
		this.moveSpeed = 0.4F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 22.0F, 0, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	public int getTotalArmorValue()
	{
		return 7;
	}
	
	protected boolean isAIEnabled()
	{
		return true;
	}

	public int getMaxHealth()
	{
		return 30;
	}
	
	public int getAttackStrength(Entity par1Entity)
	{
		return 3;
	}
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	protected String getLivingSound()
	{
		return "mob.spider.say";
	}
	
	protected String getHurtSound()
	{
		return "mob.blaze.hit";
	}
	
	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		if(this.rand.nextInt(3) == 1)
		{
			this.dropItem(Item.lightStoneDust.itemID, 1);
		}
		else
		{
			if(this.rand.nextInt(3) == 2)
			{
				this.dropItem(Item.lightStoneDust.itemID, 2);
			}
		}
	}
	
	protected void dropRareDrop(int par1)
	{
		switch(this.rand.nextInt(3))
		{
		case 0:
			this.dropItem(Item.carrot.itemID, 1);
		case 1:
			this.dropItem(Item.potato.itemID, 1);
		case 2:
			this.dropItem(Item.diamond.itemID, this.rand.nextInt(2) + 1);
		}
	}
}
