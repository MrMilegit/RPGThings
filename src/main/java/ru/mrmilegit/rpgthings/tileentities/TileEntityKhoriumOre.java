package ru.mrmilegit.rpgthings.tileentities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityKhoriumOre extends TileEntity {

    public void updateEntity() {
        super.blockMetadata = super.worldObj.getBlockMetadata(super.xCoord, super.yCoord, super.zCoord);
        super.updateEntity();
    }
}
