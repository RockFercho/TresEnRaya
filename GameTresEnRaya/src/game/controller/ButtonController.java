/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller;

import game.controller.communication.FactoryCommunication;
import game.view.Cell;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller of JButtons.
 * 
 * @author Sergio Uriona
 */
public class ButtonController implements ActionListener {

    private Cell cell;
    
    /**
     * Initialize new ButtonController
     * @param cell 
     */
    public ButtonController(Cell cell) {
        super();
        this.cell = cell;
    }
    
    /**
     * { @inheritDoc }
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        FactoryCommunication.getCommunicator().notifyMovement(cell.getPosition());
    }
}
