package ProjectStarterCode.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flower implements CamelEvent{
    ImageIcon cactusIcon = new ImageIcon("images/cactusFlower.png");
    @Override
    public void event(Camel camel) {
        System.out.println("You found a special cactus flower");
        camel.rest();
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
}
