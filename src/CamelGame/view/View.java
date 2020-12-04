package ProjectStarterCode.view;

import ProjectStarterCode.controller.*;
import ProjectStarterCode.model.Camel;
import ProjectStarterCode.model.CamelIcon;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame{
    private static JFrame frame = null;
    private BlockingQueue<Message> queue;
    StatsView stats;
    public GameBoard gameBoard;

    public static View init(BlockingQueue<Message> queue, Camel camel) {
        // Create object of type view
        frame = new JFrame();
        return new View(queue, camel);
    }

    private View(BlockingQueue<Message> queue, Camel camel) {
        this.queue = queue;
        // TODO:
        // you should initialize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        //frame = new JFrame();
        this.frame.setLayout(new GridBagLayout());
        this.frame.setTitle("Camel Game");
        GridBagConstraints c = new GridBagConstraints();
        this.frame.setPreferredSize(new Dimension(500, 400));


        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5,1));
        menu.setPreferredSize(new Dimension(100, 100));
        JButton run = new JButton("Run");
        JButton walk = new JButton("Walk");
        JButton hydrate = new JButton("Hydrate");
        JButton rest = new JButton("Rest");
        JButton quit = new JButton("Quit");
        menu.add(run);
        menu.add(walk);
        menu.add(hydrate);
        menu.add(rest);
        menu.add(quit);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.ipady = 100;
        c.gridx = 0;
        c.gridy = 0;
        this.frame.add(menu, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        JPanel statsView;
        stats = camel.getsView();
        statsView = stats;
        statsView.setLayout(new GridLayout(8,2));
        statsView.setSize(new Dimension(150,150));
        statsView.setVisible(true);
        JLabel hyd = new JLabel("Hydration");
        JLabel spacer = new JLabel("");
        JLabel stam = new JLabel("Stamina");
        JLabel spacer2 = new JLabel("");
        JLabel prog = new JLabel("Progress");
        prog.setForeground(Color.blue);
        JLabel spacer3 = new JLabel("");
        JLabel enem = new JLabel("Bandits");
        enem.setForeground(Color.red);
        statsView.add(hyd);
        statsView.add(spacer);
        statsView.add(stam);
        statsView.add(spacer2);
        statsView.add(prog);
        statsView.add(spacer3);
        statsView.add(enem);
        c.ipady = 5;
        c.weightx = 24;
        c.gridx = 0;
        c.gridy = 1;
        this.frame.add(statsView, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 400;      //make this component tall
        c.weightx = 400.0;
        c.gridheight = 400;
        c.gridx = 2;
        c.gridy = 0;
        gameBoard = new GameBoard(camel);
        this.frame.add(gameBoard,c);

        JPanel camelIcon = new JPanel();
        this.frame.add(new CamelIcon());

        run.addActionListener(event -> {
            try {
                this.queue.put(new RunMessage()); // <--- adding Run message to the queue
                //change(frame, camel);
                change(frame, camel, statsView, gameBoard );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        walk.addActionListener(event -> {
            try {
                this.queue.put(new WalkMessage()); // <--- adding Walk message to the queue
                change(frame, camel, statsView, gameBoard );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        hydrate.addActionListener(event -> {
            try {
                this.queue.put(new HydrateMessage()); // <--- adding Hydrate message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        rest.addActionListener(event -> {
            try {
                this.queue.put(new RestMessage()); // <--- adding Rest message to the queue
                change(frame, camel, statsView, gameBoard );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        quit.addActionListener(event -> {
            try {
                this.queue.put(new QuitMessage()); // <--- adding Quit message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);



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
        ok.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding Walk message to the queue
                rules.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        rules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rules.pack();
        rules.setVisible(true);
        rules.setLocationRelativeTo(null);
    }


    public void change(JFrame frame, Camel camel, JPanel stats, GameBoard gameBoard) {
        camel.updateValues(camel.getHydration(), camel.getStamina(), camel.getProgress(), camel.getEnemy());
        frame.repaint();
        stats.repaint();
        gameBoard.repaint();
    }

    public void dispose() {
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }
}
class GameBoard extends JLayeredPane {
    public Image image;
    public Image camelImage;
    Camel camel;
    JLabel camelLabel = null;
    JLabel backgroundLabel = null;

    public GameBoard(Camel camel) {
        setFocusable(true);
        this.camel = camel;
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (backgroundLabel == null){
            ImageIcon i = new ImageIcon("images/background2.jpg");
            backgroundLabel = new JLabel(i);
            backgroundLabel.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
            this.add(backgroundLabel, Integer.valueOf(1));
        }
        if(camelLabel == null){
            camelLabel = new JLabel(camel.getCamelImage());
            camelLabel.setBounds(camel.getX(), camel.getY(), camel.getCamelImage().getIconWidth(), camel.getCamelImage().getIconHeight());
            this.add(camelLabel,Integer.valueOf(2));
        }
        else {
            camelLabel.setIcon(camel.getCamelImage());
        }
        //g2d.drawImage(camel.getCamelImage(), camel.getX(), camel.getY(), null);
    }
}
