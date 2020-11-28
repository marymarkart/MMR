package ProjectStarterCode.controller;

import ProjectStarterCode.model.Camel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInfo{
    String win = "YOU WIN!";
    String dehydrate = "You have run out of water! You Lose!";
    String lostStamina = "You have run out of stamina! You lose!";
    String both = "You have run out of water and stamina! You lose!";
    String enemyWins = "The enemy has caught up to you! You lose!";

    // the state of the Game/Application
    // information that is needed to repaint the View
    public void GameInfo(String message, Camel camel) {
        int lose = 0;
        int winGame = 0;
        int status = 0;
        if (message.equals("run")) {
            status = camel.run();
            System.out.println(status);
            lose = camel.gameOverLose();
            winGame = camel.gameOverWin();
            if (lose == 1){
                gameMessage(both);
            }
            if (lose == 2){
                gameMessage(lostStamina);
            }
            if (lose == 3){
                gameMessage(dehydrate);
            }
            if (lose == 4){
                gameMessage(enemyWins);
            }
            if (winGame == 1){
                gameMessage(win);
            }
            if (status == 17) {
                camel.findOasis();
                camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
            }
            if (status == 13) {
                camel.sandstormHydrate();
                camel.sandstormStamina();
                camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
            }
            if (status == 10) {
                camel.cactusFlower();
                camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
            }
            System.out.println(camel.getHydration() + " " + camel.getStamina() + " " +
                    camel.getProgess() + " " + camel.getEnemy());
        } else if (message.equals("walk")) {
            camel.walk();
            camel.gameOverLose();
            camel.gameOverWin();
            lose = camel.gameOverLose();
            winGame = camel.gameOverWin();
            if (lose == 1){
                gameMessage(both);
            }
            if (lose == 2){
                gameMessage(lostStamina);
            }
            if (lose == 3){
                gameMessage(dehydrate);
            }
            if (lose == 4){
                gameMessage(enemyWins);
            }
            if (winGame == 1){
                gameMessage(win);
            }
            System.out.println(camel.getHydration() + " " + camel.getStamina() + " " +
                    camel.getProgess() + " " + camel.getEnemy());
        } else if (message.equals("hydrate")) {
            camel.hydrate();
            camel.gameOverLose();
            camel.gameOverWin();
            System.out.println(camel.getHydration() + " " + camel.getStamina() + " " +
                    camel.getProgess() + " " + camel.getEnemy());

        } else if (message.equals("rest")) {
            camel.rest();
            camel.gameOverLose();
            camel.gameOverWin();
            System.out.println(camel.getHydration() + " " + camel.getStamina() + " " +
                    camel.getProgess() + " " + camel.getEnemy());
        } else if (message.equals("quit")) {
            System.exit(0);
            System.out.println("Quit Game");
        }
    }
        public void gameMessage (String message){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(400, 100));
        JLabel text = new JLabel(message);
        frame.add(text);
        JButton ok = new JButton("End Game");
        frame.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
