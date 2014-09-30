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
 *
 * @author Sergio Uriona
 */
public class PlayerCommunication extends Communication {

    public PlayerCommunication() {
        super();
    }
    
    @Override
    public void notifyMovement(Position position) {
        SearchAddress response = Board.getInstance().personVsPerson(position, currentState);
        this.getChanges();
        this.setState();
        if (response != SearchAddress.FREE) {
            this.updateWinners();
        }
    }
    
    @Override
    public void getChanges() {
        Box[][] boxes = Board.getInstance().getBoxes();
        Cell[][] cells = MainWindow.getInstance().getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setState(boxes[i][j].getState());
            }
        }
        this.setLabel();
    }
    
    private void setLabel() {
        switch (currentState) {
            case CIRCLE: MainWindow.getInstance().setLabel("PLAYER TWO"); break;
            case CROSS: MainWindow.getInstance().setLabel("PLAYER ONE"); break;
        }
    }
    
    @Override
    public void updateWinners() {
        for (Box box: Board.getInstance().getBoxesWinner()) {
            int x = box.getPosition().getX();
            int y = box.getPosition().getY();
            MainWindow.getInstance().getCells()[x][y].updateIconWinner();
        }
        switch (currentState) {
            case CIRCLE: MainWindow.getInstance().setLabel("PLAYER TWO WIN"); break;
            case CROSS: MainWindow.getInstance().setLabel("PLAYER ONE WIN"); break;
        }
    }
}
