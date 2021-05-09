package com.rakanishu.data;

import com.rakanishu.configs.Config;
import com.rakanishu.data.client.ModBlockStateProvider;
import com.rakanishu.data.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Config.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private  DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();

        gen.addProvider(new ModBlockStateProvider(gen, event.getExistingFileHelper()));
        gen.addProvider(new ModItemModelProvider(gen, event.getExistingFileHelper()));
    }
}
