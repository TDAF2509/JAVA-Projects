package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class Background extends UserView{
    private ImageIcon bgLayer1 = new ImageIcon("data/stars.jpg");
    private ImageIcon bgLayer2 = new ImageIcon("data/bg2.png");
    private ImageIcon bgLayer3 = new ImageIcon("data/bg3.png");

    public Background(World world, int height, int width){
        super(world,height,width);
    }

    @Override
    public void paintBackground(Graphics2D graphics2D){
        graphics2D.drawImage(bgLayer2.getImage(),0,0,550,500,this);
        //graphics2D.drawImage(bgLayer3.getImage(),0,400,500,200,this);
    }
}
