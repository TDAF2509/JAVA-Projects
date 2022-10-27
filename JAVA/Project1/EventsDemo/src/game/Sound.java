package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Sound extends SoundClip{

    public Sound(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(fileName);
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public void setVolume(double volume) {
        super.setVolume(volume);
    }

    @Override
    public void loop() {
        super.loop();
    }

    @Override
    public void stop() {
        super.stop();
    }


}
