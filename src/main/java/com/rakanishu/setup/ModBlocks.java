package com.rakanishu.setup;

import com.rakanishu.blocks.BlockTobaccoCrop;
import com.rakanishu.blocks.BlockWeedBush;
import com.rakanishu.configs.BlockNames;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> LEXA_BLOCK = register(ModTabs.GUYS_TAB, BlockNames.LEXA_BLOCK, () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .jumpFactor(5)
                    .strength(3, 10)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> ARTIOM_BLOCK = register(ModTabs.GUYS_TAB, BlockNames.ARTIOM_BLOCK, () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .jumpFactor(5)
                    .strength(3, 10)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> OSINA_BLOCK = register(ModTabs.GUYS_TAB, BlockNames.OSINA_BLOCK, () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .jumpFactor(5)
                    .strength(3, 10)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOBACCO_CROP = register(ModTabs.GUYS_TAB, BlockNames.TOBACCO_CROP, () ->
            new BlockTobaccoCrop(AbstractBlock.Properties.of(Material.PLANT)
                    .lightLevel((lightLevel) -> 15)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)));

    public static final RegistryObject<Block> WEED_BUSH = register(ModTabs.GUYS_TAB, BlockNames.WEED_BUSH, () ->
            new BlockWeedBush(AbstractBlock.Properties.of(Material.PLANT)
                    .lightLevel((lightLevel) -> 15)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.SWEET_BERRY_BUSH)));

    private static <T extends Block>RegistryObject registerNoItem(String name, Supplier<T> block){
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject register(ItemGroup itemGroup, String name, Supplier<T> block){
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, ()-> new BlockItem(ret.get(), new Item.Properties().tab(itemGroup)));
        return ret;
    }

    //call something to classload
    static void register() {}
}
