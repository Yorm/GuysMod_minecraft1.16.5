package com.rakanishu.setup;

import com.rakanishu.configs.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rakanishu.configs.SoundEventNames.DAYDREAMS_WHISPER_OF_THE_STREETS;
import static com.rakanishu.configs.SoundEventNames.LEXA_AMBIENT;

public class ModSoundEvents {


    public static final RegistryObject<SoundEvent> ENTITY_LEXA_AMBIENT = Registration.SOUND_EVENTS.register(LEXA_AMBIENT, () -> new SoundEvent(new ResourceLocation(Config.MODID, LEXA_AMBIENT)));
    public static final RegistryObject<SoundEvent> RECORD_DAYDREAMS_WHISPER_OF_THE_STREETS = Registration.SOUND_EVENTS.register(DAYDREAMS_WHISPER_OF_THE_STREETS, () -> new SoundEvent(new ResourceLocation(Config.MODID, DAYDREAMS_WHISPER_OF_THE_STREETS)));

    //call something to classload
    static void register() {}
}
