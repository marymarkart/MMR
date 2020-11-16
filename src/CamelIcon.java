import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CamelIcon extends JPanel {
    int x, dx, y, nx2;
    public Image still;

    public CamelIcon(){
    ImageIcon i = new ImageIcon("resources/camel.png");
    still = i.getImage();
    x = 10;
    nx2 = 640;
    y =172;
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
