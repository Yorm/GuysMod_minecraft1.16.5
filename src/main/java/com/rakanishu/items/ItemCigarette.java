package com.rakanishu.items;

import com.mojang.datafixers.util.Pair;
import com.rakanishu.setup.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.entity.Entity.getHorizontalDistanceSqr;

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
                spawnParticle(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), world, livingEntity);
                world.playSound((PlayerEntity)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.PARROT_IMITATE_CREEPER, SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            }
        //}
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity livingEntity) {
        ItemStack flintAndSteel = livingEntity.getItemInHand(Hand.OFF_HAND);

        //if(livingEntity instanceof PlayerEntity){
            if(!flintAndSteel.isEmpty() && flintAndSteel.getItem() instanceof FlintAndSteelItem) {
                spawnParticle(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),  world,livingEntity);
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

    private void spawnParticle(double xCoord, double yCoord, double zCoord, World world, LivingEntity livingEntity){
        Vector3d vector3d = livingEntity.getViewVector(1.0F); // returns a normalized vector, which is what you want in this case
        // add one of each vector coordinate to the player's position to get a position just in front of the player
        double x = xCoord + vector3d.x;
        double y = yCoord + vector3d.y;
        double z = zCoord + vector3d.z;
        for (int k = 0; k < 3; ++k){
            double d1 = (double)x + world.random.nextDouble()-0.4d;
            double d2 = (double)y + world.random.nextDouble()+1.0d;
            double d3 = (double)z + world.random.nextDouble();
            world.addParticle(ParticleTypes.SMOKE,  d1, d2, d3,vector3d.x * 0.15, 0.05D,vector3d.z * 0.15);
            world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d1, d2, d3, vector3d.x * 0.15 , 0.05D,vector3d.z * 0.15);
            world.addParticle(ParticleTypes.LARGE_SMOKE, d1, d2, d3, vector3d.x * 0.15 , 0.05D,vector3d.z * 0.15);
        }
    }
}
