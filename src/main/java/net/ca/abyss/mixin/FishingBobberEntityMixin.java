package net.ca.abyss.mixin;

import net.ca.abyss.EvilMod;
import net.ca.abyss.Exploits.AutoFish;
import net.ca.abyss.Exploits.ExploitVars;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin {
    MinecraftClient client = MinecraftClient.getInstance();
    @Shadow private boolean caughtFish;


    @Inject(at = @At("HEAD"), method = "tick()V", cancellable = true)
    public void tick(CallbackInfo ci){
        try{
            ExploitVars exploitVars = new ExploitVars();
            if(exploitVars.getAutoFishingStatus()){
                if(this.caughtFish && (client.player != null) && (client.world != null)){
                    AutoFish autoFish = new AutoFish();
                        autoFish.useRod(client);
                        exploitVars.disableFishing();
                }
            }
        }catch (Exception e){
            EvilMod.LOGGER.error(e.toString());
            EvilMod.LOGGER.error(e.getMessage());
        }
    }
}


