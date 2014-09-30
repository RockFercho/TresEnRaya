/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.factory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rockfercho
 */
public class BoxTest {
    
    private Position position;
    private Box box;
    
    @Before
    public void setUp() {
        this.position = new Position(2, 3);
        this.box = new Box(this.position, State.CROSS);
    }
    
    /**
     * Test of getPosition method, of class Box.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Position expResult = this.position;
        Position result = this.box.getPosition();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getState method, of class Box.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        State expResult = State.CROSS;
        State result = this.box.getState();
        assertEquals(expResult, result);
    }
    
}
