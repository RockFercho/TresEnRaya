/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.factory.Box;
import game.model.factory.FactoryBoard;
import game.model.factory.Position;
import game.model.factory.State;
import game.model.logic.LogicGame;
import game.model.logic.SearchAddress;

/**
 *
 * @author rockfercho
 */
public class Board {

    private Box board[][];
    private LogicGame logic;

    public Board() {
        this.board = new FactoryBoard().getBoxes();
        this.logic = new LogicGame();
    }

    public SearchAddress personVsPerson(Position position, State state) {
        return this.logic.movement(board, position, state);
    }

    public State getWiner() {
        return this.logic.getWiner();
    }
}
