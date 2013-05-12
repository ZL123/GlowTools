/**
 * Copyright (c) ZL123 2013
 * 
 * GlowTools is made available under the terms of the Lesser GNU Public License v3.
 * (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @author ZL123
 */

package glowTools.blocks;

import glowTools.GlowTools;
import glowTools.lib.Reference;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowingRock extends Block {

	@SideOnly(Side.CLIENT)
	private Icon iconSandStone_side;
	@SideOnly(Side.CLIENT)
	private Icon iconSandStone_top;
	@SideOnly(Side.CLIENT)
	private Icon iconSandStone_bottom;
	@SideOnly(Side.CLIENT)
	private Icon iconCobble;
	@SideOnly(Side.CLIENT)
	private Icon iconStone;
	
	public static final int sandStoneMetaNumber = 0;
	public static final int cobbleMetaNumber = 1;
	public static final int stoneMetaNumber = 2;
	
	public static final String[] BLOCK_NAMES = {"Glowing Sandstone", "Glowing Cobblestone", "Glowing Stone"};
	
	public BlockGlowingRock(int id) {
		super(id, Material.rock);
		setCreativeTab(Reference.CREATIVETAB);
		setLightValue(1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch(meta)
		{
		case sandStoneMetaNumber: return side == 1 ? iconSandStone_top : (side == 0 ? iconSandStone_bottom : iconSandStone_side);
		case cobbleMetaNumber: return iconCobble;
		case stoneMetaNumber: return iconStone;
		default: return iconStone;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		iconSandStone_side = par1IconRegister.registerIcon("sandstone_side");
		iconSandStone_top = par1IconRegister.registerIcon("sandstone_top");
		iconSandStone_bottom = par1IconRegister.registerIcon("sandstone_bottom");
		iconCobble = par1IconRegister.registerIcon("stonebrick");
		iconStone = par1IconRegister.registerIcon("stone");
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tabs, List par3List)
	{
		for(int i = 0; i < BLOCK_NAMES.length; i++)
		{
			par3List.add(new ItemStack(id, 1, i));
		}
	}
	
	
}