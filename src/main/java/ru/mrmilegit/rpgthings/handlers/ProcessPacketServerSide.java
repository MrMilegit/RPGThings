package ru.mrmilegit.rpgthings.handlers;

import ru.mrmilegit.rpgthings.RpgThings;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayerMP;

public class ProcessPacketServerSide {

   public static void processPacketOnServer(FMLProxyPacket parBB, Side parSide, EntityPlayerMP parPlayer) throws IOException {
      if(parSide == Side.SERVER) {
         RpgThings.channel.sendToAll(parBB);
      }

   }
}
