package com.marsmax.bos.util.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import com.marsmax.bos.register.block.entity.ArcFurnanceBlockEntity;
import com.marsmax.bos.register.modmenu.arcfurnance.ArcFurnanceMenu;

import com.marsmax.bos.register.block.entity.LatheBlockEntity;
import com.marsmax.bos.register.modmenu.lathe.LatheMenu;
public class EnergySyncS2CPacket {
    private final int energy;
    private final BlockPos pos;

    public EnergySyncS2CPacket(int energy, BlockPos pos) {
        this.energy = energy;
        this.pos = pos;
    }

    public EnergySyncS2CPacket(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof ArcFurnanceBlockEntity blockEntity) {
                blockEntity.setEnergyLevel(energy);

                if(Minecraft.getInstance().player.containerMenu instanceof ArcFurnanceMenu menu &&
                    menu.getBlockEntity().getBlockPos().equals(pos)) {
                    blockEntity.setEnergyLevel(energy);
                }
            } else if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof LatheBlockEntity blockEntity) {
                blockEntity.setEnergyLevel(energy);

                if(Minecraft.getInstance().player.containerMenu instanceof LatheMenu menu &&
                    menu.getBlockEntity().getBlockPos().equals(pos)) {
                    blockEntity.setEnergyLevel(energy);
                }
            }
        });
        return true;
    }
}