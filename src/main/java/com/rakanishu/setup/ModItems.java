package com.rakanishu.setup;

import com.rakanishu.configs.ItemNames;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

public class ModItems {
    public static final RegistryObject<Item> CIGARETTE_SEEDS = Registration.ITEMS.register(ItemNames.CIGARETTE_SEEDS, () ->
            new Item(new Item.Properties().tab(ModTabs.SHIT_TAB)));

    //call something to classload
    static void register() {}
}

