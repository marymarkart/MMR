package ProjectStarterCode.model;

import java.util.Random;
import ProjectStarterCode.view.StatsView;
import javax.swing.*;

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

    public Camel() {
        this.hydration = 10;
        this.stamina = 10;
        this.progress = 0;
        this.enemy = -5;
        this.sView = new StatsView(hydration, stamina, progress, enemy);
        icon = new CamelIcon();
    }

    public StatsView getsView() {
        return sView;
    }

    public int getHydration() {
        return hydration;
    }

    public int getEnemy(){
        return enemy;
    }

    public void enemyMoves(){
        this.enemy += 8;
    }

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

    public int walk(){
        currentStateImage = walk;
        number = rand.nextInt(10) + 1;
        progress += number;
        hydration -= 1;
        stamina -= 1;
        enemyMoves();
        updateValues(hydration, stamina, progress, enemy);
        return number;
    }

    public void hydrate(){
        this.hydration = 10;
        this.enemy += 3;
        updateValues(hydration, stamina, progress, enemy);
    }

    public void rest(){
        this.stamina = 10;
        this.enemy += 3;
        updateValues(hydration, stamina, progress, enemy);
        currentStateImage = rest;
    }

    public int getStamina() {
        return stamina;
    }

    public int getProgress(){
        return progress;
    }

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

    public int gameOverWin(){
        if (progress >= 250 && stamina > 0 && hydration > 0 && progress > enemy){
            return 1;
        }
        return 0;
    }

    public ImageIcon getCamelImage(){
        return currentStateImage;
    }

    public void attach(StatsView sView) {
        this.sView = sView;
    }

    public void updateValues(int n1, int n2, int n3, int n4) {
        sView.updateStats(n1, n2, n3, n4);
    }

    public int getX() {
        return icon.x;
    }
    public int getY() {
        return icon.y;
    }

}

