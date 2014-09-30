/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.factory;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rockfercho
 */
public class FactoryBoardTest {
    
       
        
    /**
     * Check if the correct size of the board is created.
     */
    @Test
    public void testGetBoxes() {
        System.out.println("getBoxes");
        FactoryBoard instance = new FactoryBoard();
        int expResult = 3;
        Box[][] result = instance.getBoxes();
        assertEquals(expResult, result.length);
    }
    
}
