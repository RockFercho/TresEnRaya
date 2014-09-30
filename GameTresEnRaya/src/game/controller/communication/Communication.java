/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller.communication;

import game.model.factory.Position;
import game.model.factory.State;

/**
 * Communicate the view with the logic game.
 * 
 * @author Sergio Uriona
 */
public abstract class Communication {
    
    /**
     * Represents the state of the current player.
     */
    protected State currentState = State.CIRCLE;
    
    /**
     * Notify a mevement to logic game.
     * @param position 
     */
    public void notifyMovement(Position position) {
    }
    
    /**
     * Modify the view with all changes.
     */
    public void getChanges() {
    }
    
    /**
     * Update the view when the game is ended.
     */
    public void updateWinners() {
    }
    
    /**
     * Set the state of current player.
     */
    protected void setState() {
        if (currentState == State.CIRCLE) {
            currentState = State.CROSS;
        } else {
            currentState = State.CIRCLE;
        }
    }
}
