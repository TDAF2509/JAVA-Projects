package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanal implements ActionListener,ChangeListener{
    private JButton SAVEButton;
    private JButton MUTESOUNDButton;
    private JSlider VOLUME;
    public JPanel MainControlPanal;
    private JLabel VolumeLabel;
    private JButton LOADButton;
    ObjectInteraction oi;
    Interactions i;
    private Game game;

    public ControlPanal(Game game){
        this.game=game;
        SAVEButton.setFocusable(false);
        SAVEButton.addActionListener(this);
        MUTESOUNDButton.setFocusable(false);
        MUTESOUNDButton.addActionListener(this);
        LOADButton.setFocusable(false);
        LOADButton.addActionListener(this);
        VOLUME.setFocusable(false);
        VOLUME.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SAVEButton){
            System.out.println("SAVE PRESSED");
            SavingData savingData =  new SavingData("data/GameSave.txt");
            try {
                savingData.saveGameScore(game.world);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else if (e.getSource() == MUTESOUNDButton){
            System.out.println("MUTE PRESSED");
            VOLUME.setValue(1);
            oi.sound.setVolume(0.0001);
            i.sound.setVolume(0.0001);
            game.gamebgm.setVolume(0.0001);
        }else if (e.getSource() == LOADButton){
            System.out.println("LOAD PRESSED ");
            ReadingData readingData = new ReadingData("data/GameSave.txt",game);
            try {
                GameLevel loadedGame =readingData.loadGame();
                game.goToLevel(loadedGame);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
