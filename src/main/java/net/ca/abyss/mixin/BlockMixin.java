package net.ca.abyss.mixin;

import net.ca.abyss.EvilMod;
import net.minecraft.block.Block;
import net.minecraft.text.MutableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "getName()Lnet/minecraft/text/MutableText;")
    public void getName(CallbackInfoReturnable<MutableText> cir){
        EvilMod.LOGGER.info("getName() Block class");

    }
}
