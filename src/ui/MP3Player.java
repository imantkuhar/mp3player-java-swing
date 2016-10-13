package ui;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

/**
 * Created by imant
 */
public class MP3Player {

    private BasicPlayer player = new BasicPlayer();
    private String currentFileName;
    private double currentVolumeValue;

    public void play(String fileName) {

        try {
            if (currentFileName != null && currentFileName.equals(fileName) && player.getStatus() == BasicPlayer.PAUSED) {
                player.resume();
                return;
            }
            currentFileName = fileName;
            player.open(new File(fileName));
            player.play();
            player.setGain(currentVolumeValue);
        } catch (BasicPlayerException e) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void pause() {
        try {
            player.pause();
        } catch (BasicPlayerException e) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setVolume(int currentValue, int maximumValue) {
        try {
            this.currentVolumeValue = currentValue;
            if (currentValue == 0) {
                player.setGain(0);
            } else {
                player.setGain(calcVolume(currentValue, maximumValue));
            }
        } catch (BasicPlayerException e) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private double calcVolume(int currentValue, int maximumValue) {
        currentVolumeValue = (double) currentValue / (double) maximumValue;
        return currentVolumeValue;
    }
}


