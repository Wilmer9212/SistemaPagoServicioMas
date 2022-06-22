/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taecel.conexionservicio;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Elliot
 */
public class MyComboBoxUI extends BasicComboBoxUI{
        
        @Override
        protected void installDefaults() {
            super.installDefaults();
            LookAndFeel.uninstallBorder(comboBox);
        }

        @Override
        protected JButton createArrowButton() {
            final JButton button = new JButton(">");
            button.setName("ComboBox.arrowButton"); //Mandatory, as per BasicComboBoxUI#createArrowButton().
            
            return button;
        }

        @Override
        public void configureArrowButton() {
            super.configureArrowButton(); //Do not forget this!
            arrowButton.setBackground(Color.CYAN.darker());
            arrowButton.setForeground(Color.BLUE);
            
        }
    
}
