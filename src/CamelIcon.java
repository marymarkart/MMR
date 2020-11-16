import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CamelIcon extends JPanel {
    int x, dx, y, nx2;
    public Image still;

    public CamelIcon(){
        ImageIcon camel1 = new ImageIcon("images/camel1.png");
        ImageIcon camel2 = new ImageIcon("images/camel2.png");
        ImageIcon camel3 = new ImageIcon("images/camel3.png");
        ImageIcon camel4 = new ImageIcon("images/camel4.png");
        ImageIcon camel5 = new ImageIcon("images/camel5.png");
        ImageIcon camel6 = new ImageIcon("images/camel6.png");
        ImageIcon camel7 = new ImageIcon("images/camel7.png");
        ImageIcon camel8 = new ImageIcon("images/camel8.png");
        ImageIcon camel9 = new ImageIcon("images/camel9.png");
        ImageIcon camel10 = new ImageIcon("images/camel10.png");
        ImageIcon camel11 = new ImageIcon("images/camel11.png");
        ImageIcon camel12 = new ImageIcon("images/camel12.png");
        ImageIcon camel13 = new ImageIcon("images/camel13.png");
        ImageIcon camelrest1 = new ImageIcon("images/camelrest1.png");
        ImageIcon camelrest2 = new ImageIcon("images/camelrest2.png");
        ImageIcon camelrest = new ImageIcon("images/camelrest3.png");
        still = camel1.getImage();
        x = 20;
        nx2 = 640;
        y =260;
}

    public void move(){
        x = x + dx;
        nx2 = nx2 + dx;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Image getImage(){
        return still;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            dx = 1;
        }
        if (key == KeyEvent.VK_RIGHT)
            dx = 1;
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dx = 0;
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
    }
}
