package ProjectStarterCode.controller;

import ProjectStarterCode.model.Camel;

public class GameInfo {
    // the state of the Game/Application
    // information that is needed to repaint the View
    public void GameInfo(Message message, Camel camel) {
        int status = 0;
        if (message.equals("run")) {
            status = camel.run();
            System.out.println(status);
            camel.gameOverLose();
            camel.gameOverWin();
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
}
