/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller;

import game.view.Cell;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sergio Uriona
 */
public class ButtonController implements ActionListener {

    private Cell cell;
    
    public ButtonController(Cell cell) {
        super();
        this.cell = cell;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.cell.updateIcon();
    }
}
