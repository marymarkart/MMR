package CamelGame.view;

import javax.swing.*;
import java.awt.*;

/**
 * Creates JPanel with a JFrame showing the various status bars
 * @author MMR
 *
 */
public class StatsView extends JPanel {
        int n1;
        int n2;
        int n3;
        int n4;

        /**
         * Constructor that creates a StatsView object with initial status variables
         * @param n1 represents hydration
         * @param n2 represents stamina
         * @param n3 represents player progress
         * @param n4 represents enemy progress
         */
        public StatsView(int n1, int n2, int n3, int n4){
            //initialize variables
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
            this.n4 = n4;
        }

        /**
         * Updates StatsView values and draw the status bars with the updated values
         * @param n1 represents hydration
         * @param n2 represents stamina
         * @param n3 represents player progress
         * @param n4 represents enemy progress
         */
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
        /**
         * Draws the status bars
         */
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            //Stick values to bottom of JFrame
            int x1 = 10;
            int x2 = 10;
            int x3 = 10;
            int x4 = 10;

            //Rectangle for n1
            g2.setColor(Color.CYAN);
            Rectangle rec1 = new Rectangle(x1, 23, n1*8, 7);
            g2.draw(rec1);
            g2.fill(rec1);

            g2.setColor(Color.darkGray);
            Rectangle recFullH = new Rectangle(90, 23, 2, 7 );
            g2.draw(recFullH);
            g2.fill(recFullH);

            //Rectangle for n2
            g2.setColor(Color.GREEN);
            Rectangle rec2 = new Rectangle(x2, 55, n2*8, 7);
            g2.draw(rec2);
            g2.fill(rec2);

            //Rectangle for full stamina
            g2.setColor(Color.darkGray);
            Rectangle recFullS = new Rectangle(90, 55, 2, 7 );
            g2.draw(recFullS);
            g2.fill(recFullS);

            //Rectangle for n3
            g2.setColor(Color.BLUE);
            Rectangle rec3 = new Rectangle(x3, 87, (int) (n3*0.32), 7);
            g2.draw(rec3);
            g2.fill(rec3);

            //Rectangle for winning distance
            g2.setColor(Color.darkGray);
            Rectangle recWin = new Rectangle(90, 87, 2, 7 );
            g2.draw(recWin);
            g2.fill(recWin);


            //Rectangle for n4
            g2.setColor(Color.RED);
            Rectangle rec4 = new Rectangle((int)(n4*0.32+10 - 2), 87, 2, 7);
            g2.draw(rec4);
            g2.fill(rec4);

        }
}
