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
    String camelMovement = "";

    public GameBoard(){
        time = new Timer(5, this);
        time.start();
        time.addActionListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("images/background2.jpg");
        image = i.getImage();

    }

    public void actionPerformed(ActionEvent e){
        if (camelMovement.equals("run")){
            for (int i = 0; i < 26; i++){
                p.getNextCamelRun();
                repaint();
            }
            p.camelReset();
        }
        p.move();
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
    }

    private class AL extends GameProgress {
        String camelMovement = "";

        public void keyReleased(ActionEvent e) {
            if (e.getSource() == run){
                camelMovement = "run";
                p.move();
            }
        }

//        @Override
//        public void keyPressed(KeyEvent e) {
//            super.keyPressed(e);
//        }
    }
}


