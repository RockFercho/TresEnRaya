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
import java.util.List;
import java.util.ArrayList;

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
     * Contains the boxes of winner.
     */
    private List<Box> boxesWinner;

    /**
     * Represent a board of game.
     */
    private static Board currentBoard;
    
    /**
     * Returns the instance of board.
     * @return 
     */
    public static Board getInstance() {
        if (currentBoard == null) {
            return currentBoard = new Board();
        } else {
            return currentBoard;
        }
    }
    
    /**
     * Destroy the instance of board.
     */
    public static void destroyInstance() {
        currentBoard = null;
    }
    
    /**
     * Constructor initializes global variables.
     */
    private Board() {
        this.board = new FactoryBoard().getBoxes();
        this.logic = new LogicGame();
        this.boxesWinner = new ArrayList();
    }
    
    /**
     * Return the boxes of winner.
     * @return 
     */
    public List<Box> getBoxesWinner() {
        return this.boxesWinner;
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
     * Allows the player to play against the machine
     * @param position the position where the player is going to put his state
     * @param state the state chosen by the player
     * @return a searchAddres return type that indicate where is the three in line if it exists
     *          returns Free if there is no three in line.
     */
    public SearchAddress personVsMachine(Position position, State state){
        SearchAddress result = this.logic.movement(board, position, state);
        if (result == SearchAddress.FREE) {
            result = this.logic.getAi().movement(this, state);
        }
        return result;
    }
    
    /**
     * Return state the winner.
     *
     * @return
     */
    public State getWinner() {
        return this.logic.getWinner();
    }
    
    /**
     * Returns true if the board is completely empty.
     * @return true if the board is completely empty, false if there is at least one element.
     */
    public boolean isEmpty(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getState() != State.FREE){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Returns a boolean value that indicates if there is one state in the board.
     * @return true if the player has played its state false if there is none of more than one state.
     */
    public boolean PlayerHasPlayedOneTurn() { 
        int statePlayed = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (!(board[i][j].getState() == State.FREE)){
                    statePlayed++;
                }
            }
        }
        return statePlayed <= 1;
    }
    
    /**
     * Returns the current boxes in the board.
     * @return a Box type result that represents the current boxes in the board.
     */
    public Box[][] getBoxes() {
        return board;
    }
    
    /**
     * If there are no more empty boxes this method will return a positive value.
     * @return true if there are no empty boxes, false if there is one or more empty boxes.
     */
    public boolean emptyCells() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getState() == State.FREE){
                    return true;
                }
            }
        }
        return false;
    }
}
