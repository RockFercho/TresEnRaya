/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.logic;

import game.model.factory.Box;
import game.model.factory.State;

/**
 *
 * @author rockfercho
 */
public class Browser {

    /**
     * Returns made ​​where to line three.
     *
     * @param board
     * @param state the state of the player who put his state at last.
     * @return line result.
     */
    public SearchAddress searchWinner(Box[][] board, State state) {
        return this.searchByAddress(board, state);
    }

    /**
     * Searching by the different directions of the board.
     *
     * @param board
     * @return result search.
     */
    private SearchAddress searchByAddress(Box[][] board, State state) {
        SearchAddress result = SearchAddress.FREE;

        if (this.searchByRow(board, 0, state)) {
            result = SearchAddress.FIRSTLINE;
        }

        if (this.searchByRow(board, 1, state)) {
            result = SearchAddress.SECONDLINE;
        }
        if (this.searchByRow(board, 2, state)) {
            result = SearchAddress.THIRDLINE;
        }

        if (this.searchByColumn(board, 0, state)) {
            result = SearchAddress.FIRSTCOLUMN;
        }

        if (this.searchByColumn(board, 1, state)) {
            result = SearchAddress.SECONDCOLUMN;
        }

        if (this.searchByColumn(board, 2, state)) {
            result = SearchAddress.THIRDCOLUMN;
        }

        if (this.mainDiagonal(board, state)) {
            result = SearchAddress.MAINDIAGONAL;
        }

        if (this.secundaryDiagonal(board, state)) {
            result = SearchAddress.SECONDARYDIAGONAL;
        }

        return result;
    }

    /**
     * Search if it is the equal of three figures by row.
     *
     * @param board
     * @param i value row.
     * @return value boolean.
     */
    private boolean searchByRow(Box[][] board, int i, State state) {
        return (board[i][0].getState() == state && 
                board[i][1].getState() == state &&
                board[i][2].getState() == state);
    }

    /**
     * Search if it is the equal of three figures by column.
     *
     * @param board
     * @param j number column
     * @return value boolean
     */
    private boolean searchByColumn(Box[][] board, int j, State state) {
        return (board[0][j].getState() == state &&
                board[1][j].getState() == state &&
                board[0][j].getState() == state);
    }

    /**
     * Search if it is the same three figures in the main diagonal
     *
     * @param board
     * @return
     */
    private boolean mainDiagonal(Box[][] board, State state) {
        return (board[0][0].getState() == state &&
                board[1][1].getState() == state &&
                board[2][2].getState() == state);
    }

    /**
     * Search if it is the same three figures in the secondary diagonal.
     *
     * @param board
     * @return value boolean
     */
    private boolean secundaryDiagonal(Box[][] board, State state) {
        return (board[2][0].getState() == state &&
                board[1][1].getState() == state &&
                board[0][2].getState() == state);
    }
}
