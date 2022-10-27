package game;
import city.cs.engine.StepEvent;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class MyView extends UserView {

    // layered background to make parallax effect
    private ImageIcon icon1 = new ImageIcon("data/sky.png");
    private ImageIcon icon2 = new ImageIcon("data/clouds.png");
    private ImageIcon icon3 = new ImageIcon("data/sea.png");
    private ImageIcon icon4 = new ImageIcon("data/ground.png");


    public MyView(World w, int height, int width) {
        super(w,height, width);

    }

    @Override
    public void paintBackground(Graphics2D g){

        g.drawImage(icon1.getImage(),0,0, 1500, 275,this);
        g.drawImage(icon2.getImage(),0,150, 1500, 175,this);
        g.drawImage(icon3.getImage(), 0, 325, 1500, 175, this);
        g.drawImage(icon4.getImage(),450,150, 1500, 350,this);

    }



}