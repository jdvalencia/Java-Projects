/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package userInterface;
import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author JuanDavid
 */
public class Player {
    Color shipColor;
    String userName;
    boolean isFirst;
    JButton[][] buttonBoard;
    private final static int rows = 10;
    private final static int cols = 10;
    
    public Player(){
        initComponents();
    }
    private void initComponents(){
        buttonBoard = new JButton[rows][cols];
        
        for(int row = 0; row < 10; row++){
            for(int col = 0; col< 10;col++){
                buttonBoard[row][col] = new JButton();
            }
        }
    }
    public JButton getBoard(int i, int j){
        return this.buttonBoard[i][j];
        
    }
}

