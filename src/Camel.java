import javax.swing.plaf.nimbus.State;
import java.util.Random;

public class Camel {
    int hydration;
    int stamina;
    int progress;
    int enemy;
    Random rand = new Random();
    int number = 0;
    StatsView sView;


    public Camel() {
        this.hydration = 10;
        this.stamina = 10;
        this.progress = 0;
        this.enemy = -5;
    }

    public int getHydration() {
        return hydration;
    }

    public int getEnemy(){
        return enemy;
    }

    public void enemyMoves(){
        this.enemy += 10;
    }

    public int run(){
        number = rand.nextInt(20) + 5;
        progress += number;
        hydration -= 2;
        stamina -= 2;
        enemyMoves();
        updateValues(hydration, stamina, progress, enemy);
        return number;


    }


    public int walk(){
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
        updateValues(hydration, stamina, progress, enemy);
    }

    public void rest(){
        this.stamina = 10;
        updateValues(hydration, stamina, progress, enemy);
    }


    public int getStamina() {
        return stamina;
    }

    public int getProgess(){
        return progress;
    }

    public boolean gameOverLose(){
        if (stamina <= 0){
            System.out.println("You ran out of stamina");
        }
        if (hydration <= 0){
            System.out.println("You ran out of water");
            return true;
        }
        if (enemy >= progress){
            System.out.println("The enemy caught you");
            return true;
        }
       return false;
    }

    public boolean gameOverWin(){
        if (progress >= 250){
            System.out.println("You win");
            return true;
        }
        return false;
    }

    public void attach(StatsView sView) {
        this.sView = sView;
    }

    public void updateValues(int n1, int n2, int n3, int n4) {
        sView.updateStats(n1, n2, n3, n4);
    }


}
