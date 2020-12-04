package CamelGame.model;

import java.util.Random;
import CamelGame.view.StatsView;
import javax.swing.*;

/**
 * Main model that represents the player and includes properties and possible actions to take 
 * @author MMR
 *
 */
public class Camel{
    int hydration;
    int stamina;
    int progress;
    int enemy;
    Random rand = new Random();
    int number = 0;
    CamelIcon icon;
    StatsView sView;
    ImageIcon run = new ImageIcon("images/camelRun.gif");
    ImageIcon walk = new ImageIcon("images/camelWalk.gif");
    ImageIcon rest = new ImageIcon("images/camelRest.gif");
    ImageIcon camel1 = new ImageIcon("images/camel1.png");
    ImageIcon currentStateImage = camel1;

    /**
     * Constructor that creates a new Camel object with initial status values
     */
    public Camel() {
        this.hydration = 10;
        this.stamina = 10;
        this.progress = 0;
        this.enemy = -5;
        this.sView = new StatsView(hydration, stamina, progress, enemy);
        icon = new CamelIcon();
    }

    /**
     * Returns StatsView object of Camel class
     * @return
     */
    public StatsView getsView() {
        return sView;
    }

    /**
     * Returns hydration variable of Camel class
     * @return
     */
    public int getHydration() {
        return hydration;
    }

    /**
     * Returns enemy progress variable of Camel class
     * @return
     */
    public int getEnemy(){
        return enemy;
    }

    /**
     * Increases enemy progress variable of Camel class by 8
     * @return
     */
    public void enemyMoves(){
        this.enemy += 8;
    }

    /**
     * Increases player progress variable of Camel class by a random number from 5 to 20 as well as enemy progress by 8.
     * Decreases stamina and hydration by 2.
     * @return
     */
    public int run(){
        number = rand.nextInt(15) + 5;
        progress += number;
        hydration -= 2;
        stamina -= 2;
        enemyMoves();
        updateValues(hydration, stamina, progress, enemy);
        currentStateImage = run;
        return number;
    }

    /**
     * Increases player progress variable of Camel class by a random number from 1 to 10 as well as enemy progress variable by 8.
     * Decreases stamina and hydration by 1.
     * @return
     */
    public int walk(){
        currentStateImage = walk;
        number = rand.nextInt(9) + 1;
        progress += number;
        hydration -= 1;
        stamina -= 1;
        enemyMoves();
        updateValues(hydration, stamina, progress, enemy);
        return number;
    }

    /**
     * Sets hydration variable of Camel class to 10.
     * Enemy progress variable of Camel class increases by 3.
     */
    public void hydrate(){
        this.hydration = 10;
        this.enemy += 3;
        updateValues(hydration, stamina, progress, enemy);
    }

    /**
     * Sets stamina variable of Camel class to 10.
     * Enemy progress variable of Camel class increases by 3.
     */
    public void rest(){
        this.stamina = 10;
        this.enemy += 3;
        updateValues(hydration, stamina, progress, enemy);
        currentStateImage = rest;
    }

    /**
     * Returns stamina variable of Camel class
     * @return
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Returns progress variable of Camel class
     * @return
     */
    public int getProgress(){
        return progress;
    }

    /**
     * Returns an integer determined by how the player lost, or 0 if the player has not yet lost
     * @return
     */
    public int gameOverLose(){
        if (stamina <= 0 && hydration <= 0){
            return 1;
        }
        if (stamina <= 0){

            return 2;
        }
        if (hydration <= 0){
            return 3;
        }
        if (enemy >= progress){
            return 4;
        }
        return 0;
    }

    /**
     * Returns an integer determined by whether or not the player won
     * @return
     */
    public int gameOverWin(){
        if (progress >= 250 && stamina > 0 && hydration > 0 && progress > enemy){
            return 1;
        }
        return 0;
    }

    /**
     * Returns an image of the camel, based on the state of the camel
     * @return
     */
    public ImageIcon getCamelImage(){
        return currentStateImage;
    }

    /**
     * Updates values of StatsView
     * @param n1 represents hydration
     * @param n2 represents stamina
     * @param n3 represents player progress
     * @param n4 represents enemy progress
     */
    public void updateValues(int n1, int n2, int n3, int n4) {
        sView.updateStats(n1, n2, n3, n4);
    }

    /**
     * Returns x-coordinate of camel image
     * @return
     */
    public int getX() {
        return icon.x;
    }
    /**
     * Returns y-coordinate of camel image
     * @return
     */
    public int getY() {
        return icon.y;
    }

}