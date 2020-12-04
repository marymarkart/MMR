package CamelGame.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oasis implements CamelEvent{
    ImageIcon oasisIcon = new ImageIcon("images/oasis3.png");

    @Override
    public void event(Camel camel) {
        camel.hydrate();
        JFrame oasis = new JFrame();
        oasis.setLayout(new FlowLayout());
        oasis.setPreferredSize(new Dimension(400, 250));
        JLabel oasisText = new JLabel("You found an oasis! You're hydration has been restored!");
        oasis.add(oasisText);
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
}
