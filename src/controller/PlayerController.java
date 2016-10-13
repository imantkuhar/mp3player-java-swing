package controller;

import model.Mp3File;
import ui.MP3Player;
import ui.PlayerView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by imant
 */
public class PlayerController {

    private PlayerView playerView;
    private MP3Player mp3Player = new MP3Player();
    private DefaultListModel mp3ListModel = new DefaultListModel();

    public PlayerController(PlayerView playerView) {
        this.playerView = playerView;
    }

    public void initAllListeners() {
        initAddButton();
        initDeleteButton();
        initNextButton();
        initPreviousButton();
        initPlayButton();
        initPauseButton();
        initSlideVolume();
    }

    private void initAddButton() {
        playerView.getAddSongButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
                fileChooser.setFileFilter(new FileNameExtensionFilter("mp3", "mp3"));
                fileChooser.setSelectedFile(new File(""));
                fileChooser.setMultiSelectionEnabled(true);

                if (e.getSource() == playerView.getAddSongButton()) {
                    int returnVal = fileChooser.showOpenDialog(playerView.getAddSongButton());
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File[] selectedFile = fileChooser.getSelectedFiles();
                        for (File file : selectedFile) {
                            Mp3File mp3File = new Mp3File(file.getName(), file.getPath());
                            playerView.getPlayList().setModel(mp3ListModel);
                            mp3ListModel.addElement(mp3File);
                        }
                    }
                }

            }
        });
    }

    private void initDeleteButton() {
        playerView.getDeleteSongButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] indexPlayList = playerView.getPlayList().getSelectedIndices();
                if (indexPlayList.length > 0) {
                    ArrayList<Mp3File> mp3FileListForRemove = new ArrayList<>();
                    for (int i = 0; i < indexPlayList.length; i++) {
                        Mp3File mp3File = (Mp3File) mp3ListModel.getElementAt(indexPlayList[i]);
                        mp3FileListForRemove.add(mp3File);
                    }

                    for (Mp3File mp3File : mp3FileListForRemove) {
                        mp3ListModel.removeElement(mp3File);
                    }
                }

            }
        });
    }

    private void initNextButton() {
        playerView.getNextSongButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nextIndex = playerView.getPlayList().getSelectedIndex() + 1;
                if (nextIndex <= playerView.getPlayList().getModel().getSize() - 1) {
                    playerView.getPlayList().setSelectedIndex(nextIndex);
                }
            }
        });
    }

    private void initPreviousButton() {
        playerView.getPreviousSongButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prevIndex = playerView.getPlayList().getSelectedIndex() - 1;
                if (prevIndex >= 0) {
                    playerView.getPlayList().setSelectedIndex(prevIndex);
                }
            }
        });
    }

    private void initPlayButton() {
        playerView.getPlayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] indexPlayList = playerView.getPlayList().getSelectedIndices();
                if (indexPlayList.length > 0) {
                    Mp3File mp3File = (Mp3File) mp3ListModel.getElementAt(indexPlayList[0]);
                    mp3Player.play(mp3File.getPath());
                    mp3Player.setVolume(playerView.getSlideVolume().getValue(), playerView.getSlideVolume().getMaximum());
                }
            }
        });
    }

    private void initPauseButton() {
        playerView.getPauseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp3Player.pause();
            }
        });
    }

    private void initSlideVolume() {
        playerView.getSlideVolume().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mp3Player.setVolume(playerView.getSlideVolume().getValue(), playerView.getSlideVolume().getMaximum());
            }
        });
    }
}
