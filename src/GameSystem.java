import java.util.Random;
import java.util.Scanner;

public class GameSystem {
    public static void main(String[] args) {
        boolean lose = false;
        boolean win = false;
        String state = "";
        Camel camel = new Camel();
        Scanner scan = new Scanner(System.in);

        while (!win && !lose){

            System.out.println("Enter run, walk, hydrate, rest, quit");
            state = scan.nextLine();
            if (state.equals("run")){
                camel.run();
                lose = camel.gameOverLose();
                win = camel.gameOverWin();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+ camel.getProgess() + " " + camel.getEnemy());

            }
            else if (state.equals("walk")){
                camel.walk();
                lose = camel.gameOverLose();
                win = camel.gameOverWin();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+ camel.getProgess() + " " + camel.getEnemy());
            }
            else if (state.equals("hydrate")){
                camel.hydrate();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+ camel.getProgess() + " " + camel.getEnemy());

            }
            else if (state.equals("rest")){
                camel.rest();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+ camel.getProgess() + " " + camel.getEnemy());
            }
            else if (state.equals("quit")) {
                win = true;
                lose = true;
            }
        }
    }
}
