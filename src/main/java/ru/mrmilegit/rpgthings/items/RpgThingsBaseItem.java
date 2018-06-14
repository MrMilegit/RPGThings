package ru.mrmilegit.rpgthings.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class RpgThingsBaseItem extends Item {

   public RpgThingsBaseItem() {
      super.maxStackSize = 64;
   }

   public void registerIcons(IIconRegister par1IconRegister) {
      super.itemIcon = par1IconRegister.registerIcon("rpgthings:" + this.getUnlocalizedName().substring(5));
   }
}
