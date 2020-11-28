package ProjectStarterCode.model;

import javax.swing.*;
import java.awt.*;

public class CamelIcon extends JPanel {
    int x, dx, y, nx2;
    public Image still;
    ImageIcon camel1 = new ImageIcon("images/camel1.png");
    int v = 0;
    //Timer t = new Timer(5, this);

    public CamelIcon() {
        setFocusable(true);
        this.still = camel1.getImage();
        x = 150;
        //nx2 = 640;
        y = 265;
    }

    public void changeImage(ImageIcon i) {
        this.still = i.getImage();
    }

    public void restoreImage() {
        this.still = camel1.getImage();
    }

    public Image getImage() {
        return still;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(still, x, y, null);
    }
}
