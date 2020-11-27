import javax.swing.*;
import java.awt.*;

public class StatsView extends JPanel {
        int n1;
        int n2;
        int n3;
        int n4;
        JLabel hydrationLabel = new JLabel("H");
        JLabel staminaLabel = new JLabel("S");
        JLabel progressLabel = new JLabel("P");
        JLabel enemyLabel = new JLabel("E");
        

        public StatsView(int n1, int n2, int n3, int n4){
            //initialize variables
        	//setLayout(null);
        	hydrationLabel.setLocation(100,100);
        	add(hydrationLabel);
            add(staminaLabel);
            add(progressLabel);
            add(enemyLabel);
        	this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
            this.n4 = n4;
        }

        public void updateStats(int n1, int n2, int n3, int n4){
            //update values
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
            this.n4 = n4;
            //repaint graph
            repaint();
        }

        @Override
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            //Stick values to bottom of JFrame
            //int x1 = 10;
            //int x2 = 10;
            //int x3 = 10;
            //int x4 = 10;
            int length = 120;
            //add(hydrationLabel);
            //hydrationLabel.setLocation(10,10);

            //Rectangle for n1

            g2.setColor(Color.CYAN);
            Rectangle rec1 = new Rectangle(27, 100 - (n1*10), 5, length - (100 - (n1*10)));
            g2.draw(rec1);
            g2.fill(rec1);

            //Rectangle for n2

            g2.setColor(Color.GREEN);
            Rectangle rec2 = new Rectangle(40, 100 - (n2*10), 5, length - (100 - (n2*10)));
            g2.draw(rec2);
            g2.fill(rec2);

            //Rectangle for n3
            g2.setColor(Color.BLUE);
            Rectangle rec3 = new Rectangle(52, 100 - ((int) (n3*0.4)), 5, length - 100 - ((int) (n3*0.4)));
            g2.draw(rec3);
            g2.fill(rec3);

            //Rectangle for n4

            g2.setColor(Color.RED);
            Rectangle rec4 = new Rectangle(65, 100 - ((int) (n4*0.4)), 5, length - 100 - ((int) (n4*0.4)));
            g2.draw(rec4);
            g2.fill(rec4);
            
            //finish line (for reference)
            
            g2.setColor(Color.BLACK);
            Rectangle rec5 = new Rectangle(26, 120, 44, 1);
            g2.draw(rec5);
            g2.fill(rec5);

        }
}