package ru.mrmilegit.rpgthings.items.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RpgThingsGeneralRender implements IItemRenderer {

   private IModelCustom itemModel;
   private ResourceLocation itemTexture;


   public RpgThingsGeneralRender(IModelCustom model, ResourceLocation texture) {
      this.itemModel = model;
      this.itemTexture = texture;
   }

   public boolean handleRenderType(ItemStack item, ItemRenderType type) {
      return true;
   }

   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
      return true;
   }

   public void renderItem(ItemRenderType type, ItemStack item, Object ... data) {
      if(type != ItemRenderType.EQUIPPED && type != ItemRenderType.EQUIPPED_FIRST_PERSON) {
         if(type == ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(this.itemTexture);
            this.itemModel.renderAll();
            GL11.glPopMatrix();
         } else {
            Minecraft.getMinecraft().renderEngine.bindTexture(this.itemTexture);
            this.itemModel.renderAll();
         }
      } else {
         GL11.glPushMatrix();
         GL11.glScalef(0.5F, 0.5F, 0.5F);
         GL11.glTranslatef(1.5F, 1.0F, 1.0F);
         Minecraft.getMinecraft().renderEngine.bindTexture(this.itemTexture);
         this.itemModel.renderAll();
         GL11.glPopMatrix();
      }

   }
}
