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
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(640, 640));
        frame.add(new GameBoard(), BorderLayout.CENTER);
        frame.setTitle("Camel Game");

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

        frame.add(menu, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JPanel statsView;
        statsView = stats;
        statsView.setLayout(new FlowLayout());
        statsView.setPreferredSize(new Dimension(100, 100));
        statsView.setVisible(true);

        frame.add(stats, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == run) {
            this.state = "run";
            game.setTheState(state);
            game.stateMachine();
            JPanel display = new JPanel();
            display.setLayout(new FlowLayout());
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
