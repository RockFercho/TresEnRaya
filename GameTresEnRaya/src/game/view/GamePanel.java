/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sergio Uriona
 */
public class GamePanel extends JPanel {
    
    public GamePanel() {
        super();
        this.setSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(150, 50, 150, 350);
        g.drawLine(250, 50, 250, 350);
        g.drawLine(50, 150, 350, 150);
        g.drawLine(50, 250, 350, 250);
    }
}
