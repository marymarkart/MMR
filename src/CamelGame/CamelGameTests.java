package CamelGame;

import CamelGame.controller.Message;
import CamelGame.model.*;
import CamelGame.view.View;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CamelGameTests {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Camel camel;
    CamelEvent oasis = new Oasis();
    CamelEvent flower = new Flower();
    CamelEvent sand = new Sandstorm();
    CamelEvent genie = new Genie();


    @Test
    public void testRun(){
        Camel camel = new Camel();
        camel.run();
        Assert.assertEquals(8, camel.getHydration());
//        view = View.init(queue, camel);
//        Controller controller = new Controller(view, camel, queue);
//
//        MouseEvent click = new MouseEvent();
//
//        controller.mainLoop();
//        view.dispose();
//        queue.clear();
    }

    @Test
    public void testWalk(){
        Camel camel = new Camel();
        camel.walk();
        Assert.assertEquals(9, camel.getHydration());
    }

    @Test
    public void testHydrate(){
        Camel camel = new Camel();
        camel.run();
        camel.hydrate();
        Assert.assertEquals(10, camel.getHydration());
    }

    @Test
    public void testRest(){
        Camel camel = new Camel();
        camel.run();
        Assert.assertEquals(8, camel.getStamina());
        camel.rest();
        Assert.assertEquals(10, camel.getStamina());
    }

    @Test
    public void testLose(){
        Camel camel = new Camel();
        for(int i = 0;i<20;i++){
            camel.run();
            camel.hydrate();
        }
        Assert.assertEquals(2, camel.gameOverLose());
    }

    @Test
    public void testWin(){
        Camel camel = new Camel();
        for(int i = 0;i<20;i++){
            camel.run();
            camel.run();
            camel.hydrate();
            camel.rest();
        }
        Assert.assertEquals(1, camel.gameOverWin());
    }

    @Test
    public void testOasis(){
        Camel camel = new Camel();
        camel.run();
        oasis.event(camel);
        Assert.assertEquals(10, camel.getHydration());
    }

    @Test
    public void testFlower(){
        Camel camel = new Camel();
        camel.run();
        flower.event(camel);
        Assert.assertEquals(10, camel.getStamina());
    }

    @Test
    public void testSandstorm(){
        Camel camel = new Camel();
        camel.run();
        sand.event(camel);
        Assert.assertEquals(4, camel.getHydration());
    }

    @Test
    public void testGenie(){
        Camel camel = new Camel();
        camel.run();
        genie.event(camel);
        Assert.assertEquals(10, camel.getHydration());
    }
}
