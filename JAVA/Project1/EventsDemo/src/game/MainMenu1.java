package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu1 implements ActionListener{
    private JButton Play;
    private JButton Quit;
    private JPanel Menu;
    public JFrame jFrame;
    private boolean started;

    public MainMenu1() {
        started=false;
        jFrame =new JFrame("MAIN MENU");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.add(Menu);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(700,500);
        Play.setFocusable(false);
        Play.addActionListener(this);
        Quit.setFocusable(false);
        Quit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Play){
            System.out.println("PLAY");
            if (started==true){

            }else {
                new Game();
            }
            started=true;
        }else if (e.getSource() == Quit){
            System.out.println("QUIT");
            System.exit(0);
        }
    }
}
