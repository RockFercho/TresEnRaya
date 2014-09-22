/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.factory.Box;
import game.model.factory.Position;
import game.model.factory.State;
import game.model.logic.SearchAddress;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class BoardTest {

    private final Board board;

    public BoardTest() {
        board = new Board();
    }

    /**
     * Test of personVsPerson method, of class Board.
     */
    @Test
    public void testPersonVsPerson() {

    }

    /**
     * [ ][ ][ ]
     * [ ][O][ ]
     * [ ][ ][ ]
     * 
     * Machine = X;
     * Player = O;
     * Test of personVsMachine method, of class Board.
     */
    @Test
    public void testPersonVsMachine() {
        assertEquals(SearchAddress.FREE, board.personVsMachine(new Position(2,2), State.CIRCLE));
    }
    /**
     * Person = O
     * Machine = X
     * 
     * [O][ ][ ]
     * [ ][O][O]
     * [X][X][X]
     */
    @Test
    public void testPersonVsMachineFifthMove() {
        Box[][] boxes = board.getBoxes();
        boxes[0][0].setState(State.CIRCLE);
        boxes[1][1].setState(State.CIRCLE);
        boxes[2][0].setState(State.CROSS);
        boxes[2][2].setState(State.CROSS);
        assertEquals(SearchAddress.THIRDLINE, board.personVsMachine(new Position(1,2), State.CIRCLE));
        assertEquals(State.CROSS, board.getWinner());
    }
    /**
     * [ ][X ][ ]
     * [ ][O][ ]
     * [X][O][ ] 
     */
    @Test
    public void testPersonVsMachineThirthMove(){
        Box[][] boxes = board.getBoxes();
        boxes[1][1].setState(State.CIRCLE);
        boxes[2][0].setState(State.CROSS);
        assertEquals(SearchAddress.FREE, board.personVsMachine(new Position(2,1), State.CIRCLE));
    }

    /**
     * Test of getWinner method, of class Board.
     */
    @Test
    public void testGetWiner() {
        assertEquals(State.FREE, board.getWinner());
    }

//    /**
//     * Test of isEmpty method, of class Board.
//     */
//    @Test
//    public void testIsEmpty() {
//        assertEquals(true, board.isEmpty());
//    }

    /**
     * 
     * [ ][ ][ ]
     * [ ][ ][ ]
     * [ ][ ][O]
     * 
     * 
     * Test of PlayerHasPlayedOneTurn metho
     * d, of class Board.
     */
    @Test
    public void testPlayerHasPlayedOneTurn() {
        Box[][] boxes = board.getBoxes();
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(true, board.PlayerHasPlayedOneTurn());
    }

    /**
     * Expected
     * [X][O][ ]
     * [ ][X][ ]
     * [ ][ ][O]
     * 
     * 
     * Test of getBoxes method, of class Board.
     */
    @Test
    public void testGetBoxes() {
        Box[][] boxes = board.getBoxes();
        boxes[0][0].setState(State.CROSS);
        boxes[0][1].setState(State.CIRCLE);
        boxes[1][1].setState(State.CROSS);
        boxes[2][2].setState(State.CIRCLE);
        
    }

}
