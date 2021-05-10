package com.rakanishu.setup;


import com.rakanishu.configs.Config;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> BLOCK_LEXA = forge("guys/lexa");
        public static final ITag.INamedTag<Block> BLOCK_ARTIOM = forge("guys/artiom");
        public static final ITag.INamedTag<Block> BLOCK_OSINA = forge("guys/osina");
        public static final ITag.INamedTag<Block> STORAGE_BLOCK_LEXA = forge("storage_blocks/lexa");
        public static final ITag.INamedTag<Block> STORAGE_BLOCK_ARTIOM = forge("storage_blocks/artiom");
        public static final ITag.INamedTag<Block> STORAGE_BLOCK_OSINA = forge("storage_blocks/osina");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Config.MODID, path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("seeds/cigarette_seeds");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/cigarette_seeds");

        //public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("cigarettes/silver");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Config.MODID, path).toString());
        }
    }
}