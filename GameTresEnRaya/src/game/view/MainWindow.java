/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;

/**
 *
 * @author sergio Uriona
 */
public class MainWindow extends JFrame {
    
    private Cell[][] cells;
    private GamePanel gamePanel;
    
    public MainWindow() {
        super("Tres En Raya");
        this.setSize(new Dimension(400, 400));
        initializeComponents();
        addComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initializeComponents() {
        this.gamePanel = new GamePanel();
        this.cells = new Cell[3][3];
        createCells();
    }
    
    private void addComponents() {
        this.getContentPane().add(this.gamePanel);
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setValuesConstraint(i, j, c);
                this.gamePanel.add(this.cells[i][j], c);
            }
        }
    }
    
    private void setValuesConstraint(int gridX, int gridY,
            GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(25, 5, 5, 5);
        c.gridx = gridX + 1;
        c.gridy = gridY + 1;
        c.gridwidth = 1;
        c.gridheight = 1;
    }
    
    private void createCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }
    
    public static void main(String[] args) {
        new MainWindow();
    }
}
