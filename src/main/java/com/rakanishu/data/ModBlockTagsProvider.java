package com.rakanishu.data;

import com.rakanishu.configs.Config;
import com.rakanishu.setup.ModBlocks;
import com.rakanishu.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Config.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.BLOCK_LEXA).add(ModBlocks.LEXA_BLOCK.get());
        tag(Tags.Blocks.DIRT).addTag(ModTags.Blocks.BLOCK_LEXA);
        tag(ModTags.Blocks.STORAGE_BLOCK_LEXA).add(ModBlocks.LEXA_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCK_LEXA);

    }
}
