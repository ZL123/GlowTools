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

public class BlockGlowingWood extends Block {

	@SideOnly(Side.CLIENT)
	private Icon iconPlankOak;
	@SideOnly(Side.CLIENT)
	private Icon iconPlankBirch;
	@SideOnly(Side.CLIENT)
	private Icon iconPlankSpruce;
	@SideOnly(Side.CLIENT)
	private Icon iconPlankJungle;
	@SideOnly(Side.CLIENT)
	private Icon iconLog_top;
	@SideOnly(Side.CLIENT)
	private Icon iconLogOak;
	@SideOnly(Side.CLIENT)
	private Icon iconLogBirch;
	@SideOnly(Side.CLIENT)
	private Icon iconLogSpruce;
	@SideOnly(Side.CLIENT)
	private Icon iconLogJungle;
	
	public static final int plankOakMetaNumber = 0;
	public static final int plankSpruceMetaNumber = 2;
	public static final int plankBirchMetaNumber = 4;
	public static final int plankJungleMetaNumber = 6;
	public static final int logOakMetaNumber = 1;
	public static final int logSpruceMetaNumber = 3;
	public static final int logBirchMetaNumber = 5;
	public static final int logJungleMetaNumber = 7;
	
	public static final String[] BLOCK_NAMES = {"Glowing Oak Wood Planks", "Glowing Oak Wood", "Glowing Spruce Wood Planks",
		"Glowing Spruce Wood", "Glowing Birch Wood Planks", "Glowing Birch Wood", "Glowing Jungle Wood Planks", "Glowing Jungle Wood"};
	
	public BlockGlowingWood(int id) {
		super(id, Material.wood);
		setCreativeTab(Reference.CREATIVETAB);
		setLightValue(1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch(meta)
		{
		case plankOakMetaNumber: return iconPlankOak;
		case plankSpruceMetaNumber: return iconPlankSpruce;
		case plankBirchMetaNumber: return iconPlankBirch;
		case plankJungleMetaNumber: return iconPlankJungle;
		case logOakMetaNumber: return (side == 0 || side == 1) ? iconLog_top : iconLogOak;
		case logSpruceMetaNumber: return (side == 0 || side == 1) ? iconLog_top : iconLogSpruce;
		case logBirchMetaNumber: return (side == 0 || side == 1) ? iconLog_top : iconLogBirch;
		case logJungleMetaNumber: return (side == 0 || side == 1) ? iconLog_top : iconLogJungle;
		default: return iconPlankOak;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		iconPlankOak = register.registerIcon("wood");
		iconPlankBirch = register.registerIcon("wood_birch");
		iconPlankSpruce = register.registerIcon("wood_spruce");
		iconPlankJungle = register.registerIcon("wood_jungle");
		iconLog_top = register.registerIcon("tree_top");
		iconLogOak = register.registerIcon("tree_side");
		iconLogBirch = register.registerIcon("tree_birch");
		iconLogSpruce = register.registerIcon("tree_spruce");
		iconLogJungle = register.registerIcon("tree_jungle");
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