package CamelGame.model;

import javax.swing.*;
import java.awt.*;

/**
 * Controls the state of the camel image
 * @author MMR
 *
 */
public class CamelIcon extends JPanel {
    int x, y;
    public Image still;
    ImageIcon camel1 = new ImageIcon("images/camel1.png");

    /**
     * Constructor that creates a CamelIcon object with initial coordinates
     */
    public CamelIcon() {
        setFocusable(true);
        this.still = camel1.getImage();
        x = 150;
        y = 265;
    }

    /**
     * Draws image
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(still, x, y, null);
    }
}