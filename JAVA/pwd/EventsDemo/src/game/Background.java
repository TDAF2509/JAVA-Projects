package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class Background extends UserView{
    private ImageIcon bgLayer1 = new ImageIcon("data/bg1.png");
    private ImageIcon bgLayer2 = new ImageIcon("data/bg2.png");
    private ImageIcon bgLayer3 = new ImageIcon("data/Health icon.png");
    private ImageIcon bgLayer4 = new ImageIcon("data/HUD.png");
    private ImageIcon bgLayer5 = new ImageIcon("data/giphy.gif");
    private ImageIcon bgLayer6 = new ImageIcon("data/text (2).png");
    private Sonic sonic;
    private GameLevel gameLevel;

    public Background(World world, int height, int width ,GameLevel gameLevel){
        super(world,height,width);
        this.gameLevel = gameLevel;
    }

    @Override
    public void paintBackground(Graphics2D graphics2D){
        graphics2D.drawImage(bgLayer1.getImage(),0,0,750,500,this);
        graphics2D.drawImage(bgLayer2.getImage(),0,50,720,800,this);
    }

    @Override
    public void paintForeground(Graphics2D graphics2D) {
        super.paintForeground(graphics2D);
        graphics2D.setFont(new Font("TimesRoman",Font.PLAIN,20));
        graphics2D.setColor(new Color(99999999));
        graphics2D.drawImage(bgLayer4.getImage(),0,-130,250,350,this);
        graphics2D.drawImage(bgLayer5.getImage(),50,25,40,40,this);
        graphics2D.drawImage(bgLayer6.getImage(),150,15,40,35,this);
        graphics2D.drawString(""+gameLevel.getSonic().getRingCount(),140,60);
        graphics2D.drawString(""+gameLevel.getSonic().getHealth(),110,460);
        graphics2D.drawImage(bgLayer3.getImage(),20,430,60,60,this);

    }
}
