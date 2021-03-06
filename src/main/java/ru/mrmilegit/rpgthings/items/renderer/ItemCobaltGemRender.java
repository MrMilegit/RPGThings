package ru.mrmilegit.rpgthings.items.renderer;

import ru.mrmilegit.rpgthings.lib.PTTReference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class ItemCobaltGemRender implements IItemRenderer {

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return true;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return true;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object ... data) {
      if(type != ItemRenderType.EQUIPPED && type != ItemRenderType.EQUIPPED_FIRST_PERSON) {
         GL11.glPushMatrix();
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         GL11.glTranslatef(0.0F, -0.5F, 0.0F);
         if(item.getItemDamage() == 0) {
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALT);
            PTTReference.MODEL_COBALT.renderAll();
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALT_CRYSTAL);
            PTTReference.MODEL_COBALT_CRYSTAL.renderAll();
         } else {
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALTBIG);
            PTTReference.MODEL_STARMETAL_BIG.renderAll();
         }

         GL11.glPopMatrix();
      } else {
         GL11.glPushMatrix();
         GL11.glRotatef(90.0F, -1.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.7F, 1.0F);
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         if(item.getItemDamage() == 0) {
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALT);
            PTTReference.MODEL_COBALT.renderAll();
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALT_CRYSTAL);
            PTTReference.MODEL_COBALT_CRYSTAL.renderAll();
         } else {
            Minecraft.getMinecraft().renderEngine.bindTexture(PTTReference.TEXTURE_COBALTBIG);
            PTTReference.MODEL_STARMETAL_BIG.renderAll();
         }

         GL11.glPopMatrix();
      }

   }
}
