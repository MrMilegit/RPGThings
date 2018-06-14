package ru.mrmilegit.rpgthings.tileentitiespecialRender;

import ru.mrmilegit.rpgthings.lib.PTTReference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderElementiumOre extends TileEntitySpecialRenderer {

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        int id = tileEntity.blockMetadata;
        int m;
        if(id >= 0 && id <= 3) {
            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            m = tileEntity.blockMetadata;
            this.bindTexture(PTTReference.TEXTURE_ELEMENTIUM);
            GL11.glTranslatef(0.5F, 0.0F, 0.5F);
            GL11.glScalef(0.4F, 0.4F, 0.4F);
            if(m == 2) {
                GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            } else if(m == 3) {
                GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
            } else if(m == 0) {
                GL11.glRotatef(-270.0F, 0.0F, 1.0F, 0.0F);
            }

            PTTReference.MODEL_ELEMENTIUM_SMALL.renderAll();
            this.bindTexture(PTTReference.TEXTURE_ELEMENTIUM_CRYSTAL);
            PTTReference.MODEL_ELEMENTIUM_SMALL_CRYSTAL.renderAll();
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            m = tileEntity.blockMetadata;
            this.bindTexture(PTTReference.TEXTURE_ELEMENTIUM);
            GL11.glTranslatef(0.5F, 0.0F, 0.5F);
            GL11.glScalef(0.4F, 0.4F, 0.4F);
            if(m == 6) {
                GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            } else if(m == 7) {
                GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
            } else if(m == 4) {
                GL11.glRotatef(-270.0F, 0.0F, 1.0F, 0.0F);
            }

            PTTReference.MODEL_ELEMENTIUM_BIG.renderAll();
            this.bindTexture(PTTReference.TEXTURE_ELEMENTIUM_CRYSTAL);
            PTTReference.MODEL_ELEMENTIUM_BIG_CRYSTAL.renderAll();
            GL11.glPopMatrix();
        }

    }
}
