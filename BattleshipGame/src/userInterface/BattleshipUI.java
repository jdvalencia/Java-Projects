/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 *
 * @author JuanDavid
 */
public class BattleshipUI extends JFrame {
    JMenuBar menuBar;    
    JMenu gameMenu;
    JMenu optionMenu;
    JMenuItem playerPlayer;
    JMenuItem playerComputer;
    JMenuItem computerComputer;	
    JMenuItem exit;	
    JMenuItem game;
    JMenuItem player;
    JButton deploy;
    JPanel shipLayoutPanel;
    JPanel playerOnePanel; 

    // Data arrays for various components on the UI
    String[] rowLetters = {" ","A","B","C","D","E","F","G","H","I","J"};
    String[] columnNumbers = {" ","1","2","3","4","5","6","7","8","9","10"};
    String[] ships = {"Carrier","Battleship","Submarine","Destroyer", "Patrol Boat"};
    String[] direction = {"Horizontal","Vertical"};
    JComboBox shipCb;
    JComboBox directionCb;
    GameListener gameListener;
    OptionsListener optionListener;
    static final int PLAYER_ONE = 0;
    static final int PLAYER_TWO = 1;
    Player playerOne;
    Player playerTwo;
    Player[] players = new Player[2];
    Color[] color = {Color.cyan, Color.green, Color.yellow, 
        Color.magenta, Color.pink, Color.red, Color.white
    };
    public BattleshipUI(){
        initComponents();
        initObjects();
    }
    public BattleshipUI getThisParent(){
        return this;
    }
    public void initObjects(){
        playerOne = new Player();
        playerTwo = new Player();
        players[PLAYER_ONE] = playerOne;
        players[PLAYER_TWO] = playerTwo;
        
    }
    public void initComponents(){
        getThisParent().setTitle("Battleship");
        getThisParent().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getThisParent().setSize(650,650);
        getThisParent().setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        optionMenu = new JMenu("Options");
        playerPlayer = new JMenuItem("player vs player");
        playerPlayer.addActionListener(new GameListener());
        playerPlayer.setEnabled(false);
        playerComputer = new JMenuItem("player vs computer");
        playerComputer.addActionListener(new GameListener());
        computerComputer = new JMenuItem("computer vs computer");
        computerComputer.addActionListener(new GameListener());
        computerComputer.setEnabled(false);
        exit = new JMenuItem("exit");
        exit.addActionListener(new GameListener());
        gameMenu.add(playerPlayer);
        gameMenu.add(playerComputer);
        gameMenu.add(computerComputer);
        gameMenu.add(exit);
        menuBar.add(gameMenu);
        game = new JMenuItem("Game Options");
        game.addActionListener(new OptionsListener());
        player = new JMenuItem("Player Options");
        player.addActionListener(new OptionsListener());
        optionMenu.add(game);
        optionMenu.add(player);
        menuBar.add(optionMenu);       
        
        
        JPanel shipLayout = new JPanel();    
        JPanel PlayerOnePanel = new JPanel();
        JTextField tf;
        PlayerOnePanel.setLayout(new GridLayout(11,11));
        
        Player playerOne = new Player();
        for(int row = 0;row < 11;row++){
           for(int col = 0;col < 11;col++){
               if((col!=0)&&(row!=0)){
                   PlayerOnePanel.add(playerOne.getBoard((row-1),(col-1)));
               }
               if(row == 0){
                   if(col!=0){
                       tf = new JTextField(columnNumbers[col]);
                       tf.setEditable(false);
                       tf.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                       PlayerOnePanel.add(tf);                      
                   }
                   else{
                       tf = new JTextField();
                       tf.setEditable(false);
                   }
                   PlayerOnePanel.add(tf);
               }
               else if(col==0){
                        tf = new JTextField(rowLetters[row]);
                        tf.setEditable(false);
                        tf.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT);
                        PlayerOnePanel.add(tf);
                   }
                
           }
        }

        
        String[] ships = {"Carrier","Battleship","Submarine","Destroyer", "Patrol Boat"};
        String[] direction = {"Horizontal","Vertical"};
        //shipCb.setSelectedIndex(0);     
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Ships");
        shipCb = new JComboBox(ships);
        shipCb.setBorder(title);
        //directionCb.setSelectedIndex(0);
        title = BorderFactory.createTitledBorder("Directions");
        directionCb = new JComboBox(direction);
        directionCb.setBorder(title);
        deploy = new JButton("Deploy Ships");
        deploy.setEnabled(false);
        
        shipLayout.add(shipCb);
        shipLayout.add(directionCb);
        shipLayout.add(deploy);
        getThisParent().setJMenuBar(menuBar);
        getThisParent().add(shipLayout, BorderLayout.NORTH);
        getThisParent().add(PlayerOnePanel, BorderLayout.CENTER);
        getThisParent().setVisible(true);
        
        
    }
    class GameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(null != e.getActionCommand())switch (e.getActionCommand()) {
                case "player vs player":
                    System.out.println("Player vs. Player");
                    JOptionPane.showMessageDialog(null,"You chose Player vs. Player");
                    if(JOptionPane.OK_OPTION == 1)
                        JOptionPane.getRootFrame().dispose();
                    break;
                case "player vs computer":
                    System.out.println("Player vs. Computer");
                    JOptionPane.showMessageDialog(null,"You chose Player vs. Computer");
                    break;
                case "computer vs computer":
                    System.out.println("Computer vs. Computer");
                    JOptionPane.showMessageDialog(null,"You chose Computer vs. Computer");
                    break;
                case "exit":
                    int cd = JOptionPane.showConfirmDialog(null,"Do you wish to exit?","EXIT?",JOptionPane.YES_NO_OPTION);
                if(cd == 0){
                    System.exit(0);
                
                }
                else{
                    JOptionPane.getRootFrame().dispose();
                }
                default:
                    System.out.println(".");
            }
            
            
            
        }
    }
    class OptionsListener implements ActionListener{
        GameOptionDialog gameOptions;
        PlayerOptionDialog playerOptions;
        @Override
        public void actionPerformed(ActionEvent e) {
            if("Game Options".equals(e.getActionCommand())){
                
                gameOptions = new GameOptionDialog(getThisParent(),players);
                
            }
            else if("Player Options".equals(e.getActionCommand())){
                
                playerOptions = new PlayerOptionDialog(getThisParent(),players);
            }
            
        }
        
    }
}
    

