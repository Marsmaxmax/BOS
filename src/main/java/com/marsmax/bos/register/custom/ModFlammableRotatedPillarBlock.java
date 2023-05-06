package com.marsmax.bos.register.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import com.marsmax.bos.register.RegisterBlock;
//UNUSED IMPLEMENTATION: LOG BLOCKS
public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            //if(state.is(RegisterBlock.TEST_LOG.get())) {
            //    return RegisterBlock.STRIPPED_TEST_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            //}
            //if(state.is(RegisterBlock.TEST_WOOD.get())) {
            //    return RegisterBlock.STRIPPED_TEST_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            //}
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
