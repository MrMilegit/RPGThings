package ru.mrmilegit.rpgthings.proxy;

import ru.mrmilegit.rpgthings.RpgThings;
import ru.mrmilegit.rpgthings.handlers.ServerPacketHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class RpgThingsCommonProxy implements IGuiHandler {

   public void Init() {
      RpgThings.channel.register(new ServerPacketHandler());
   }

   public void RegisterRenderers() {}

   public void registerTicks() {}

   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
      switch(ID) {
      case 0:
      default:
         return null;
      }
   }

   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
      return null;
   }
   
   

   public int getArmorNumber(String var1) {
      return 0;
   }
}
