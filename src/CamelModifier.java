import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CamelModifier extends Camel {
//    Camel camel = new Camel();
    int hydration;
    int stamina;

    public CamelModifier() {
        this.stamina = stamina;
        this.hydration = hydration;
    }


    public void findOasis(Camel camel) {
        System.out.print("You found an oasis");
        camel.hydrate();
        JFrame oasis = new JFrame();
        oasis.setLayout(new FlowLayout());
        oasis.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You found an oasis! You're hydration has been restored!");
        oasis.add(winText);
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


    public void sandstormHydrate(Camel camel) {
        System.out.println("You got caught in a sandstorm");
        camel.hydration = camel.getHydration()/2;
        JFrame sandstorm = new JFrame();
        sandstorm.setLayout(new FlowLayout());
        sandstorm.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You got caught in a sandstorm. You're health and stamina have gone down!");
        sandstorm.add(winText);
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

    public void sandstormStamina(Camel camel) {
        camel.stamina = camel.getStamina()/2;
    }

    public void cactusFlower(Camel camel) {
        System.out.println("You found a special cactus flower");
        camel.rest();
        JFrame flower = new JFrame();
        flower.setLayout(new FlowLayout());
        flower.setPreferredSize(new Dimension(400, 100));
        JLabel winText = new JLabel("You found a Cactus Flower! You're stamina has been restored!");
        flower.add(winText);
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
}
