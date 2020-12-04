package CamelGame.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sandstorm implements CamelEvent {
    ImageIcon sandstormIcon = new ImageIcon("images/sandstorm.gif");
    @Override
    public void event(Camel camel) {
        camel.hydration = camel.getHydration()/2;
        camel.stamina = camel.getStamina()/2;
        JFrame sandstorm = new JFrame();
        sandstorm.setLayout(new FlowLayout());
        sandstorm.setPreferredSize(new Dimension(500, 200));
        JLabel sandText = new JLabel("You got caught in a sandstorm. You're health and stamina have gone down!");
        sandstorm.add(sandText);
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
}

