package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class NewGameGUI extends JFrame{
  private static JLabel pickStarterLabel;
  private static JRadioButton starterRadioButton;
  private static JRadioButtonMenuItem bulbasaurItem;
  private static JRadioButtonMenuItem charmanderItem;
  private static JRadioButtonMenuItem squirtleItem;
  private static JRadioButtonMenuItem pikachuItem;
  
  public NewGameGUI() {
    initialize();
    this.setLayout(new BorderLayout());
    
    
    
  }
  
  /**
   * Initializes the frame for this class
   */
  private void initialize(){
    this.setMinimumSize(new Dimension(400,200));
    this.setBounds(200, 250, 0, 0);
    this.setTitle("Pick A Starter");
    this.setVisible(true);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.pack();
  }
  
  
  
}
