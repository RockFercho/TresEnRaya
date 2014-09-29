/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.computerai;

import game.model.Board;
import game.model.factory.Box;
import game.model.factory.Position;
import game.model.factory.State;
import game.model.logic.LogicGame;
import game.model.logic.SearchAddress;

/**
 * Represents the heuristic for the game based in the minimax algorithm.
 * @author kevin
 */
public class MiniMaxAlgorithm {

    /**
     * Represents the logic of the game 
     */
    private final LogicGame logicGame;
    
    /**
     * Represents the constructor of this class.
     * @param logic the logic of the game.
     */
    public MiniMaxAlgorithm(LogicGame logic) {
        this.logicGame = logic;
    }

    /**
     * Iterates the board and looks recursively for the best move for the machine.
     * @param board the current game board.
     * @param computerState the state assigned to the computer.
     * @param playerState the state assigned to the player.
     * @return a searchAddress type value that represents where is located the three in line or 
     *          Free if there is no winner.
     */
    public SearchAddress movement(Board board, State computerState, State playerState) {
        int aux, better = -999;
        Position betterPosition = new Position(0,0);
        Box[][] boxes = board.getBoxes();
        for (int i = 0; i < (boxes.length); i++){
            for (int j = 0; j < (boxes[i].length); j++){
                if (boxes[i][j].getState() == State.FREE) {
                    boxes[i][j].setState(computerState);
                    aux = min(board, computerState, playerState);
                    if (aux > better) {
                        better = aux;
                        betterPosition = new Position(i,j);
                    }
                    boxes[i][j].setState(State.FREE);
                }
            }
        }
        boxes[betterPosition.getX()][betterPosition.getY()].setState(computerState);
        return logicGame.movement(boxes, betterPosition, computerState);
    }
    
    /**
     * This is the min method that simulates where the player is going to put its states and try to 
     * win.
     * @param board the current game of the board.
     * @param computerState
     * @param playerState
     * @return an integer value that represents if the final move its beneficial for the player
     *  if the value is 1 the computer has won, if the value is 0 there was a tie, if the value is -1
     *  the player has won
     */
    public int min(Board board, State computerState, State playerState) {
        if (!(logicGame.searchWinner(board.getBoxes(), computerState) == SearchAddress.FREE)) return 1;
        if (!(board.emptyCells()))return 0;
        int aux, better = 999;
        Box[][] boxes = board.getBoxes();
        for (Box[] row : boxes) {
            for (Box column : row) {
                if (column.getState() == State.FREE) {
                    column.setState(playerState);
                    aux = max(board, computerState, playerState);
                    if (aux < better) {
                        better = aux;
                    }
                    column.setState(State.FREE);
                }
            }
        }
        
        return better;
    }
    
    /**
     * Represents the recursive method that simulates where is going to put the machine its state 
     * trying to win.
     * @param board the current board of the game.
     * @param computerState the state assigned to the computer.
     * @param playerState the state chosen by the player.
     * @return an integer value that represents if the final move its beneficial for the computer
     *  if the value is 1 the computer won, if the value is 0 there was a tie, if the value is -1 
     *  the player has won.
     */
    public int max(Board board, State computerState, State playerState) {
        if (!(logicGame.searchWinner(board.getBoxes(), playerState) == SearchAddress.FREE)) return -1;
        if (!(board.emptyCells()))return 0;
        int aux, better = -999;
        Box[][] boxes = board.getBoxes();
        for (Box[] row : boxes) {
            for (Box columns : row) {
                if (columns.getState() == State.FREE) {
                    columns.setState(computerState);
                    aux = min(board, computerState, playerState);
                    if (aux > better) {
                        better = aux;
                    }
                    columns.setState(State.FREE);
                }
            }
        }
        return better;
    }
}
