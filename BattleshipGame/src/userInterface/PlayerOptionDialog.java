/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author JuanDavid
 */
public class PlayerOptionDialog {
    JDialog dialog;
    JPanel radioPanel;
    JPanel comboPanel;
    JPanel buttonPanel;
    JLabel shipColorLbl; 
    JLabel firstPlayerLbl;
    JComboBox shipColor;
    JComboBox firstPlayer;
    JButton saveBtn;
    JButton cancelBtn;
    JRadioButton player1;
    JRadioButton player2;
    ButtonGroup playerOptions;
    String[] level = {"Normal", "Ridiculously Hard"};
    String[] layout = {"Manual", "Automatic"};
    String[] colors = {"Cyan", "Green", "Yellow", "Magenta", "Pink", "Red", "White"};
    String[] players = {"Player 1", "Player 2", "Random"};
    Player[] playerArray;

    public PlayerOptionDialog(JFrame parent, Player[] inPlayers) {
        playerArray = inPlayers;
        initComponents(parent);
    }
    
    private void initComponents(JFrame parent) {
    dialog = new JDialog(parent, true);
    dialog.setTitle("Options");
    dialog.setMinimumSize(new Dimension(300, 200));
    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    radioPanel = new JPanel();
    buttonPanel = new JPanel();
    comboPanel = new JPanel();
    shipColorLbl = new JLabel("Ship Color");
    firstPlayerLbl = new JLabel("Who Plays First?");
    player1 = new JRadioButton("Player 1");
    player2 = new JRadioButton("Player 2");
    playerOptions = new ButtonGroup();
    player1.addActionListener(new Listen());
    player2.addActionListener(new Listen());
    playerOptions.add(player1);
    playerOptions.add(player2);
    shipColor = new JComboBox(colors);
    shipColor.setPreferredSize(new Dimension(150,25));
    firstPlayer = new JComboBox(players);
    firstPlayer.setPreferredSize(new Dimension(150,25));
    shipColor.addActionListener(new Listen());
    firstPlayer.addActionListener(new Listen());
    shipColor.addActionListener(new Listen());
    firstPlayer.addActionListener(new Listen());
    saveBtn = new JButton("Save");
    cancelBtn = new JButton("Cancel");
    saveBtn.addActionListener(new ExitListener());
    cancelBtn.addActionListener(new ExitListener());
    radioPanel.add(player1);
    radioPanel.add(player2);
    comboPanel.add(shipColorLbl);
    comboPanel.add(shipColor);
    comboPanel.add(firstPlayerLbl);
    comboPanel.add(firstPlayer);
    buttonPanel.add(saveBtn);
    buttonPanel.add(cancelBtn);
    dialog.add(radioPanel, BorderLayout.NORTH);
    dialog.add(comboPanel, BorderLayout.CENTER);
    dialog.add(buttonPanel, BorderLayout.PAGE_END);
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
