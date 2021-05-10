package com.rakanishu.entities.render;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rakanishu.entities.EntityLexa;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ZombieModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelLexa<T extends Entity> extends PlayerModel<EntityLexa> {
    public ModelRenderer rightHand;
    public ModelRenderer rightLeg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftHand;
    public ModelRenderer leftLeg;
    public ModelRenderer soul;

    public ModelLexa(float p_i232336_1_) {
        super(p_i232336_1_, false);
        this.texWidth = 64;
        this.texHeight = 64;
        this.leftLeg = new ModelRenderer(this, 0, 16);
        this.leftLeg.mirror = true;
        this.leftLeg.setPos(1.9F, 12.0F, 0.1F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setPos(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.soul = new ModelRenderer(this, 32, 0);
        this.soul.setPos(0.0F, 0.0F, 0.0F);
        this.soul.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.rightHand = new ModelRenderer(this, 40, 16);
        this.rightHand.setPos(-5.0F, 2.0F, 0.0F);
        this.rightHand.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightHand, 0.0F, -0.10000736647217022F, 0.10000736647217022F);
        this.rightLeg = new ModelRenderer(this, 0, 16);
        this.rightLeg.setPos(-1.9F, 12.0F, 0.1F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setPos(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.leftHand = new ModelRenderer(this, 40, 16);
        this.leftHand.mirror = true;
        this.leftHand.setPos(5.0F, 2.0F, 0.0F);
        this.leftHand.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftHand, 0.0F, 0.10000736647217022F, -0.10000736647217022F);
    }



    @Override
    public void setupAnim(EntityLexa p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setupAnim(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        //this.leftLeg.xRot= MathHelper.cos(p_225597_2_* 0.6662f)*1.4f*p_225597_3_;
        float f3 = p_225597_4_ / 60.0F;
        this.leftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.rightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.leftHand.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.rightHand.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.head.x = MathHelper.sin(f3 * 10.0F);
        this.head.y = MathHelper.sin(f3 * 40.0F) + 0.4F;
       /* this.leg2.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + 3.1415927F) * 1.4F * p_225597_3_;
        this.leg3.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + 3.1415927F) * 1.4F * p_225597_3_;
        this.leg4.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;*/

    }


    //@Override
    /*public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing* 0.6662f)*1.4f*limbSwingAmount;
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing* 0.6662f + (float)Math.PI)*1.4f*limbSwingAmount;
        this.leftHand.rotateAngleX = MathHelper.cos(limbSwing* 0.6662f)*1.4f*limbSwingAmount;
        this.rightHand.rotateAngleX = MathHelper.cos(limbSwing* 0.6662f+ (float)Math.PI)*1.4f*limbSwingAmount;

        this.head.rotateAngleY = netHeadYaw *0.01745329f;
        this.head.rotateAngleX = netHeadYaw *0.01745329f;//headPitch
    }*/



    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.leftLeg, this.head, this.soul, this.rightHand, this.rightLeg, this.body, this.leftHand).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }
}
