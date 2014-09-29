/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.factory;

/**
 * Class is the box of the board.
 *
 * @author rockfercho
 */
public class Box {

    /**
     * Save the position of the box.
     */
    private Position position;
    /**
     * Saves the state of the box.
     */
    private State state;

    /**
     * Constructor that initializes the values ​​of global variables.
     *
     * @param valuePosition value for position.
     * @param valueState value for state.
     */
    public Box(final Position valuePosition, final State valueState) {
        this.position = valuePosition;
        this.state = valueState;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }
}
