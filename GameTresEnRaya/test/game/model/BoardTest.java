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
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class BoardTest {

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
        Board board = Board.getInstance();
        assertEquals(SearchAddress.FREE, board.personVsMachine(new Position(2,2), State.CIRCLE));
        Board.destroyInstance();
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
        Board board = Board.getInstance();
        Box[][] boxes = board.getBoxes();
        boxes[0][0].setState(State.CIRCLE);
        boxes[2][0].setState(State.CROSS);
        board.getLogic().getAi().setTurn((byte)1);
        boxes[1][1].setState(State.CIRCLE);
        boxes[2][2].setState(State.CROSS);
        assertEquals(SearchAddress.THIRDLINE, board.personVsMachine(new Position(1,2), State.CIRCLE));
        assertEquals(State.CROSS, board.getWinner());
        Board.destroyInstance();
    }
    /**
     * [ ][X ][ ]
     * [ ][O][ ]
     * [X][O][ ] 
     */
    @Test
    public void testPersonVsMachineThirthMove(){
        Board board = Board.getInstance();
        Box[][] boxes = board.getBoxes();
        boxes[1][1].setState(State.CIRCLE);
        boxes[2][0].setState(State.CROSS);
        assertEquals(SearchAddress.FREE, board.personVsMachine(new Position(2,1), State.CIRCLE));
        Board.destroyInstance();
    }

    /**
     * Test of getWinner method, of class Board.
     */
    @Test
    public void testGetWiner() {
        Board board = Board.getInstance();
        assertEquals(State.FREE, board.getWinner());
        Board.destroyInstance();
    }


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
        Board board = Board.getInstance();
        Box[][] boxes = board.getBoxes();
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(true, board.PlayerHasPlayedOneTurn());
        Board.destroyInstance();
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
        Board board = Board.getInstance();
        Box[][] boxes = board.getBoxes();
        boxes[0][0].setState(State.CROSS);
        boxes[0][1].setState(State.CIRCLE);
        boxes[1][1].setState(State.CROSS);
        boxes[2][2].setState(State.CIRCLE);
        assertNotNull(boxes);
    }

}
