import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CamelIcon extends JPanel {
    int x, dx, y, nx2;
    public Image still;
    int v = 0;
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
    ImageIcon[] runArr = {camel1, camel2, camel3, camel4, camel5, camel6, camel7, camel8,
    camel9,camel10, camel11, camel12, camel13};

    public CamelIcon(){
        still = camel1.getImage();
        x = 20;
        nx2 = 640;
        y =260;
}

    public void move(){
        x = x + dx;
        nx2 = nx2 + dx;
    }
    public void moveCamelRun(){
        for (int i = 1; i < runArr.length; i++){
            this.still = runArr[i].getImage();
            repaint();
        }
        for (int j = 1; j < runArr.length; j++){
            this.still = runArr[j].getImage();
            repaint();
        }
        this.still = runArr[0].getImage();
        repaint();
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

    public void runOption(){

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

    public void getNextCamelRun() {
        still = runArr[++v].getImage();
        if (v == 13){
            v = 0;
        }
    }

    public void camelReset() {
        still = camel1.getImage();
    }
}
