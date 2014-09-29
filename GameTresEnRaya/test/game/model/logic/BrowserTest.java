/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.logic;

import game.model.factory.Box;
import game.model.factory.FactoryBoard;
import game.model.factory.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rockfercho
 */
public class BrowserTest {
    

    /**
     * Test of searchWinner method, of class Browser.
     */
    @Test
    public void testSearchWinner() {
        System.out.println("searchWinner");
        Box[][] board = new FactoryBoard().getBoxes();
        State state = State.CIRCLE;
        Browser instance = new Browser();
        SearchAddress expResult = SearchAddress.FREE;
        SearchAddress result = instance.searchWinner(board, state);
        assertEquals(expResult, result);
    }
    
}
