package com.clausgames.crystalmagic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrystalOre extends ModelBase
{
        ModelRenderer Box_1;
        ModelRenderer Box_3;
        ModelRenderer Box_4;
        ModelRenderer Box_5;
        ModelRenderer Box_6;
        ModelRenderer Box_7;
        ModelRenderer Box_8;
        ModelRenderer Box_9;
        ModelRenderer Box_10;
        ModelRenderer Box_11;
        ModelRenderer Box_12;
        ModelRenderer Box_13;
        ModelRenderer Box_14;

        public ModelCrystalOre()
        {
            textureWidth = 64;
            textureHeight = 64;

            Box_1 = new ModelRenderer(this, 1, 1);
            Box_1.addBox(-2F, -13F, -2F, 4, 13, 4);
            Box_1.setRotationPoint(0F, 24F, 0F);
            Box_1.setTextureSize(64, 32);
            Box_1.mirror = true;
            setRotation(Box_1, 0F, 0.2094395F, 0F);
            Box_3 = new ModelRenderer(this, 25, 1);
            Box_3.addBox(-2F, -10F, -2F, 4, 9, 4);
            Box_3.setRotationPoint(0F, 24F, 0F);
            Box_3.setTextureSize(64, 32);
            Box_3.mirror = true;
            setRotation(Box_3, 0.1745329F, 0F, 0.6108652F);
            Box_4 = new ModelRenderer(this, 17, 17);
            Box_4.addBox(-2F, -10F, -2F, 4, 9, 4);
            Box_4.setRotationPoint(0F, 24F, 0F);
            Box_4.setTextureSize(64, 32);
            Box_4.mirror = true;
            setRotation(Box_4, 0F, 0F, -0.6108652F);
            Box_5 = new ModelRenderer(this, 41, 17);
            Box_5.addBox(-2F, -10F, -2F, 4, 9, 4);
            Box_5.setRotationPoint(0F, 24F, 0F);
            Box_5.setTextureSize(64, 32);
            Box_5.mirror = true;
            setRotation(Box_5, 0.0698132F, 1.675516F, -0.6806784F);
            Box_6 = new ModelRenderer(this, 1, 33);
            Box_6.addBox(-2F, -10F, -2F, 4, 9, 4);
            Box_6.setRotationPoint(0F, 24F, 0F);
            Box_6.setTextureSize(64, 32);
            Box_6.mirror = true;
            setRotation(Box_6, 0F, -1.570796F, -0.6108652F);
            Box_7 = new ModelRenderer(this, 49, 1);
            Box_7.addBox(-1.5F, -12F, -1.5F, 3, 7, 3);
            Box_7.setRotationPoint(0F, 24F, 0F);
            Box_7.setTextureSize(64, 32);
            Box_7.mirror = true;
            setRotation(Box_7, 0.1919862F, 0F, 0.5061455F);
            Box_8 = new ModelRenderer(this, 25, 33);
            Box_8.addBox(-1.5F, -12F, -1.5F, 3, 9, 3);
            Box_8.setRotationPoint(0F, 24F, 0F);
            Box_8.setTextureSize(64, 32);
            Box_8.mirror = true;
            setRotation(Box_8, 0F, 1.727876F, 0.5759587F);
            Box_9 = new ModelRenderer(this, 41, 33);
            Box_9.addBox(-1.5F, -11F, -1.5F, 3, 6, 3);
            Box_9.setRotationPoint(0F, 24F, 0F);
            Box_9.setTextureSize(64, 32);
            Box_9.mirror = true;
            setRotation(Box_9, 0F, -1.570796F, 0.6632251F);
            Box_10 = new ModelRenderer(this, 1, 49);
            Box_10.addBox(-1.5F, -12F, -1.5F, 3, 7, 3);
            Box_10.setRotationPoint(0F, 24F, 0F);
            Box_10.setTextureSize(64, 32);
            Box_10.mirror = true;
            setRotation(Box_10, -0.0872665F, 3.141593F, 0.5759587F);
            Box_11 = new ModelRenderer(this, 1, 25);
            Box_11.addBox(-1.5F, -15F, -1.5F, 3, 2, 3);
            Box_11.setRotationPoint(0F, 24F, 0F);
            Box_11.setTextureSize(64, 32);
            Box_11.mirror = true;
            setRotation(Box_11, 0F, 0F, 0F);
            Box_12 = new ModelRenderer(this, 25, 1);
            Box_12.addBox(-2F, -10F, -2F, 3, 9, 4);
            Box_12.setRotationPoint(0F, 24F, 0F);
            Box_12.setTextureSize(64, 32);
            Box_12.mirror = true;
            setRotation(Box_12, 0.2094395F, -0.8203047F, 0.8552113F);
            Box_13 = new ModelRenderer(this, 1, 25);
            Box_13.addBox(-1.5F, -6F, -1.5F, 3, 2, 3);
            Box_13.setRotationPoint(0F, 24F, 0F);
            Box_13.setTextureSize(64, 32);
            Box_13.mirror = true;
            setRotation(Box_13, 0.0698132F, -0.715585F, -0.6632251F);
            Box_14 = new ModelRenderer(this, 25, 33);
            Box_14.addBox(-1.5F, -9F, -1.5F, 3, 9, 3);
            Box_14.setRotationPoint(0F, 24F, 0F);
            Box_14.setTextureSize(64, 32);
            Box_14.mirror = true;
            setRotation(Box_14, 0F, 1.989675F, 0.837758F);
        }

        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
        {
            super.render(entity, f, f1, f2, f3, f4, f5);
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            Box_1.render(f5);
            Box_3.render(f5);
            Box_4.render(f5);
            Box_5.render(f5);
            Box_6.render(f5);
            Box_7.render(f5);
            Box_8.render(f5);
            Box_9.render(f5);
            Box_10.render(f5);
            Box_11.render(f5);
            Box_12.render(f5);
            Box_13.render(f5);
            Box_14.render(f5);
        }

        public void renderModel(float f)
        {
            Box_1.render(f);
            Box_3.render(f);
            Box_4.render(f);
            Box_5.render(f);
            Box_6.render(f);
            Box_7.render(f);
            Box_8.render(f);
            Box_9.render(f);
            Box_10.render(f);
            Box_11.render(f);
            Box_12.render(f);
            Box_13.render(f);
            Box_14.render(f);
        }

        private void setRotation(ModelRenderer model, float x, float y, float z)
        {
            model.rotateAngleX = x;
            model.rotateAngleY = y;
            model.rotateAngleZ = z;
        }

        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
        {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        }
}
