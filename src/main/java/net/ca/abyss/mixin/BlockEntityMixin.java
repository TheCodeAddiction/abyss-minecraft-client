package net.ca.abyss.mixin;

import net.ca.abyss.EvilMod;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntity.class)
public class BlockEntityMixin {
    @Inject(at=@At("HEAD"), method = "getPos()Lnet/minecraft/util/math/BlockPos;")
    public void getPos(CallbackInfoReturnable<BlockPos> cir){
        //EvilMod.LOGGER.info(cir.getReturnValue().toString());
    }

}
