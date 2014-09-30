/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller.communication;

import game.model.factory.Position;
import game.model.factory.State;

/**
 *
 * @author Sergio Uriona
 */
public abstract class Communication {
    
    protected State currentState = State.CIRCLE;
    
    public void notifyMovement(Position position) {
    }
    
    public void getChanges() {
    }
    
    public void updateWinners() {
    }
    
    protected void setState() {
        if (currentState == State.CIRCLE) {
            currentState = State.CROSS;
        } else {
            currentState = State.CIRCLE;
        }
    }
}
