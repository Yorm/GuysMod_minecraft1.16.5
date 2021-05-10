package com.rakanishu.setup;

import com.rakanishu.configs.Config;
import com.rakanishu.entities.EntityLexa;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;


public class ModEntityTypes {

    public static final RegistryObject<EntityType<EntityLexa>> ENTITY_LEXA = registerEntityType("lexa",
            () -> EntityType.Builder.of((EntityLexa::new), EntityClassification.MISC)
                    .sized(1f, 2f)//width height
    );

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntityType(final String name, final Supplier<EntityType.Builder<T>> factory) {
        return Registration.ENTITIES.register(name,
                () -> factory.get().build(new ResourceLocation(Config.MODID, name).toString())
        );
    }


    @Mod.EventBusSubscriber(modid = Config.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerAttributes(final EntityAttributeCreationEvent event) {
            event.put(ENTITY_LEXA.get(), EntityLexa.createAttributes().build());
        }
    }

    //call something to classload
    static void register() {}
}
