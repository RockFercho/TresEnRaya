/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller.communication;

import game.model.Board;
import game.model.factory.Box;
import game.model.factory.Position;
import game.model.logic.SearchAddress;
import game.view.Cell;
import game.view.MainWindow;

/**
 * Communicate the view with the logic game.
 * 
 * @author Sergio Uriona
 */
public class ComputerCommunication extends Communication {

    /**
     * Initialize a new ComputerCommunication.
     */
    public ComputerCommunication() {
        super();
    }
    
    /**
     * { @inheritdoc }
     * @param position 
     */
    @Override
    public void notifyMovement(Position position) {
        SearchAddress response = Board.getInstance().personVsMachine(position, currentState);
        this.getChanges();
        if (response != SearchAddress.FREE) {
            this.updateWinners();
        }
    }

    /**
     * { @inheritdoc }
     */
    @Override
    public void getChanges() {
        Box[][] boxes = Board.getInstance().getBoxes();
        Cell[][] cells = MainWindow.getInstance().getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setState(boxes[i][j].getState());
            }
        }
    }
    
    /**
     * { @inheritdoc }
     */
    @Override
    public void updateWinners() {
        for (Box box: Board.getInstance().getBoxesWinner()) {
            int x = box.getPosition().getX() - 1;
            int y = box.getPosition().getY() - 1;
            MainWindow.getInstance().getCells()[x][y].updateIconWinner();
        }
        switch (Board.getInstance().getWinner()) {
            case CIRCLE: MainWindow.getInstance().setLabel("PLAYER ONE WIN"); break;
            case CROSS: MainWindow.getInstance().setLabel("COMPUTER WIN"); break;
        }
    }
}
