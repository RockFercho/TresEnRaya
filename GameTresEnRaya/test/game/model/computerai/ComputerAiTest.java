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
    public void testComputerOnlyMovesATimeAtFirstMove() {
        State PLAYERSTATE = State.CIRCLE;
        Board board = new Board();
        Box[][] boxes = board.getBoxes();
        boxes[1][1].setState(PLAYERSTATE);
        ai.movement(board, PLAYERSTATE);
        int currentNumberOfStates = calculateNumberOfStates(board.getBoxes());
        assertEquals(2, currentNumberOfStates);
    }

    @Test
    public void testMovementSecondMove() {
        Board board = new Board();
        Box[][] boxes = board.getBoxes();
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(SearchAddress.FREE, ai.movement(board, State.CIRCLE));
    }

    /**
     * [ ][X][X] 
     * [ ][O][ ] 
     * [ ][O][O]
     *
     */
    @Test
    public void testMovementFinalFirstRowMove() {
        Board board = new Board();
        Box[][] boxes = board.getBoxes();
        boxes[1][1].setState(State.CIRCLE);
        boxes[0][1].setState(State.CROSS);
        ai.setTurn((byte) 1);
        boxes[2][1].setState(State.CIRCLE);
        boxes[0][2].setState(State.CROSS);
        boxes[2][2].setState(State.CIRCLE);
        assertEquals(SearchAddress.FIRSTLINE, ai.movement(board, State.CIRCLE));
    }

    private int calculateNumberOfStates(Box[][] boxes) {
        int result = 0;
        for (Box[] row : boxes) {
            for (Box column : row) {
                if (column.getState() != State.FREE) {
                    result++;
                }
            }
        }
        return result;
    }
}
