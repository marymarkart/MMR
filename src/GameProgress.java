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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {
            this.state = "run";
            game.setTheState(state);
            game.stateMachine();
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
}
