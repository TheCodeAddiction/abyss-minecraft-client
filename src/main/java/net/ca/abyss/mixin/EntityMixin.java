package net.ca.abyss.mixin;

import net.ca.abyss.EvilMod;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(at = @At("TAIL"), method = "setPosition(DDD)V")
    public void setPosition(double x, double y, double z, CallbackInfo ci) {
        //EvilMod.LOGGER.info(String.valueOf(x),y,z);
    }
}
