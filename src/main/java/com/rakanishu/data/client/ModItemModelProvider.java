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

        builder(itemGenerated, ItemNames.STUMP);

        builder(itemGenerated, ItemNames.TOBACCO_SEEDS);
        builder(itemGenerated, ItemNames.CIGARETTE_SEEDS);
        builder(itemGenerated, ItemNames.DON_SEEDS);

        builder(itemGenerated, ItemNames.DONSKOY_TABAK_CIGARETTE);
        builder(itemGenerated, ItemNames.JOINT_CIGARETTE);
        builder(itemGenerated, ItemNames.BOND_WIHT_BUTTON_CIGARETTE);
        builder(itemGenerated, ItemNames.GOLDEN_BEACH_CIGARETTE);
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
