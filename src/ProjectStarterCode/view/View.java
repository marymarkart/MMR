package ProjectStarterCode.view;

import ProjectStarterCode.controller.HitMessage;
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.controller.NewGameMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame gameFrame;
    private BlockingQueue<Message> queue;

    public static View init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new View(queue);
    }

    private View(BlockingQueue<Message> queue) {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        gameFrame = new JFrame();
        //JFrame frame = new JFrame();
        gameFrame.setLayout(new GridBagLayout());
        gameFrame.setTitle("Camel Game");
        GridBagConstraints c = new GridBagConstraints();
        gameFrame.setPreferredSize(new Dimension(500, 400));
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

        run.addActionListener(event -> {
            try {
                this.queue.put(new RunMessage()); // <--- adding Hit message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        walk.addActionListener(this);
        hydrate.addActionListener(this);
        rest.addActionListener(this);
        quit.addActionListener(this);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.ipady = 200;
        c.gridx = 0;
        c.gridy = 0;
        gameFrame.add(menu, c);

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
        gameFrame.add(stats, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 400;      //make this component tall
        c.weightx = 400.0;
        c.gridheight = 400;
        c.gridx = 2;
        c.gridy = 0;
        gameFrame.add(new GameBoard(),c);
        //frame.add(p, c);


        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);

        JFrame rules = new JFrame();
        rules.setLayout(new FlowLayout());
        rules.setPreferredSize(new Dimension(400, 200));
        rules.setTitle("Welcome to the Camel Game");
        JLabel welcome = new JLabel("");
        JLabel text = new JLabel("You are a camel who has escaped from bandits");
        JLabel text1 = new JLabel("You must run through the desert to escape them");
        JLabel text2 = new JLabel("You can run, but you will lose water(-2) and stamina(-1) and move forward 5-20 miles");
        JLabel text3 = new JLabel("You can walk, but you will also lose water(-1) and stamina(-1) and move forward 1-10 miles");
        JLabel text4 = new JLabel("You can hydrate or rest to restore health, but the enemy can still catch up to you");
        JLabel text5 = new JLabel("Win the game by escaping the bandits through 250miles of desert, and not running out of water and stamina");
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

        JButton newGame = new JButton("New Game");
        JButton hitButton = new JButton("hit");

//        newGame.addActionListener(event -> {
//            try {
//                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        hitButton.addActionListener(event -> {
//            try {
//                this.queue.put(new HitMessage()); // <--- adding Hit message to the queue
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // add everything and set layout and other standard JFrame settings
//        gameFrame.add(newGame);
//        gameFrame.add(hitButton);
        gameFrame.pack();
        gameFrame.setLayout(new FlowLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }


    public void change() {
        // TODO: do all the updates and repaint
        //gameFrame.repaint();
    }

    public void dispose() {
        // TODO: clear all the resources
        // for example, gameFrame.dispose();
    }
}
