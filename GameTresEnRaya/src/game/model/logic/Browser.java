/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.logic;

import game.model.factory.Box;

/**
 *
 * @author rockfercho
 */
public class Browser {

    /**
     * Returns made ​​where to line three.
     *
     * @param board
     * @return line result.
     */
    public SearchAddress searchWinner(Box[][] board) {
        return this.searchByAddress(board);
    }

    /**
     * Searching by the different directions of the board.
     *
     * @param board
     * @return result search.
     */
    private SearchAddress searchByAddress(Box[][] board) {
        SearchAddress result = SearchAddress.FREE;

        if (this.searchByRow(board, 0)) {
            result = SearchAddress.FIRSTLINE;
        }

        if (this.searchByRow(board, 1)) {
            result = SearchAddress.SECONDLINE;
        }
        if (this.searchByRow(board, 2)) {
            result = SearchAddress.THIRDLINE;
        }

        if (this.searchByColumn(board, 0)) {
            result = SearchAddress.FIRSTCOLUMN;
        }

        if (this.searchByColumn(board, 1)) {
            result = SearchAddress.SECONDCOLUMN;
        }

        if (this.searchByColumn(board, 2)) {
            result = SearchAddress.THIRDCOLUMN;
        }

        if (this.mainDiagonal(board)) {
            result = SearchAddress.MAINDIAGONAL;
        }

        if (this.secundaryDiagonal(board)) {
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
    private boolean searchByRow(Box[][] board, int i) {
        return (board[i][0] == board[i][1] && board[i][0] == board[i][2]);
    }

    /**
     * Search if it is the equal of three figures by column.
     *
     * @param board
     * @param j number column
     * @return value boolean
     */
    private boolean searchByColumn(Box[][] board, int j) {
        return (board[0][j] == board[1][j] && board[0][j] == board[2][j]);
    }

    /**
     * Search if it is the same three figures in the main diagonal
     *
     * @param board
     * @return
     */
    private boolean mainDiagonal(Box[][] board) {
        return (board[0][0] == board[1][1] && board[0][0] == board[2][2]);
    }

    /**
     * Search if it is the same three figures in the secondary diagonal.
     *
     * @param board
     * @return value boolean
     */
    private boolean secundaryDiagonal(Box[][] board) {
        return (board[2][0] == board[1][1] && board[2][0] == board[0][2]);
    }
}
