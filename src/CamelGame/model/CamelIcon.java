package CamelGame.model;

import javax.swing.*;
import java.awt.*;

public class CamelIcon extends JPanel {
    int x, y;
    public Image still;
    ImageIcon camel1 = new ImageIcon("images/camel1.png");

    public CamelIcon() {
        setFocusable(true);
        this.still = camel1.getImage();
        x = 150;
        y = 265;
    }


    public void restoreImage() {
        this.still = camel1.getImage();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(still, x, y, null);
    }
}
