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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevin
 */
public class MiniMaxAlgorithmTest {
    
    private final MiniMaxAlgorithm algorithm;
    
    public MiniMaxAlgorithmTest() {
        algorithm = new MiniMaxAlgorithm(new LogicGame());
    }
 
    @Test
    public void testMovement() {
        assertEquals(SearchAddress.FREE,
                algorithm.movement(new Board(), State.CROSS, State.CIRCLE));
    }
    
    /**
     * [ ][ ][X]
     * [ ][X][X]
     * [ ][O][O]
     * 
     * Test of min method, of class MiniMaxAlgorithm.
     */
    @Test
    public void testMin() {
        Board board = new Board();
        Box[][]boxes = board.getBoxes();
        boxes[1][1].setState(State.CROSS);
        boxes[0][2].setState(State.CROSS);
        boxes[1][2].setState(State.CROSS);
        boxes[2][1].setState(State.CIRCLE);
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(1, algorithm.min(board, State.CROSS, State.CIRCLE));
    }

    /**
     * [ ][ ][O]
     * [ ][O][O]
     * [ ][X][X]
     * 
     * Test of max method, of class MiniMaxAlgorithm.
     */
    @Test
    public void testMax() {
        Board board = new Board();
        Box[][]boxes = board.getBoxes();
        boxes[1][1].setState(State.CIRCLE);
        boxes[0][2].setState(State.CIRCLE);
        boxes[1][2].setState(State.CIRCLE);
        boxes[2][1].setState(State.CROSS);
        boxes[2][2].setState(State.CROSS);
        assertEquals(-1, algorithm.max(board, State.CROSS, State.CIRCLE));
        
    }
    
}
