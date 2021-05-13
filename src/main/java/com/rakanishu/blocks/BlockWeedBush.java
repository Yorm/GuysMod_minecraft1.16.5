package com.rakanishu.blocks;


import com.rakanishu.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockWeedBush extends SweetBerryBushBlock {
    public BlockWeedBush(Properties p_i49971_1_) {
        super(p_i49971_1_);
    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return new ItemStack(ModItems.WEED_BUMP.get());
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return super.getShape(p_220053_1_, p_220053_2_, p_220053_3_, p_220053_4_);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            popResource(world, pos, new ItemStack(ModItems.WEED_BUMP.get()	, j + (flag ? 1 : 0)));
            world.playSound((PlayerEntity)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlock(pos, state.setValue(AGE, Integer.valueOf(1)), 2);
            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, blockRayTraceResult);
        }
    }
}
