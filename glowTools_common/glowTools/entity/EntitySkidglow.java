/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntitySkidglow extends EntityMob
{
	protected double speed = 1.15D;
	protected double health = 40.0D;
	protected double damage = 3.0D;
	protected double knockresist = 0.1D;
	
	public EntitySkidglow(World par1World)
	{
		super(par1World);
		//this.moveSpeed = 0.4F; --Something's changed here...
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, speed, false));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(3, new EntityAIWander(this, speed));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        experienceValue = 12;
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(health);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(speed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(damage);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(knockresist);
    }
	
	public int getTotalArmorValue()
	{
		return 7;
	}
	
	protected boolean isAIEnabled()
	{
		return true;
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
			this.dropItem(Item.glowstone.itemID, 1);
		}
		else
		{
			if(this.rand.nextInt(3) == 2)
			{
				this.dropItem(Item.glowstone.itemID, 2);
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
