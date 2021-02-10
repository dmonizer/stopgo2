/*
 * Copyright (C) 2020 sek
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.makerbox.stopgo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Seth Kenlon
 */

public class Picture extends JLabel implements MouseListener, ActionListener {
    private boolean isSelected;
    private final String filename;
    /**
     * Creates thumbnail image to represent a film frame in the timeline.
     * @param img: the image to turn into a film frame
     * @param w: desired width
     * @param h: desired height
     */
    public Picture(String img, int w, int h) {
        Border outline = BorderFactory.createLineBorder(Color.black);
        this.setOpaque(true);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        this.setIcon(imageIcon);
        this.filename = img;
        this.setBackground(Color.black);
        this.setForeground(Color.white);
        this.setBorder(outline);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setText(img.substring(img.lastIndexOf(".") - 7));
        this.isSelected = false;
        this.main();
    }

    public final void main() {
        this.addMouseListener(this);
//        this.addFocusListener(new CustomFocusListener());
//        this.setFocusable(true);
    }
 
    /** Handle the button click. */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ACTION: " + e.toString());
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this) {
            this.isSelected = !this.isSelected;
        }
        
        if (this.isSelected) {
            this.setForeground(Color.red);
            this.setText("🚫");
            //this.requestFocus();
            this.transferFocus();
            this.repaint();
            System.out.println(filename);
        } else {
            this.setForeground(Color.white);
            this.setText(filename.substring(filename.lastIndexOf(".") - 7));
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void toggle(){
        System.out.println("message received");
//        this.isSelected = false;
//        this.setForeground(Color.white);
//        this.setText(filename.substring(filename.lastIndexOf(".") - 7));
//        this.repaint();
    }
}