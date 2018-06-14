package ru.mrmilegit.rpgthings.handlers;

import ru.mrmilegit.rpgthings.handlers.ClientPackageHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.IOException;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProcessPacketClientSide {

   @SuppressWarnings("resource")
@SideOnly(Side.CLIENT)
   public static void processPacketOnClient(ByteBuf parBB, Side parSide) throws IOException {
      if(parSide == Side.CLIENT) {
         WorldClient theWorld = Minecraft.getMinecraft().theWorld;
         ByteBufInputStream bbis = new ByteBufInputStream(parBB);
         int packetTypeID = bbis.readInt();
         System.out.println("Received ProcessPacketClientSide on Client Side " + packetTypeID);
         switch(packetTypeID) {
         case 0:
            String action;
            String name;
            try {
               action = bbis.readUTF();
               name = bbis.readUTF();
            } catch (IOException var11) {
               var11.printStackTrace();
               return;
            }

            if(action.contains("up") && !ClientPackageHandler.ups.contains(name)) {
               ClientPackageHandler.ups.add(name);
            }

            if(action.contains("dup") && ClientPackageHandler.ups.contains(name)) {
               ClientPackageHandler.ups.remove(name);
            }

            if(action.contains("down") && !ClientPackageHandler.downs.contains(name)) {
               ClientPackageHandler.downs.add(name);
            }

            if(action.contains("ddown") && ClientPackageHandler.downs.contains(name)) {
               ClientPackageHandler.downs.remove(name);
            }

            if(action.contains("acoal") && !ClientPackageHandler.hasCoal.contains(name)) {
               ClientPackageHandler.hasCoal.add(name);
            }

            if(action.contains("rcoal") && ClientPackageHandler.hasCoal.contains(name)) {
               ClientPackageHandler.hasCoal.remove(name);
            }

            if(action.contains("idle")) {
               Side vtc1 = FMLCommonHandler.instance().getEffectiveSide();
               if(vtc1 != Side.SERVER && vtc1 == Side.CLIENT) {
                  ;
               }
            }
            break;
         case 1:
            int vtc;
            int par1;
            try {
               vtc = bbis.readInt();
               par1 = bbis.readInt();
            } catch (IOException var10) {
               var10.printStackTrace();
               return;
            }

            if(vtc == 99) {
               Minecraft.getMinecraft().thePlayer.inventory.setInventorySlotContents(par1, (ItemStack)null);
            }
         }

         bbis.close();
      }

   }

   public static Entity getEntityByID(int entityID, World world) {
      Iterator var2 = world.getLoadedEntityList().iterator();

      Object o;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         o = var2.next();
      } while(((Entity)o).getEntityId() != entityID);

      System.out.println("Found the entity");
      return (Entity)o;
   }
}
