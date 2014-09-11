/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.logic;

import game.model.factory.Box;
import game.model.factory.Position;
import game.model.factory.State;

/**
 *
 * @author rockfercho
 */
public class LogicGame {

    /**
     * Declaration browser board.
     */
    private final Browser browser;
    /**
     * Declaration of winning state.
     */
    private State state;

    /**
     * Constructor initializes the global variables.
     */
    public LogicGame() {
        this.browser = new Browser();
        this.state = State.FREE;
    }

    /**
     * Returns the state of the game, and if there is a winner.
     *
     * @param board
     * @param position
     * @param state
     * @return value the winner.
     */
    public SearchAddress movement(Box[][] board, Position position, State state) {
        board[position.getX()][position.getY()].setState(state);
        return this.searchWinner(board, state);
    }

    /**
     * The method aims to find if there is a winner.
     *
     * @param board
     * @param newState
     * @return
     */
    private SearchAddress searchWinner(Box[][] board, State newState) {
        SearchAddress result = this.browser.searchWinner(board);
        if (!result.equals(SearchAddress.FREE)) {
            this.state = newState;
        }
        return result;
    }

    /**
     * Returns the state winner.
     *
     * @return value state.
     */
    public State getWiner() {
        return state;
    }
}
