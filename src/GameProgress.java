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
        frame.setPreferredSize(new Dimension(700, 400));
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


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    public void winGame(){
        JFrame win = new JFrame();
        win.setLayout(new FlowLayout());
        win.setPreferredSize(new Dimension(100, 100));
        JLabel winText = new JLabel("YOU WIN!");
        win.add(winText);
        JButton ok = new JButton("End Game");
        win.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);
        win.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {
            this.state = "run";
            game.setTheState(state);
            game.stateMachine();
            if (game.win == true){
                winGame();
            }
            if (game.lose == true) {
                if (camel.getHydration() == 0 && camel.getStamina() == 0) {
                    loseGameBoth();
                } else if (camel.getHydration() == 0) {
                    loseGameHydration();
                } else if (camel.getStamina() == 0) {
                    loseGameStamina();
                } else
                    loseGameEnemy();
            }

            //moveCamelRun();
            //JPanel display = new JPanel();
            //display.setLayout(new FlowLayout());
        }
        if (e.getSource() == walk) {
            this.state = "walk";
            game.setTheState(state);
            game.stateMachine();
        }
        if (e.getSource() == hydrate) {
            this.state = "hydrate";
            game.setTheState(state);
            game.stateMachine();
        }
        if (e.getSource() == rest) {
            this.state = "rest";
            game.setTheState(state);
            game.stateMachine();
        }
        if (e.getSource() == quit) {
            this.state = "quit";
            game.setTheState(state);
            game.stateMachine();
        }
    }

    private void loseGameBoth() {
        JFrame lose1 = new JFrame();
        lose1.setLayout(new FlowLayout());
        lose1.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You have run out of water and stamina! You lose!");
        lose1.add(winText);
        JButton ok = new JButton("End Game");
        lose1.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lose1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lose1.pack();
        lose1.setVisible(true);
        lose1.setLocationRelativeTo(null);
    }

    private void loseGameHydration() {
        JFrame lose2 = new JFrame();
        lose2.setLayout(new FlowLayout());
        lose2.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You have run out of water! You Lose!");
        lose2.add(winText);
        JButton ok = new JButton("End Game");
        lose2.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lose2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lose2.pack();
        lose2.setVisible(true);
        lose2.setLocationRelativeTo(null);
    }
    private void loseGameStamina() {
        JFrame lose3 = new JFrame();
        lose3.setLayout(new FlowLayout());
        lose3.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You have run out of stamina! You lose!");
        lose3.add(winText);
        JButton ok = new JButton("End Game");
        lose3.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lose3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lose3.pack();
        lose3.setVisible(true);
        lose3.setLocationRelativeTo(null);
    }
    private void loseGameEnemy() {
        JFrame lose4 = new JFrame();
        lose4.setLayout(new FlowLayout());
        lose4.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("The enemy has caught up to you! You lose!");
        lose4.add(winText);
        JButton ok = new JButton("End Game");
        lose4.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lose4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lose4.pack();
        lose4.setVisible(true);
        lose4.setLocationRelativeTo(null);
    }
}
