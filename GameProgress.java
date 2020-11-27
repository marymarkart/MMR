import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameProgress extends JFrame implements ActionListener {
    GameSystem game;
    JButton run = new JButton("Run");
    JButton walk = new JButton("Walk");
    JButton hydrate = new JButton("Hydrate");
    JButton rest = new JButton("Rest");
    JButton quit = new JButton("Quit");
    String state;
    Camel camel;
    StatsView stats;
    CamelIcon p =new CamelIcon();
    String win = "YOU WIN!";
    String dehydrate = "You have run out of water! You Lose!";
    String lostStamina = "You have run out of stamina! You lose!";
    String both = "You have run out of water and stamina! You lose!";
    String enemyWins = "The enemy has caught up to you! You lose!";


    public GameProgress(){
    }

    public GameProgress(GameSystem game, String state, Camel camel, StatsView stats) {
        this.state = state;
        this.game = game;
        this.camel = camel;
        this.stats = stats;
        run();
    }

    public void run(){
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setTitle("Camel Game");
        GridBagConstraints c = new GridBagConstraints();
        frame.setPreferredSize(new Dimension(500, 400));
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5,1));
        menu.setPreferredSize(new Dimension(100, 100));



        menu.add(run);
        menu.add(walk);
        menu.add(hydrate);
        menu.add(rest);
        menu.add(quit);

        run.addActionListener(this);
        walk.addActionListener(this);
        hydrate.addActionListener(this);
        rest.addActionListener(this);
        quit.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.ipady = 200;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(menu, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        JPanel statsView;
        statsView = stats;
        statsView.setLayout(new FlowLayout());
        //statsView.setPreferredSize(new Dimension(100, 100));
        statsView.setVisible(true);

//        JPanel statNum = new JPanel();
//        statNum.setLayout(new GridLayout(4,1));
//        JLabel hyd = new JLabel("Hydration " + camel.getHydration() +"/10" );
//        JLabel sta = new JLabel("Stamina " + camel.getStamina() +"/10" );
//        JLabel pro = new JLabel("Progress " + camel.getProgess() +"/250" );
//        JLabel enm = new JLabel("Enemy " + camel.getEnemy() +"/250" );
//        statNum.add(hyd);
//        statNum.add(sta);
//        statNum.add(pro);
//        statNum.add(enm);
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 400;
//        c.weightx = 2;
//        c.gridx = 1;
//        c.gridy = 0;
//        frame.add(menu, c);

        c.ipady = 200;
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(stats, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 400;      //make this component tall
        c.weightx = 400.0;
        c.gridheight = 400;
        c.gridx = 2;
        c.gridy = 0;
        frame.add(new GameBoard(),c);
        //frame.add(p, c);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JFrame rules = new JFrame();
        rules.setLayout(new FlowLayout());
        rules.setPreferredSize(new Dimension(800, 200));
        rules.setTitle("Welcome to the Camel Game!");
        JLabel welcome = new JLabel("");
        JLabel text = new JLabel("You are a camel who has escaped from bandits.");
        JLabel text1 = new JLabel("You must survive through the desert to escape them.");
        JLabel text2 = new JLabel("You can run 5-20 miles, but you will lose hydration(-2) and stamina(-2).");
        JLabel text3 = new JLabel("You can walk 1-10 miles, but you will still lose hydration(-1) and stamina(-1).");
        JLabel text4 = new JLabel("You can hydrate or rest to restore yourself, but the bandits are always on the move.");
        JLabel text5 = new JLabel("Win the game by escaping the bandits through 250 miles of desert, and not running out of water or stamina.");
        JLabel text6 = new JLabel("Good Luck!");
        rules.add(welcome);
        rules.add(text);
        rules.add(text1);
        rules.add(text2);
        rules.add(text3);
        rules.add(text4);
        rules.add(text5);
        rules.add(text6);
        JButton ok = new JButton("Let's Play!");
        rules.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rules.dispose();
            }
        });
        rules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rules.pack();
        rules.setVisible(true);
        rules.setLocationRelativeTo(null);


    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {
            this.state = "run";
            game.setTheState(state);
            game.stateMachine();
            Timer time = new Timer(5, this);
            for (int k = 0; k < 13; ++k){
                //TODO
            }
            time.start();

            p.repaint();
            if (game.win == true){
                gameMessage(win);
            }
            if (game.lose == true) {
                if (camel.getHydration() == 0 && camel.getStamina() == 0) {
                    gameMessage(both);
                } else if (camel.getHydration() == 0) {
                    gameMessage(dehydrate);
                } else if (camel.getStamina() == 0) {
                    gameMessage(lostStamina);
                } else
                    gameMessage(enemyWins);
            }
        }
        if (e.getSource() == walk) {
            this.state = "walk";
            game.setTheState(state);
            game.stateMachine();
            if (game.win == true){
                gameMessage(win);
            }
            if (game.lose == true) {
                if (camel.getHydration() == 0 && camel.getStamina() == 0) {
                    gameMessage(both);
                } else if (camel.getHydration() == 0) {
                    gameMessage(dehydrate);
                } else if (camel.getStamina() == 0) {
                    gameMessage(lostStamina);
                } else
                    gameMessage(enemyWins);
            }
        }
        if (e.getSource() == hydrate) {
            this.state = "hydrate";
            game.setTheState(state);
            game.stateMachine();
            if (game.win == true){
                gameMessage(win);
            }
            if (game.lose == true) {
                if (camel.getHydration() == 0 && camel.getStamina() == 0) {
                    gameMessage(both);
                } else if (camel.getHydration() == 0) {
                    gameMessage(dehydrate);
                } else if (camel.getStamina() == 0) {
                    gameMessage(lostStamina);
                } else
                    gameMessage(enemyWins);
            }
        }
        if (e.getSource() == rest) {
            this.state = "rest";
            game.setTheState(state);
            game.stateMachine();
            if (game.win == true){
                gameMessage(win);
            }
            if (game.lose == true) {
                if (camel.getHydration() == 0 && camel.getStamina() == 0) {
                    gameMessage(both);
                } else if (camel.getHydration() == 0) {
                    gameMessage(dehydrate);
                } else if (camel.getStamina() == 0) {
                    gameMessage(lostStamina);
                } else
                    gameMessage(enemyWins);
            }
        }
        if (e.getSource() == quit) {
            this.state = "quit";
            game.setTheState(state);
            game.stateMachine();
        }
    }

    public void gameMessage (String message){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(400, 100));
        JLabel text = new JLabel(message);
        frame.add(text);
        JButton ok = new JButton("End Game");
        frame.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}