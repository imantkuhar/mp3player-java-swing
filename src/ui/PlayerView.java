package ui;

import model.Mp3File;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;


/**
 * Created by imant
 */
public class PlayerView {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel listPanel;
    private JButton playButton;
    private JButton pauseButton;
    private JButton addSongButton;
    private JButton deleteSongButton;
    private JButton nextSongButton;
    private JButton previousSongButton;
    private JTextArea songListTextArea;
    private JSlider slideVolume;
    private JList playList;

    private static PlayerView instance;

    private PlayerView() {
    }

    public static PlayerView getInstance() {
        if (instance == null)
            instance = new PlayerView();
        return instance;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JPanel getListPanel() {
        return listPanel;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getAddSongButton() {
        return addSongButton;
    }

    public JButton getDeleteSongButton() {
        return deleteSongButton;
    }

    public JButton getNextSongButton() {
        return nextSongButton;
    }

    public JButton getPreviousSongButton() {
        return previousSongButton;
    }

    public JTextArea getSongListTextArea() {
        return songListTextArea;
    }

    public JSlider getSlideVolume() {
        return slideVolume;
    }

    public JList getPlayList() {
        return playList;
    }
}
