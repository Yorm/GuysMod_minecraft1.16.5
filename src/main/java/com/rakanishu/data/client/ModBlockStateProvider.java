package com.rakanishu.data.client;

import com.rakanishu.configs.BlockStates;
import com.rakanishu.configs.Config;
import com.rakanishu.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Config.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(ModBlocks.ARTIOM_BLOCK.get());
        this.simpleBlock(ModBlocks.LEXA_BLOCK.get());
        this.simpleBlock(ModBlocks.OSINA_BLOCK.get());

        BlockModelBuilder weedstate0 = models().cross(BlockStates.WEED_BLOCK_STAGE_0,modLoc("block/bush/weed/" + BlockStates.WEED_BLOCK_STAGE_0));
        BlockModelBuilder weedstate1 = models().cross(BlockStates.WEED_BLOCK_STAGE_1,modLoc("block/bush/weed/" + BlockStates.WEED_BLOCK_STAGE_1));
        BlockModelBuilder weedstate2 = models().cross(BlockStates.WEED_BLOCK_STAGE_2,modLoc("block/bush/weed/" + BlockStates.WEED_BLOCK_STAGE_2));
        BlockModelBuilder weedstate3 = models().cross(BlockStates.WEED_BLOCK_STAGE_3,modLoc("block/bush/weed/" + BlockStates.WEED_BLOCK_STAGE_3));

        this.simpleBlock(ModBlocks.WEED_BUSH.get(),
                new ConfiguredModel(weedstate0),
                new ConfiguredModel(weedstate1),
                new ConfiguredModel(weedstate2),
                new ConfiguredModel(weedstate3));

        BlockModelBuilder tobaccostate0 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_0,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_0));
        BlockModelBuilder tobaccostate1 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_1,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_1));
        BlockModelBuilder tobaccostate2 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_2,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_2));
        BlockModelBuilder tobaccostate3 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_3,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_3));
        BlockModelBuilder tobaccostate4 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_3,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_3));
        BlockModelBuilder tobaccostate5 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_4,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_4));
        BlockModelBuilder tobaccostate6 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_5,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_5));
        BlockModelBuilder tobaccostate7 = models().crop(BlockStates.TOBACCO_BLOCK_STAGE_6,modLoc("block/crop/tobacco/" + BlockStates.TOBACCO_BLOCK_STAGE_6));

        this.simpleBlock(ModBlocks.TOBACCO_CROP.get(),
                new ConfiguredModel(tobaccostate0),
                new ConfiguredModel(tobaccostate1),
                new ConfiguredModel(tobaccostate2),
                new ConfiguredModel(tobaccostate3),
                new ConfiguredModel(tobaccostate4),
                new ConfiguredModel(tobaccostate5),
                new ConfiguredModel(tobaccostate6),
                new ConfiguredModel(tobaccostate7));
    }
}