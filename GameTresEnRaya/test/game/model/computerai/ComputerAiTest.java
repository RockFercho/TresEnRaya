/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.computerai;

import game.model.Board;
import game.model.factory.Box;
import game.model.factory.State;
import game.model.logic.LogicGame;
import game.model.logic.SearchAddress;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class ComputerAiTest {
   
    private final ComputerAi ai;
    
    public ComputerAiTest() {
        ai = new ComputerAi(new LogicGame());
    }
   

    /**
     * Test of movement method, of class ComputerAi.
     */
    @Test
    public void testMovementFirstMove() {
        assertEquals(SearchAddress.FREE, ai.movement(new Board(), State.CIRCLE));
    }
    
    @Test
    public void testMovementSecondMove() {
        Board board = new Board();
        Box[][]boxes = board.getBoxes();
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(SearchAddress.FREE, ai.movement(board, State.CIRCLE));
    }
    /**
     * [ ][X][X]
     * [ ][O][ ]
     * [ ][ ][ ]
     * 
     */
    @Test
    public void testMovementFinalFirstRowMove() {
        Board board = new Board();
        Box[][]boxes = board.getBoxes();
        boxes[1][1].setState(State.CIRCLE);
        boxes[0][1].setState(State.CROSS);
        boxes[0][2].setState(State.CROSS);
        assertEquals(SearchAddress.FIRSTLINE, ai.movement(board, State.CIRCLE));
    }
}
