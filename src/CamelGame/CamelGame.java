package ProjectStarterCode;

import ProjectStarterCode.controller.Controller;
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Camel;
import ProjectStarterCode.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CamelGame {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Camel camel;

    public static void main(String[] args) {
        camel = new Camel();
        view = View.init(queue, camel);
        Controller controller = new Controller(view, camel, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}

