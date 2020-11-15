import java.util.Random;

public class Camel {
    int hydration;
    int stamina;
    int progress;
    int enemy;
    Random rand = new Random();
    int number = 0;


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
        return number;

    }


    public int walk(){
        number = rand.nextInt(10) + 1;
        progress += number;
        hydration -= 1;
        stamina -= 1;
        enemyMoves();
        return number;
    }

    public void hydrate(){
        this.hydration = 10;
    }

    public void rest(){
        this.stamina = 10;
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
            return true;
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


}
