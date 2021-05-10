package com.rakanishu.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTabs {

    public static final ItemGroup GUYS_TAB = new ItemGroup( "guys_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.LEXA_BLOCK.get());
        }
    };

    public static final ItemGroup SHIT_TAB = new ItemGroup("shit_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STUMP.get());
        }
    };

    //call something to classload
    static void register() {}
}
