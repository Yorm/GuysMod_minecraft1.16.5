package com.rakanishu.items;

import com.mojang.datafixers.util.Pair;
import com.rakanishu.setup.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemCigarette extends Item implements IItemProvider{
    private static Logger logger = LogManager.getLogger(Item.class);

    public ItemCigarette(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public UseAction getUseAnimation(ItemStack itemStack) {
        return UseAction.BOW;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, World world, LivingEntity livingEntity, int i) {
        super.releaseUsing(itemStack, world, livingEntity, i);
        ItemStack flintAndSteel = livingEntity.getItemInHand(Hand.OFF_HAND);

        //if(livingEntity instanceof PlayerEntity){
            if(!flintAndSteel.isEmpty() && flintAndSteel.getItem() instanceof FlintAndSteelItem) {
                flintAndSteel.hurtAndBreak(1, livingEntity, (consumer) -> {
                    consumer.broadcastBreakEvent(livingEntity.getUsedItemHand());
                });
                spawnParticle(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),  world,livingEntity.xRot,livingEntity.yRot);
                world.playSound((PlayerEntity)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.PARROT_IMITATE_CREEPER, SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            }
        //}
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity livingEntity) {
        ItemStack flintAndSteel = livingEntity.getItemInHand(Hand.OFF_HAND);

        //if(livingEntity instanceof PlayerEntity){
            if(!flintAndSteel.isEmpty() && flintAndSteel.getItem() instanceof FlintAndSteelItem) {
                spawnParticle(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),  world,livingEntity.xRot,livingEntity.yRot);
                flintAndSteel.hurtAndBreak(1, livingEntity, (consumer) -> {
                    consumer.broadcastBreakEvent(livingEntity.getUsedItemHand());
                });

                this.addEffect(itemStack,world,livingEntity);
                world.playSound((PlayerEntity)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.CAMPFIRE_CRACKLE, SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
                itemStack.shrink(1);

                ItemStack stump = new ItemStack(ModItems.STUMP.get());
                PlayerEntity playerentity = (PlayerEntity)livingEntity;
                if (!playerentity.inventory.add(stump)) {
                    playerentity.drop(stump, false);
                }
            }
        //}
        return itemStack;
    }

    private void addEffect(ItemStack itemStack, World world, LivingEntity livingEntity){
        Item item = itemStack.getItem();
        for(Pair<EffectInstance, Float> pair : item.getFoodProperties().getEffects()) {
            if (!world.isClientSide && pair.getFirst() != null && world.random.nextFloat() < pair.getSecond()) {
                livingEntity.addEffect(new EffectInstance(pair.getFirst()));
            }
        }
    }

    private void spawnParticle(double xCoord, double yCoord, double zCoord, World world, float xRot, float yRot){
        for (int k = 0; k < 12; ++k){
            world.addParticle(ParticleTypes.SMOKE, xCoord , yCoord + 1.5D, zCoord , 0.05D, 0.02D,0.05D);
        }
        world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, xCoord , yCoord + 1.5D, zCoord , 0.05D, 0.02D,0.05D);


        /*

        logger.info("xrot " +xRot);//up down -90  90
        logger.info("yrot " +yRot); //circle -180  180



        float f = -MathHelper.sin(yRot * ((float)Math.PI / 180F)) * MathHelper.cos(xRot * ((float)Math.PI / 180F));
        float f1 = -MathHelper.sin((xRot +yRot) * ((float)Math.PI / 180F));
        float f2 = MathHelper.cos(yRot * ((float)Math.PI / 180F)) * MathHelper.cos(xRot * ((float)Math.PI / 180F));

        logger.info("f  " +f);
        logger.info("f1  " +f1);
        logger.info("f2  " +f2);


        Vector3d vector3d = (new Vector3d(f, f1, f2)).normalize().add(this.random.nextGaussian() * (double)0.0075F * (double)1.0F, this.random.nextGaussian() * (double)0.0075F * (double)1.0F, this.random.nextGaussian() * (double)0.0075F * (double)1.0F).scale((double)f * 3.0F);
        logger.info("f2  " +f2);

        float fs = MathHelper.sqrt(getHorizontalDistanceSqr(vector3d));
        yRot = (float)(MathHelper.atan2(vector3d.x, vector3d.z) * (double)(180F / (float)Math.PI));
        xRot = (float)(MathHelper.atan2(vector3d.y, (double)fs) * (double)(180F / (float)Math.PI));


        world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, xCoord  , yCoord + 1.5D, zCoord, 0.05D, 0.02D,0.05D);
        */
    }

    /*
    public static double getHorizontalDistanceSqr(Vector3d p_213296_0_) {
        return p_213296_0_.x * p_213296_0_.x + p_213296_0_.z * p_213296_0_.z;
    }
    */
}
