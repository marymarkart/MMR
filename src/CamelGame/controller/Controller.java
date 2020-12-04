package CamelGame.controller;

import CamelGame.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import CamelGame.model.Camel;

/**
 * Gets messages from Queue and has mainLoop which controls the game
 * @author MMR
 *
 */
public class Controller {
    private BlockingQueue<Message> queue;
    private View view; // Direct reference to view
    private Camel camel; // Direct reference to model
    private GameInfo gameInfo; // Direct reference to the state of the Game/Application
    Message message;

    private List<Valve> valves = new LinkedList<Valve>();
    private String action;

    /**
     * Constructs new Controller object
     * @param view connects View to Controller
     * @param camel connects Camel to Controller
     * @param queue connects BlockingQueue<Message> to Controller
     */
    public Controller(View view, Camel camel, BlockingQueue<Message> queue) {
        this.view = view;
        this.camel = camel;
        this.queue = queue;
        valves.add(new DoNewGameValve());
        valves.add(new DoRunValve());
        valves.add(new DoWalkValve());
        valves.add(new DoHydrateValve());
        valves.add(new DoRestValve());
        valves.add(new DoQuitValve());
    }

    /**
     * Controls game valve to execute user input
     */
    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        this.message = null;
        while (response != ValveResponse.FINISH) {
            try {
                this.message = queue.take(); // <--- take next message from the queue
                updateGameInfo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed or game over, leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    /**
     * Takes message from queue to determine the action to take
     */
    private void updateGameInfo() {
        gameInfo = new GameInfo();
        if (message.getClass().equals(RunMessage.class)){
            action = "run";
        }
        else if (message.getClass().equals(WalkMessage.class)){
            action = "walk";
        }
        else if (message.getClass().equals(HydrateMessage.class)){
            action = "hydrate";
        }
        else if (message.getClass().equals(RestMessage.class)){
            action = "rest";
        }
        else if (message.getClass().equals(QuitMessage.class)){
            action = "quit";
        }
        if (action != null) {
            gameInfo.GameInfo(action, camel, view, queue);
        }
    }

    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }

    /**
     * Uses received new game message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoNewGameValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != NewGameMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise it means that it is a NewGameMessage message
            // actions in Model
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Uses received run message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoRunValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != RunMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
    
    /**
     * Uses received walk message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoWalkValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != WalkMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
    
    /**
     * Uses received hydrate message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoHydrateValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != HydrateMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
    
    /**
     * Uses received rest message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoRestValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != RestMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
    
    /**
     * Uses received quit message from queue to decide the path of the message
     * @author MMR
     *
     */
    private class DoQuitValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != QuitMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
}