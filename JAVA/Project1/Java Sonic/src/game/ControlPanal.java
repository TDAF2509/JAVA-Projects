package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanal implements ActionListener,ChangeListener{
    private JButton MUTESOUNDButton;
    private JSlider VOLUME;
    public JPanel MainControlPanal;
    private JLabel VolumeLabel;
    private Game game;

    public ControlPanal(Game game){
        this.game=game;
        MUTESOUNDButton.setFocusable(false);
        MUTESOUNDButton.addActionListener(this);
        VOLUME.setFocusable(false);
        VOLUME.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MUTESOUNDButton){
            System.out.println("MUTE PRESSED");
            VOLUME.setValue(1);
            game.gamebgm.setVolume(0.0001);
        }
    }

    private float volumeScale(float value,float minInput,float maxInput,float minRange, float maxRange){
        return ((maxRange-minInput)*(value-minRange)/(maxInput-minInput)+minRange);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        float volume = volumeScale((float)VOLUME.getValue(),1f,100f,0.0001f,2f);
        game.gamebgm.setVolume(volume);

    }
}
