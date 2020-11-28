package ProjectStarterCode.controller;

import ProjectStarterCode.model.Camel;
import ProjectStarterCode.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    private View view; // Direct reference to view
    private Camel camel; // Direct reference to model
    private GameInfo gameInfo; // Direct reference to the state of the Game/Application
    Message message;

    private List<Valve> valves = new LinkedList<Valve>();

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

    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        this.message = null;
        while (response != ValveResponse.FINISH) {
            try {
                updateGameInfo();
                this.message = queue.take(); // <--- take next message from the queue
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

    private void updateGameInfo() {
        gameInfo.GameInfo(message, camel);
    }

    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }

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

