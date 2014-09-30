/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import game.controller.OnePlayerController;
import game.controller.TwoPlayersController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Represent a Main window of the game.
 * 
 * @author sergio Uriona
 */
public class MainWindow extends JFrame {
    
    private static MainWindow main;
    private Cell[][] cells;
    private GamePanel gamePanel;
    private JLabel label;
    
    /**
     * Return an instance of MainWindow.
     * @return 
     */
    public static MainWindow getInstance() {
        if (main == null) {
            return main = new MainWindow();
        } else {
            return main;
        }
    }
    
    /**
     * Destroy an instance of mainwindow.
     */
    public static void destroyInstance() {
        main = null;
    }
    
    /**
     * Initialize a new MainWindow.
     */
    private MainWindow() {
        super("Tres En Raya");
        this.setSize(new Dimension(400, 415));
        initializeComponents();
        addComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Initialize all components of mainWindow.
     */
    private void initializeComponents() {
        this.gamePanel = new GamePanel();
        this.cells = new Cell[3][3];
        createCells();
        this.label = new JLabel("PLAYER ONE");
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("Game");
        menubar.add(file);
        JMenuItem onePlayer = new JMenuItem("One Player");
        onePlayer.addActionListener(new OnePlayerController());
        JMenuItem twoPlayers = new JMenuItem("Two Players");
        twoPlayers.addActionListener(new TwoPlayersController());
        file.add(onePlayer);
        file.add(twoPlayers);
        this.setJMenuBar(menubar);
    }
    
    /**
     * Add components to mainWindow.
     */
    private void addComponents() {
        this.getContentPane().add(this.gamePanel);
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setValuesConstraint(i, j, c);
                this.gamePanel.add(this.cells[i][j], c);
            }
        }
        this.getContentPane().add(this.label, BorderLayout.SOUTH);
    }
    
    /**
     * Set values of constraint.
     * @param gridX
     * @param gridY
     * @param c 
     */
    private void setValuesConstraint(int gridX, int gridY,
            GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(25, 5, 5, 5);
        c.gridx = gridX + 1;
        c.gridy = gridY + 1;
        c.gridwidth = 1;
        c.gridheight = 1;
    }
    
    /**
     * Create a cell initials.
     */
    private void createCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }
    
    /**
     * Return the cells of the game.
     * @return 
     */
    public Cell[][] getCells() {
        return this.cells;
    }
    
    /**
     * Set the label of the game.
     * @param label 
     */
    public void setLabel(String label) {
        this.label.setText(label);
        this.label.updateUI();
    }
    
    public static void main(String[] args) {
        new MainWindow();
    }
}
