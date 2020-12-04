package CamelGame.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a Genie event where the player comes across a genie
 * @author MMR
 *
 */
public class Genie implements CamelEvent{
    ImageIcon genieIcon = new ImageIcon("images/genie.png");
    @Override
    /**
     * Implemented from CamelEvent interface, which updates hydration and stamina and creates a pop-up image
     */
    public void event(Camel camel) {
        camel.hydrate();
        camel.rest();
        JFrame genie = new JFrame();
        genie.setLayout(new FlowLayout());
        genie.setPreferredSize(new Dimension(450, 200));
        JLabel genieText = new JLabel("You found a genie! You're hydration and stamina have been restored!");
        genie.add(genieText);
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
}