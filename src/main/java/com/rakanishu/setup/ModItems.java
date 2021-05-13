package com.rakanishu.setup;

import com.rakanishu.configs.ItemNames;
import com.rakanishu.items.ItemCigarette;
import com.rakanishu.items.ItemStump;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    //food settings
    public static Food FOOD_SIMPLE_CIGARETTE = (new Food.Builder()).nutrition(1).saturationMod(0.7F).meat().alwaysEat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 1F).build();

    public static Food FOOD_JOINT_CIGARETTE = (new Food.Builder()).nutrition(1).saturationMod(0.7F).meat().alwaysEat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 1F)
            .effect(() -> new EffectInstance(Effects.WEAKNESS, 600, 0), 1F)
            .effect(() -> new EffectInstance(Effects.CONFUSION, 600, 0), 1F)
            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 600, 0), 1F)
            .build();

    public static Food FOOD_DONSKOY_TABAK_CIGARETTE = (new Food.Builder()).nutrition(1).saturationMod(0.7F).meat().alwaysEat()
            .effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 1F)
            .effect(() -> new EffectInstance(Effects.WEAKNESS, 600, 0), 1F)
            .effect(() -> new EffectInstance(Effects.LEVITATION, 600, 0), 1F)
            .build();

    //garbage
    public static final RegistryObject<Item> STUMP = Registration.ITEMS.register(ItemNames.STUMP,
            () -> new ItemStump(new Item.Properties().stacksTo(1).tab(ModTabs.SHIT_TAB))
    );
    //seeds
    public static final RegistryObject<BlockItem> TOBACCO_SEEDS = Registration.ITEMS.register(ItemNames.TOBACCO_SEEDS,
            () -> new BlockItem(ModBlocks.TOBACCO_CROP.get(), new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> CIGARETTE_SEEDS = Registration.ITEMS.register(ItemNames.CIGARETTE_SEEDS,
            () -> new Item(new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> WEED_BUMP = Registration.ITEMS.register(ItemNames.WEED_BUMP,
            () -> new BlockItem(ModBlocks.WEED_BUSH.get(), new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> DON_SEEDS = Registration.ITEMS.register(ItemNames.DON_SEEDS,
            () -> new Item(new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    //crops
    public static final RegistryObject<Item> TOBACCO_BUNDLE = Registration.ITEMS.register(ItemNames.TOBACCO_BUNDLE,
            () -> new Item(new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> CIGARETTE_BUNDLE = Registration.ITEMS.register(ItemNames.CIGARETTE_BUNDLE,
            () -> new Item(new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> DON_BUNDLE = Registration.ITEMS.register(ItemNames.DON_BUNDLE,
            () -> new Item(new Item.Properties().tab(ModTabs.SHIT_TAB))
    );
    //cigarettes
    public static final RegistryObject<Item> DONSKOY_TABAK_CIGARETTE = Registration.ITEMS.register(ItemNames.DONSKOY_TABAK_CIGARETTE,
            () -> new ItemCigarette(new Item.Properties().food(FOOD_DONSKOY_TABAK_CIGARETTE).stacksTo(20).tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> JOINT_CIGARETTE = Registration.ITEMS.register(ItemNames.JOINT_CIGARETTE,
            () -> new ItemCigarette(new Item.Properties().food(FOOD_JOINT_CIGARETTE).stacksTo(1).tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> BOND_WIHT_BUTTON_CIGARETTE = Registration.ITEMS.register(ItemNames.BOND_WIHT_BUTTON_CIGARETTE,
            () -> new ItemCigarette(new Item.Properties().food(FOOD_SIMPLE_CIGARETTE).stacksTo(20).tab(ModTabs.SHIT_TAB))
    );
    public static final RegistryObject<Item> GOLDEN_BEACH_CIGARETTE = Registration.ITEMS.register(ItemNames.GOLDEN_BEACH_CIGARETTE,
            () -> new ItemCigarette(new Item.Properties().food(FOOD_SIMPLE_CIGARETTE).stacksTo(20).tab(ModTabs.SHIT_TAB))
    );
    //records
    public static final RegistryObject<MusicDiscItem> RECORD_DAYDREAMS = Registration.ITEMS.register(ItemNames.RECORD_DAYDREAMS,
            () -> new MusicDiscItem(20, ModSoundEvents.RECORD_DAYDREAMS_WHISPER_OF_THE_STREETS,  new Item.Properties().tab(ModTabs.SHIT_TAB))
    );

    //call something to classload
    static void register() {}
}

