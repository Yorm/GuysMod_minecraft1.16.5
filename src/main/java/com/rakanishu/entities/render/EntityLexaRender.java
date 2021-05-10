package com.rakanishu.entities.render;

import com.rakanishu.configs.Config;
import com.rakanishu.entities.EntityLexa;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityLexaRender extends MobRenderer<EntityLexa, ModelLexa<EntityLexa>> {

    private static final ResourceLocation LEXA_TEXTURES = new ResourceLocation(Config.MODID, "textures/entity/lexa.png");

    public EntityLexaRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelLexa<>(0.0F), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityLexa p_110775_1_) {
        return LEXA_TEXTURES;
    }

}