/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.components;

/**
 *
 * @author rockfercho
 */
public class Position {

    /**
     * Save the value of the position x.
     */
    private final int x;
    /**
     * Save the value of the position y.
     */
    private final int y;

    /**
     * Constructor manager setting values ​​for the variables.
     *
     * @param valueX value for x.
     * @param valueY value for y.
     */
    public Position(final int valueX, final int valueY) {
        this.x = valueX;
        this.y = valueY;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

}
