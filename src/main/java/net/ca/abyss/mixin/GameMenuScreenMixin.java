package net.ca.abyss.mixin;

import net.ca.abyss.gui.MainMenuScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("TAIL"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci){
        this.addDrawableChild((new ButtonWidget.Builder(
                Text.literal("Abyss"),
                (button -> this.client.setScreen(new MainMenuScreen(this,this.client.options))))
                .build()));

    }
}
