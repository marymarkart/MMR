package ProjectStarterCode.model;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import ProjectStarterCode.view.StatsView;

import javax.swing.*;

public class Camel{
    int hydration;
    int stamina;
    int progress;
    int enemy;
    Image camelImg;
    Random rand = new Random();
    int number = 0;
    CamelIcon icon;

    public CamelIcon getIcon() {
        return icon;
    }


    public StatsView getsView() {
        return sView;
    }

    StatsView sView;
    ImageIcon oasisIcon = new ImageIcon("images/oasis3.png");
    ImageIcon sandstormIcon = new ImageIcon("images/sandstorm.gif");
    ImageIcon cactusIcon = new ImageIcon("images/cactusFlower.png");
    ImageIcon genieIcon = new ImageIcon("images/genie.png");


    public Camel() {
        this.hydration = 10;
        this.stamina = 10;
        this.progress = 0;
        this.enemy = -5;
        this.sView = new StatsView(hydration, stamina, progress, enemy);
        icon = new CamelIcon();
    }

    public int getHydration() {
        return hydration;
    }

    public int getEnemy(){
        return enemy;
    }

    public void enemyMoves(){
        this.enemy += 10;
    }

    public int run(){
        number = rand.nextInt(20) + 5;
        progress += number;
        hydration -= 2;
        stamina -= 2;
        enemyMoves();
        //camelIcon.moveCamelRun();
        updateValues(hydration, stamina, progress, enemy);
        return number;


    }

    public int walk(){
        number = rand.nextInt(10) + 1;
        progress += number;
        hydration -= 1;
        stamina -= 1;
        enemyMoves();
        updateValues(hydration, stamina, progress, enemy);
        return number;
    }

    public void hydrate(){
        this.hydration = 10;
        this.enemy += 5;
        updateValues(hydration, stamina, progress, enemy);
    }

    public void rest(){
        this.stamina = 10;
        this.enemy += 5;
        updateValues(hydration, stamina, progress, enemy);
    }


    public int getStamina() {
        return stamina;
    }

    public int getProgess(){
        return progress;
    }

    public int gameOverLose(){
        if (stamina <= 0 && hydration <= 0){
            System.out.println("You ran out of stamina and water");
            return 1;
        }
        if (stamina <= 0){
            System.out.println("You ran out of stamina");
            return 2;
        }
        if (hydration <= 0){
            System.out.println("You ran out of water");
            return 3;
        }
        if (enemy >= progress){
            System.out.println("The enemy caught you");
            return 4;
        }
        return 0;
    }

    public int gameOverWin(){
        if (progress >= 250 && stamina > 0 && hydration > 0 && progress > enemy){
            System.out.println("You win");
            return 1;
        }
        return 0;
    }
    public void changeIcon(Image i){
        this.camelImg = i;
    }

    public void restoreIcon(){
        icon.restoreImage();
    }

    public void findOasis() {
        System.out.print("You found an oasis");
        hydrate();
        JFrame oasis = new JFrame();
        oasis.setLayout(new FlowLayout());
        oasis.setPreferredSize(new Dimension(400, 250));
        JLabel winText = new JLabel("You found an oasis! You're hydration has been restored!");
        oasis.add(winText);
        oasis.add(new JLabel(oasisIcon));
        JButton ok = new JButton("OK");
        oasis.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oasis.dispose();
            }
        });
        oasis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oasis.pack();
        oasis.setVisible(true);
        oasis.setLocationRelativeTo(null);
    }


    public void sandstormHydrate() {
        System.out.println("You got caught in a sandstorm");
        this.hydration = getHydration()/2;
        JFrame sandstorm = new JFrame();
        sandstorm.setLayout(new FlowLayout());
        sandstorm.setPreferredSize(new Dimension(500, 200));
        JLabel winText = new JLabel("You got caught in a sandstorm. You're health and stamina have gone down!");
        sandstorm.add(winText);
        sandstorm.add(new JLabel(sandstormIcon));
        JButton ok = new JButton("OK");
        sandstorm.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sandstorm.dispose();
            }
        });
        sandstorm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sandstorm.pack();
        sandstorm.setVisible(true);
        sandstorm.setLocationRelativeTo(null);
    }

    public void sandstormStamina() {
        this.stamina = getStamina()/2;
    }

    public void cactusFlower() {
        System.out.println("You found a special cactus flower");
        rest();
        JFrame flower = new JFrame();
        flower.setLayout(new FlowLayout());
        flower.setPreferredSize(new Dimension(400, 250));
        JLabel winText = new JLabel("You found a Cactus Flower! You're stamina has been restored!");
        flower.add(winText);
        flower.add(new JLabel(cactusIcon));
        JButton ok = new JButton("OK");
        flower.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flower.dispose();
            }
        });
        flower.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flower.pack();
        flower.setVisible(true);
        flower.setLocationRelativeTo(null);

    }

    public void findGenie() {
        System.out.println("You found a special cactus flower");
        rest();
        hydrate();
        JFrame genie = new JFrame();
        genie.setLayout(new FlowLayout());
        genie.setPreferredSize(new Dimension(450, 200));
        JLabel winText = new JLabel("You found a Genie! You're stamina and health has been restored!");
        genie.add(winText);
        genie.add(new JLabel(genieIcon));
        JButton ok = new JButton("OK");
        genie.add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genie.dispose();
            }
        });
        genie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        genie.pack();
        genie.setVisible(true);
        genie.setLocationRelativeTo(null);
    }

    public Image getCamelImage(){
        camelImg = icon.still;
        return camelImg;
    }
    public void attach(StatsView sView) {
        this.sView = sView;
    }

    public void updateValues(int n1, int n2, int n3, int n4) {
        sView.updateStats(n1, n2, n3, n4);
    }


    private boolean roundStarted;
    private boolean roundOver;

    public boolean isRoundStarted() {
        return roundStarted;
    }

    public boolean isRoundOver() {
        return roundOver;
    }

    public int getX() {
        return icon.x;
    }
    public int getY() {
        return icon.y;
    }

}

