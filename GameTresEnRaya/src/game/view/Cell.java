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
import java.awt.Event;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Sergio Uriona
 */
public class Cell extends JButton {
    
    private Position position;
    private State state;
    private ImageIcon icon;
    
    
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
    
    public void updateIcon() {
        this.icon = new ImageIcon("resources/Circle.png");
        this.setIcon(this.icon);
        this.updateUI();
    }
}
