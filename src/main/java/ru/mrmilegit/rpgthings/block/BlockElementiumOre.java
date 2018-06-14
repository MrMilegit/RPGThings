package ru.mrmilegit.rpgthings.block;

import ru.mrmilegit.rpgthings.RpgThings;
import ru.mrmilegit.rpgthings.tileentities.TileEntityElementiumOre;
import ru.mrmilegit.rpgthings.tileentities.TileEntityEmeraldOre;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElementiumOre extends BlockContainer {

    public BlockElementiumOre() {
        super(Material.rock);
        this.setHardness(2F);
        this.setHarvestLevel("pickaxe", 1);
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return false;
    }

    public Block getBlockDropped(int meta, Random random, int fortune) {
        return Blocks.air;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l1 = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if(par6ItemStack.getItemDamage() == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l1, 1);
        } else {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l1 + 4, 1);
        }

    }

    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        return par1World.getBlock(par2, par3 - 1, par4) == Blocks.air?false:super.canBlockStay(par1World, par2, par3, par4);
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
        int id = par1World.getBlockMetadata(par2, par3, par4);
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
    }

    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        Block id = par1World.getBlock(par2, par3, par4);
        return id == Blocks.stone?true:super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityElementiumOre();
    }

}
