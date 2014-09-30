/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller;

import game.controller.communication.FactoryCommunication;
import game.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Select the type of game for play with the computer.
 * 
 * @author Sergio Uriona
 */
public class OnePlayerController implements ActionListener {

    /**
     * Initialize a new OnePlayerController.
     */
    public OnePlayerController() {
        super();
    }
    
    /**
     * { @inheritdoc }
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        FactoryCommunication.destroyCommunicator();
        FactoryCommunication.createCommunication(2);
        MainWindow.destroyInstance();
        MainWindow.getInstance();
    }
}
