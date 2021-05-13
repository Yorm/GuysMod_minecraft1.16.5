package com.rakanishu.setup;

import com.rakanishu.configs.Config;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Config.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRenderLayerSetup {
    @SubscribeEvent
    public static void setRenderLayers(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            //RenderTypeLookup.setRenderLayer(ModBlocks.TOBACCO_CROP.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.TOBACCO_CROP.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(ModBlocks.WEED_BUSH.get(), RenderType.translucent());
        });
    }
}
