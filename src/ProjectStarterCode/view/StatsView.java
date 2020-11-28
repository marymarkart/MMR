package ProjectStarterCode.view;

import com.sun.codemodel.internal.JLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class StatsView extends JPanel {
        int n1;
        int n2;
        int n3;
        int n4;
        int width;
        int height;
        int xCoord;
        int yCoord;
        Color color;
        int origWidth;
        boolean wantLabel;
        JLabel label;
        Rectangle2D rectangle;

        public StatsView(int n1, int n2, int n3, int n4){
            //initialize variables
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

//    public void RectangleComponent(int x, int y, Color color, boolean wantLabel)
//    {
//        width = 125;
//        height = 18;
//        xCoord = x;
//        yCoord = y;
//        this.color = color;
//        origWidth = width;
//        this.wantLabel = wantLabel;
//        if(wantLabel)
//        {
//            label = new JLabel(this.width + "/" + origWidth);
//            label.setLabelFor(this);
//        }
//        setBounds(xCoord, yCoord, width, height);
//        rectangle = new Rectangle2D.Float(xCoord, yCoord, width, height);
//    }
        @Override
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

            //Rectangle for n2
            g2.setColor(Color.GREEN);
            Rectangle rec2 = new Rectangle(x2, 55, n2*8, 7);
            g2.draw(rec2);
            g2.fill(rec2);

            //Rectangle for n3
            g2.setColor(Color.BLUE);
            Rectangle rec3 = new Rectangle(x3, 87, (int) (n3*0.3), 7);
            g2.draw(rec3);
            g2.fill(rec3);

            //Rectangle for n3

            g2.setColor(Color.RED);
            Rectangle rec4 = new Rectangle(x4, 119, (int) (n4*0.3), 7);
            g2.draw(rec4);
            g2.fill(rec4);

        }

    public int getn1() {
            return n1;
    }
    public int getn2() {
        return n2;
    }
    public int getn3() {
        return n3;
    }
    public int getn4() {
        return n4;
    }
}

