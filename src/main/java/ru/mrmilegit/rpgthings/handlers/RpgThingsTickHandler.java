package ru.mrmilegit.rpgthings.handlers;

import ru.mrmilegit.rpgthings.RpgThings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class RpgThingsTickHandler {

   boolean brk = false;
   boolean launched;
   boolean isServer;
   @SideOnly(Side.CLIENT)
   int idleTime;
   public static boolean keyPressed;


   public RpgThingsTickHandler(boolean server) {
      this.isServer =server;
   }
}
