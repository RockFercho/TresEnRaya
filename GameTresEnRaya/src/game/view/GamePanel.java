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
        g.drawLine(137, 35, 137, 360);
        g.drawLine(261, 35, 261, 360);
        g.drawLine(20, 135, 380, 135);
        g.drawLine(20, 257, 380, 257);
    }
}
