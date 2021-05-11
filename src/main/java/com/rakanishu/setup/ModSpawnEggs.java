package com.rakanishu.setup;

import com.rakanishu.configs.Config;
import com.rakanishu.configs.ItemNames;
import com.rakanishu.items.ItemModSpawnEgg;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ModSpawnEggs {

    private static final Set<RegistryObject<ItemModSpawnEgg>> SPAWN_EGGS = new HashSet<>();

    public static final RegistryObject<ItemModSpawnEgg> LEXA_SPAWN_EGG = registerSpawnEgg(ItemNames.LEXA_SPAWN_EGG,
            ModEntityTypes.ENTITY_LEXA, 3439278, 11895666
    );

    private static RegistryObject<ItemModSpawnEgg> registerSpawnEgg(
            final String name, final RegistryObject<? extends EntityType<?>> entityType,
            final int primaryColor, final int secondaryColor
    ) {
        final RegistryObject<ItemModSpawnEgg> spawnEgg = Registration.ITEMS.register(name,
                () -> new ItemModSpawnEgg(entityType, primaryColor, secondaryColor, new Item.Properties().tab(ModTabs.SHIT_TAB))
        );

        SPAWN_EGGS.add(spawnEgg);

        return spawnEgg;
    }

    public static Collection<? extends Supplier<ItemModSpawnEgg>> getSpawnEggs() {
        return Collections.unmodifiableCollection(SPAWN_EGGS);
    }

    @Mod.EventBusSubscriber(modid = Config.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EventHandler {
        @SubscribeEvent
        public static void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() ->
                    ItemModSpawnEgg.addEggsToEggsMap(getSpawnEggs())
            );
        }
    }

    //call something to classload
    static void register() {}

}
