package net.ca.abyss.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.MovementType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class MainMenuScreen extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    public MainMenuScreen(Screen parent, GameOptions settings){
        super(Text.literal("Abyss"));
        this.parent = parent;
        this.settings = settings;
    }
    public void up(){
        Vec3d vec3d = new Vec3d(0, 20, 0);
        client.player.move(MovementType.PLAYER, vec3d);
    }
    @Override
    //Creats the base layout of the Abyss client
    protected void init(){
        //back button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.backButton),
                (button -> this.client.setScreen(this.parent)))
                .build());
        //TP button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.tpButton),
                (button -> up()))
                .position(175,0)
                .build());


    }

}
