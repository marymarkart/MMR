import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    //GameSystem game = new GameSystem();
    JButton run = new JButton("Run");
    JButton walk = new JButton("Walk");
    JButton hydrate = new JButton("Hydrate");
    JButton rest = new JButton("Rest");
    JButton quit = new JButton("Quit");

    public Menu(){
        JPanel menu = new JPanel();
        menu.setSize(100,100);
        menu.setLayout(new GridLayout(5,1));
        JButton run = new JButton("Run");
        JButton walk = new JButton("Walk");
        JButton hydrate = new JButton("Hydrate");
        JButton rest = new JButton("Rest");
        JButton quit = new JButton("Quit");

        menu.add(run);
        menu.add(walk);
        menu.add(hydrate);
        menu.add(rest);
        menu.add(quit);

     //   run.addActionListener(this);
       // walk.addActionListener(this);
       // hydrate.addActionListener(this);
        //rest.addActionListener(this);
        //quit.addActionListener(this);


        }
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == run) {
//                game.setState("run");
//            }
//            if (e.getSource() == walk) {
//                game.setState("walk");
//            }
//            if (e.getSource() == hydrate) {
//                game.setState("hydrate");
//            }
//            if (e.getSource() == rest) {
//                game.setState("rest");
//            }
//            if (e.getSource() == quit) {
//                game.setState("quit");
//            }
//        }
}
