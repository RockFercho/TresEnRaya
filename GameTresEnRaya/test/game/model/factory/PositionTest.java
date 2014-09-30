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
public class PositionTest {
    
      
    private Position position;
    @Before
    public void setUp() {
        this.position = new Position(2, 3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getX method, of class Position.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int expResult = 2;
        int result = this.position.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Position.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int expResult = 3;
        int result = this.position.getY();
        assertEquals(expResult, result);
    }
    
}
