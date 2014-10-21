/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author JuanDavid
 */
public class GameOptionDialog {
    JDialog dialog;
    JPanel comboPanel;
    JPanel comboPanel2;
    JPanel buttonPanel;
    JLabel computerAiLbl;
    JLabel shipLayoutLbl;
    JComboBox computerAi;
    JComboBox shipLayout;
    JButton saveBtn;
    JButton cancelBtn;
    
    
    String[] level = {"Normal", "Ridiculously Hard"};
    String[] layout = {"Manual", "Automatic"};
    
   
    Player[] playerArray;
    
  
    public GameOptionDialog(JFrame parent, Player[] inPlayers) {
        playerArray = inPlayers;
        initComponents(parent);
    }
    

    private void initComponents(JFrame parent) {
      
        dialog = new JDialog(parent, true);
        dialog.setTitle("Options");
        dialog.setMinimumSize(new Dimension(300, 200));
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Game Options");
        comboPanel = new JPanel();
        buttonPanel = new JPanel();
        comboPanel2 = new JPanel();
        computerAiLbl = new JLabel("Computer AI");
        shipLayoutLbl = new JLabel("Ship Layout");
        computerAi = new JComboBox(level);
        shipLayout = new JComboBox(layout);
        computerAi.addActionListener(new Listen());
        shipLayout.addActionListener(new Listen());
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");
        saveBtn.addActionListener(new ExitListener());
        cancelBtn.addActionListener(new ExitListener());
        comboPanel.add(computerAiLbl);
        comboPanel.add(computerAi);
        comboPanel2.add(shipLayoutLbl);
        comboPanel2.add(shipLayout);
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(comboPanel, BorderLayout.NORTH);
        dialog.add(comboPanel2, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    class Listen implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          dialog.dispose();
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            dialog.dispose();
        }
    }    

    

}
