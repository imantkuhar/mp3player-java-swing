package main;

import controller.PlayerController;
import model.UiConstants;
import ui.PlayerView;

import javax.swing.*;

/**
 * Created by imant
 */
public class Main {

    public static void main(String[] args) {
        startMediaPlayer();
    }

    private static void startMediaPlayer(){
        JFrame frame = new JFrame(UiConstants.APP_NAME);
        frame.setContentPane(PlayerView.getInstance().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        PlayerController playerController = new PlayerController(PlayerView.getInstance());
        playerController.initAllListeners();
    }
}
