package CamelGame;

import CamelGame.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import CamelGame.controller.Controller;
import CamelGame.controller.Message;
import CamelGame.model.Camel;


/**
 * Tester class that has the main method
 * @author MMR
 *
 */
public class CamelGame {
	
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Camel camel;

    /**
     * Main method that executes the program
     * @param args
     */
    public static void main(String[] args) {
    	
        camel = new Camel();
        view = View.init(queue, camel);
        Controller controller = new Controller(view, camel, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}