package com.rakanishu.data.client;

import com.rakanishu.configs.Config;
import com.rakanishu.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Config.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ARTIOM_BLOCK.get());
        simpleBlock(ModBlocks.LEXA_BLOCK.get());
        simpleBlock(ModBlocks.OSINA_BLOCK.get());
    }
}