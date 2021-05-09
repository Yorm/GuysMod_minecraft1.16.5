package com.rakanishu.data.client;

import com.rakanishu.configs.BlockNames;
import com.rakanishu.configs.Config;
import com.rakanishu.configs.ItemNames;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator,  ExistingFileHelper existingFileHelper) {
        super(generator, Config.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(BlockNames.LEXA_BLOCK, modLoc("block/" + BlockNames.LEXA_BLOCK));
        withExistingParent(BlockNames.OSINA_BLOCK, modLoc("block/" + BlockNames.OSINA_BLOCK));
        withExistingParent(BlockNames.ARTIOM_BLOCK, modLoc("block/" + BlockNames.ARTIOM_BLOCK));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, ItemNames.CIGARETTE_SEEDS);
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
