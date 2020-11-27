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
    Random rand = new Random();
    int number = 0;
    StatsView sView;
    ImageIcon oasisIcon = new ImageIcon("images/oasis3.png");
    ImageIcon sandstormIcon = new ImageIcon("images/sandstorm.gif");
    ImageIcon cactusIcon = new ImageIcon("images/cactusFlower.png");


    public Camel() {
        this.hydration = 10;
        this.stamina = 10;
        this.progress = 0;
        this.enemy = -5;
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

    public boolean gameOverLose(){
        if (stamina <= 0){
            System.out.println("You ran out of stamina");
            return true;
        }
        if (hydration <= 0){
            System.out.println("You ran out of water");
            return true;
        }
        if (enemy >= progress){
            System.out.println("The enemy caught you");
            return true;
        }
        return false;
    }

    public boolean gameOverWin(){
        if (progress >= 250){
            System.out.println("You win");
            return true;
        }
        return false;
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
}
class CamelIcon extends JPanel implements ActionListener {
    int x, dx, y, nx2;
    public Image still;
    int v = 0;
    Timer t = new Timer(5, this);

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

