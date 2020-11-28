package ProjectStarterCode.view;

import ProjectStarterCode.controller.*;
import ProjectStarterCode.model.Camel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame{
    private JFrame frame;
    private BlockingQueue<Message> queue;
    StatsView stats;
    JButton run = new JButton("Run");
    JButton walk = new JButton("Walk");
    JButton hydrate = new JButton("Hydrate");
    JButton rest = new JButton("Rest");
    JButton quit = new JButton("Quit");

    public static View init(BlockingQueue<Message> queue, Camel camel) {
        // Create object of type view
        return new View(queue, camel);
    }

    private View(BlockingQueue<Message> queue, Camel camel) {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setTitle("Camel Game");
        GridBagConstraints c = new GridBagConstraints();
        frame.setPreferredSize(new Dimension(500, 400));


        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5,1));
        menu.setPreferredSize(new Dimension(100, 100));
        run.addActionListener(event -> {
            try {
                this.queue.put(new RunMessage()); // <--- adding Run message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        walk.addActionListener(event -> {
            try {
                this.queue.put(new WalkMessage()); // <--- adding Walk message to the queue
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
        menu.add(run);
        menu.add(walk);
        menu.add(hydrate);
        menu.add(rest);
        menu.add(quit);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.ipady = 200;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(menu, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        JPanel statsView;
        stats = camel.getsView();
        statsView = stats;
        statsView.setLayout(new FlowLayout());
        statsView.setVisible(true);

        c.ipady = 200;
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(statsView, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 400;      //make this component tall
        c.weightx = 400.0;
        c.gridheight = 400;
        c.gridx = 2;
        c.gridy = 0;
        frame.add(new GameBoard(camel),c);


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

        //JButton newGame = new JButton("New Game");
        //JButton hitButton = new JButton("hit");

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
    }


    public void change() {
        // TODO: do all the updates and repaint
        frame.repaint();
    }

    public void dispose() {
        // TODO: clear all the resources
        // for example, gameFrame.dispose();
    }
}
class GameBoard extends JPanel {
    public Image image;
    public Image camelImage;
    Camel camel;

    public GameBoard(Camel camel) {
        setFocusable(true);
        ImageIcon i = new ImageIcon("images/background2.jpg");
        image = i.getImage();
        camelImage = camel.getCamelImage();
        this.camel = camel;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, 0, 0, null);
        g2d.drawImage(camelImage, camel.getX(), camel.getY(), null);
    }
}
