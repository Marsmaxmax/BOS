package com.marsmax.bos.register.block.entity;

import com.marsmax.bos.Bos;
import com.marsmax.bos.register.block.RegisterBlock;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterBlockEntities { 
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Bos.MODID);

    public static final RegistryObject<BlockEntityType<ArcFurnanceBlockEntity>> ARC_FURNANCE = 
        BLOCK_ENTITIES.register("arc_furnance", 
                                () -> BlockEntityType.Builder.of(
                                        ArcFurnanceBlockEntity::new,
                                        RegisterBlock.ARC_FURNANCE.get()).build(null));
    public static final RegistryObject<BlockEntityType<LatheBlockEntity>> LATHE = 
        BLOCK_ENTITIES.register("lathe", 
                                () -> BlockEntityType.Builder.of(
                                        LatheBlockEntity::new,
                                        RegisterBlock.LATHE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
