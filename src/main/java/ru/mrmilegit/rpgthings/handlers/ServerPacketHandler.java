package ru.mrmilegit.rpgthings.handlers;

import ru.mrmilegit.rpgthings.handlers.ProcessPacketServerSide;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;

public class ServerPacketHandler {

   protected String channelName;
   protected EntityPlayerMP thePlayer;


   @SubscribeEvent
   public void onServerPacket(ServerCustomPacketEvent event) throws IOException {
      this.channelName = event.packet.channel();
      NetHandlerPlayServer theNetHandlerPlayServer = (NetHandlerPlayServer)event.handler;
      this.thePlayer = theNetHandlerPlayServer.playerEntity;
      if(this.channelName.equals("RpgthingsGeneral")) {
         System.out.println("Server received packet from player = " + this.thePlayer.getEntityId());
         ProcessPacketServerSide.processPacketOnServer(event.packet, event.packet.getTarget(), this.thePlayer);
      }

   }
}
