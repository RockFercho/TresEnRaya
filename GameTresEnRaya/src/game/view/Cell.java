/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import game.controller.ButtonController;
import game.model.factory.Position;
import game.model.factory.State;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Represent a cell of the game.
 * 
 * @author Sergio Uriona
 */
public class Cell extends JButton {
    
    private Position position;
    private State state;
    private ImageIcon icon;
    
    /**
     * Initialize a new instance of Cell.
     * @param xPosition
     * @param yPosition 
     */
    public Cell(int xPosition, int yPosition) {
        super();
        this.position = new Position(xPosition, yPosition);
        this.state = State.FREE;
        this.icon = new ImageIcon("resources/Empty.png");
        this.setIcon(this.icon);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setBackground(Color.white);
        this.addActionListener(new ButtonController(this));
    }
    
    /**
     * Update the icon of the cell.
     */
    private void updateIcon() {
        switch (this.state) {
            case CIRCLE: this.icon = new ImageIcon("resources/Circle.png"); break;
            case CROSS: this.icon = new ImageIcon("resources/Cruz.png"); break;
        }
        this.setIcon(this.icon);
        this.updateUI();
    }
    
    /**
     * Set the state of cell.
     * @param state 
     */
    public void setState(State state) {
        this.state = state;
        this.updateIcon();
    }
    
    /**
     * Set the icon of cell if it's is winner.
     */
    public void updateIconWinner() {
        switch (this.state) {
            case CIRCLE: this.icon = new ImageIcon("resources/CircleWin.png"); break;
            case CROSS: this.icon = new ImageIcon("resources/CruzWin.png"); break;
        }
        this.setIcon(this.icon);
        this.updateUI();
    }
    
    /**
     * Return the position of this cell.
     * @return 
     */
    public Position getPosition() {
        return this.position;
    }
}
