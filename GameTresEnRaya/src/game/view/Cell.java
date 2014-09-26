/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import game.model.factory.Position;
import game.model.factory.State;
import javax.swing.JButton;

/**
 *
 * @author Sergio Uriona
 */
public class Cell extends JButton {
    
    public Position position;
    public State state;
    
    public Cell(int xPosition, int yPosition) {
        super("       ");
        this.position = new Position(xPosition, yPosition);
        this.state = State.FREE;
    }
}
