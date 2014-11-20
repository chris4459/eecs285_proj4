package main;

import java.awt.Dimension;

import javax.swing.WindowConstants;

import pokemon.Pokemon;
import pokemon.Rattata;

public class MainFile {
  
  public static GameSimulatorGUI win;
  
  public static void main(String[] args) {
    System.out.println("LETS START THIS");
    Pokemon p = new Rattata("Rattata", 30, 56, 35, 72, 5);
    
    win = new GameSimulatorGUI();
    win.pack();
    win.setSize(new Dimension(900, 750));
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.setResizable(false);
    
    
    System.out.println(p);
    
  }
}
