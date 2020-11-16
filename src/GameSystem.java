public class GameSystem {
    static String state = "";
    Camel camel = new Camel();
    boolean lose = false;
    boolean win = false;
    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        StatsView stats = new StatsView(game.camel.getHydration(), game.camel.getStamina(),
                game.camel.getProgess(), game.camel.getEnemy());
        game.camel.attach(stats);
        GameProgress gp = new GameProgress(game, state, game.camel, stats);

    }
    public void stateMachine() {
        int status = 0;
        CamelModifier modify = new CamelModifier();
        if (state.equals("run")){
            status = camel.run();
            lose = camel.gameOverLose();
            win = camel.gameOverWin();
            if (status <= 17 && status > 13){
                modify.findOasis(camel);
            }
            if (status == 13){
                modify.sandstormHydrate(camel);
                modify.sandstormStamina(camel);
            }
            if (status == 10){
                modify.cactusFlower(camel);
            }
            System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
                    camel.getProgess() + " " + camel.getEnemy());
        }
        else if (state.equals("walk")){
                camel.walk();
                lose = camel.gameOverLose();
                win = camel.gameOverWin();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
                        camel.getProgess() + " " + camel.getEnemy());
            }
            else if (state.equals("hydrate")){
                camel.hydrate();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
                        camel.getProgess() + " " + camel.getEnemy());

            }
            else if (state.equals("rest")){
                camel.rest();
                System.out.println(camel.getHydration()+ " "+ camel.getStamina()+ " "+
                        camel.getProgess() + " " + camel.getEnemy());
            }
            else if (state.equals("quit")) {
                System.out.println("Quit Game");
            }
    }

    public void setTheState(String state) {
        this.state = state;
    }

}
