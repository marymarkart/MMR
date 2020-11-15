import java.util.Random;
import java.util.Scanner;

public class GameSystem {
    public static void main(String[] args) {
        boolean lose = false;
        boolean win = false;
        String state = "";
        Camel camel = new Camel();
        int status = 0;
        CamelModifier modify = new CamelModifier();
        Scanner scan = new Scanner(System.in);

        while (!win && !lose){

            System.out.println("Enter run, walk, hydrate, rest, quit");
            state = scan.nextLine();
            if (state.equals("run")){
                status = camel.run();
                lose = camel.gameOverLose();
                win = camel.gameOverWin();
                if (status <= 17 && status > 13){

                    modify.findOasis(camel);
                }
                if (status == 13){
                    //CamelModifier modify = new CamelModifier(hydration, stamina);
                    modify.sandstormHydrate(camel);
                    modify.sandstormStamina(camel);
                }
                if (status == 10){
                    //CamelModifier modify = new CamelModifier(hydration, stamina);
                    modify.cactusFlower(camel);
                }
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
