package CamelGame;

import CamelGame.controller.Message;
import CamelGame.model.*;
import CamelGame.view.View;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Tests various classes and methods in Model
 * @author MMR
 *
 */
public class CamelGameTest {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Camel camel;
    CamelEvent oasis = new Oasis();
    CamelEvent flower = new Flower();
    CamelEvent sand = new Sandstorm();
    CamelEvent genie = new Genie();


    @Test
    /**
     * Tests Camel class run method
     */
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
    /**
     * Tests Camel class walk method
     */
    public void testWalk(){
        Camel camel = new Camel();
        camel.walk();
        Assert.assertEquals(9, camel.getHydration());
    }

    @Test
    /**
     * Tests Camel class hydrate method
     */
    public void testHydrate(){
        Camel camel = new Camel();
        camel.run();
        camel.hydrate();
        Assert.assertEquals(10, camel.getHydration());
    }

    @Test
    /**
     * Tests Camel class rest method
     */
    public void testRest(){
        Camel camel = new Camel();
        camel.run();
        Assert.assertEquals(8, camel.getStamina());
        camel.rest();
        Assert.assertEquals(10, camel.getStamina());
    }

    @Test
    /**
     * Tests Camel class lose scenario for running out of stamina
     */
    public void testLose(){
        Camel camel = new Camel();
        for(int i = 0;i<20;i++){
            camel.run();
            camel.hydrate();
        }
        Assert.assertEquals(2, camel.gameOverLose());
    }

    @Test
    /**
     * Tests Camel class win scenario
     */
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
    /**
     * Tests Oasis class event method
     */
    public void testOasis(){
        Camel camel = new Camel();
        camel.run();
        oasis.event(camel);
        Assert.assertEquals(10, camel.getHydration());
    }

    @Test
    /**
     * Tests Flower class event method
     */
    public void testFlower(){
        Camel camel = new Camel();
        camel.run();
        flower.event(camel);
        Assert.assertEquals(10, camel.getStamina());
    }

    @Test
    /**
     * Tests Sandstorm class event method
     */
    public void testSandstorm(){
        Camel camel = new Camel();
        camel.run();
        sand.event(camel);
        Assert.assertEquals(4, camel.getHydration());
    }

    @Test
    /**
     * Tests Genie class event method
     */
    public void testGenie(){
        Camel camel = new Camel();
        camel.run();
        genie.event(camel);
        Assert.assertEquals(10, camel.getHydration());
    }
}