package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import pokemon.Pokemon;
import pokemon.Rattata;

public class MainFile {
  
  public static GameSimulatorGUI win;
  
  public static void main(String[] args) {
    System.out.println("-----Starting Pokemon Tower Defense Game-----");
    Pokemon rattata = new Rattata();
    
    win = new GameSimulatorGUI();
    win.setVisible(true);
    win.pack();
    win.setSize(750, 600);
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.setResizable(false);
//    
//    
//    System.out.println(p);
    
  }
}
