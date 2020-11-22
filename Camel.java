import java.util.Random;

public class Camel extends CamelModifier {
	int hydration;
    int stamina;
    int progress;
    int enemy;
    Random rand = new Random();
    int number = 0;


    public Camel() {
    	hydration = 10;
        stamina = 10;
        progress = 0;
        enemy = -5;
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

    public void run(){
        number = rand.nextInt(20) + 5;
        System.out.println("You moved " + number + " miles");
        progress += number;
        hydration -= 2;
        stamina -= 2;
        enemyMoves();
        if (number <= 17 && number > 13){
            findOasis();
            hydration = 10;
        }
        if (number == 13){
        	sandstorm();
        	hydration /= 2;
        	stamina /= 2;
        }
        if (number == 10){
        	cactusFlower();
        	stamina = 10;
        }

    }

    public void walk(){
        number = rand.nextInt(10) + 1;
        System.out.println("You moved " + number + " miles");
        progress += number;
        hydration -= 1;
        stamina -= 1;
        enemyMoves();
    }

    public void hydrate(){
        System.out.println("You stopped to hydrate");
    	this.hydration = 10;
        enemyMoves();
    }

    public void rest(){
    	System.out.println("You stopped to rest");
    	this.stamina = 10;
        enemyMoves();
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