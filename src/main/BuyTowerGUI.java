package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BuyTowerGUI extends JFrame{
  public BuyTowerGUI() {
    initialize();
    
  }
  
  private void initialize(){
    this.setMinimumSize(new Dimension(400,200));
    this.setBounds(200, 250, 0, 0);
    this.setTitle("Buy a Tower");
    this.setVisible(true);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.pack();
  }
}
