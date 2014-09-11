/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.factory;

/**
 * The class is responsible for building the game board.
 *
 * @author rockfercho
 */
public class FactoryBoard {

    /**
     * Manages the various boxes initialized free.
     */
    private final Box boxes[][];

    /**
     * Constructor responsible for initializing global variables.
     */
    public FactoryBoard() {
        this.boxes = new Box[3][3];
        this.createBoxes();
    }

    /**
     * Responsible construction method board boxes.
     */
    private void createBoxes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.boxes[i][j] = new Box(new Position(i, j), State.FREE);
            }
        }
    }

    /**
     * @return the boxes
     */
    public Box[][] getBoxes() {
        return boxes;
    }
}
