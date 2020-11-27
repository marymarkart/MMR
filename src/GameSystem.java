//import ProjectStarterCode.view.StatsView;
//
//public class GameSystem {
//    static String state = "";
//    Camel camel = new Camel();
//    boolean lose = false;
//    boolean win = false;
//    public static void main(String[] args) {
//        GameSystem game = new GameSystem();
//        StatsView stats = new StatsView(game.camel.getHydration(), game.camel.getStamina(),
//                game.camel.getProgess(), game.camel.getEnemy());
//        game.camel.attach(stats);
//        GameProgress gp = new GameProgress(game, state, game.camel, stats);
//
//
//    }
//    public void stateMachine() {
//    int status = 0;
//    if (state.equals("run")){
//        status = camel.run();
//        System.out.println(status);
//        lose = camel.gameOverLose();
//        win = camel.gameOverWin();
//        if (status == 17){
//            camel.findOasis();
//            camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
//        }
//        if (status == 13){
//            camel.sandstormHydrate();
//            camel.sandstormStamina();
//            camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
//        }
//        if (status == 10){
//            camel.cactusFlower();
//            camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgess(), camel.getEnemy());
//        }
//        System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
//                camel.getProgess() + " " + camel.getEnemy());
//    }
//    else if (state.equals("walk")){
//            camel.walk();
//            lose = camel.gameOverLose();
//            win = camel.gameOverWin();
//            System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
//                    camel.getProgess() + " " + camel.getEnemy());
//        }
//        else if (state.equals("hydrate")){
//            camel.hydrate();
//            lose = camel.gameOverLose();
//            win = camel.gameOverWin();
//            System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
//                    camel.getProgess() + " " + camel.getEnemy());
//
//        }
//        else if (state.equals("rest")){
//            camel.rest();
//            lose = camel.gameOverLose();
//            win = camel.gameOverWin();
//            System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
//                    camel.getProgess() + " " + camel.getEnemy());
//        }
//        else if (state.equals("quit")) {
//            System.exit(0);
//            System.out.println("Quit Game");
//        }
//    }
//
//    public void setTheState(String state) {
//        this.state = state;
//    }
//
//}
