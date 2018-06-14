package ru.mrmilegit.rpgthings.handlers;

import ru.mrmilegit.rpgthings.handlers.ProcessPacketClientSide;
import ru.mrmilegit.rpgthings.handlers.ServerPacketHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientPackageHandler extends ServerPacketHandler {

   public static ArrayList ups = new ArrayList();
   public static ArrayList downs = new ArrayList();
   public static ArrayList hasCoal = new ArrayList();
   public static HashMap clientIdleTimes = new HashMap();
   public static HashMap serverIdleTimes = new HashMap();


   @SubscribeEvent
   public void onClientPacket(ClientCustomPacketEvent event) throws IOException {
      super.channelName = event.packet.channel();
      if(super.channelName.equals("RpgthingsGeneral")) {
         System.out.println("Client received packet from server");
         ProcessPacketClientSide.processPacketOnClient(event.packet.payload(), event.packet.getTarget());
      }

   }

}
