package net.ca.abyss.gui;

import net.ca.abyss.Exploits.ExploitVars;
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
        ExploitVars exploitVars = new ExploitVars();
        //back button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.backButton),
                (button -> this.client.setScreen(this.parent)))
                .build());
        //TP button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.tpButton),
                (button -> up()))
                .dimensions(175,0,100,20)
                .build());

        //Enable flight button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.flyOnButton),
                (button -> exploitVars.enableFlight()))
                .dimensions(300,0,100,20)
                .build());

        //Disable flight button
        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.flyOffButton),
                (button -> exploitVars.disableFlight()))
                .dimensions(300,50,100,20)
                .build());

        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.fishingOnButton),
                (button -> exploitVars.enableAutoFishing()))
                .dimensions(425,0,100,20)
                .build());

        this.addDrawableChild(new ButtonWidget.Builder(
                Text.literal(AbyssUi.fishingOffButton),
                (button -> exploitVars.disableAutoFishing()))
                .dimensions(425,50,100,20)
                .build());

    }

}
