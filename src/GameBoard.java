import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel implements ActionListener {
    CamelIcon p = new CamelIcon();
    public Image image;
    Timer time;

    public GameBoard(){
        //addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("images/background2.jpg");
        image = i.getImage();
        //time = new Timer(5, this);
        //time.start();
    }

    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, p.getX(), 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
    }

    private class AL extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
}


