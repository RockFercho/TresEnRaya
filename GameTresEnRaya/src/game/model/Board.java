/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.factory.Box;
import game.model.factory.FactoryBoard;
import game.model.factory.Position;
import game.model.factory.State;
import game.model.logic.LogicGame;
import game.model.logic.SearchAddress;

/**
 * The class is responsible for handling the board.
 *
 * @author rockfercho
 */
public class Board {

    /**
     * Manages the game board.
     */
    private final Box board[][];
    /**
     * Instance of the game logic.
     */
    private final LogicGame logic;

    /**
     * Constructor initializes global variables.
     */
    public Board() {
        this.board = new FactoryBoard().getBoxes();
        this.logic = new LogicGame();
    }

    /**
     *
     * Make the moves of a game of person against person.
     *
     * @param position
     * @param state
     * @return
     */
    public SearchAddress personVsPerson(Position position, State state) {
        return this.logic.movement(board, position, state);
    }

    /**
     * Return state the winner.
     *
     * @return
     */
    public State getWiner() {
        return this.logic.getWiner();
    }
}
