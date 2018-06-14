package ru.mrmilegit.rpgthings;

import ru.mrmilegit.rpgthings.RpgThings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RpgThingsCreativeTab extends CreativeTabs {

   public static final CreativeTabs tabRpgthings = new RpgThingsCreativeTab("rpgmod");


   public RpgThingsCreativeTab(String label) {
      super(label);
   }

   public String getTranslatedTabLabel() {
      return "Rpg Things";
   }

   public Item getTabIconItem() {
      return Items.diamond;
   }

}
