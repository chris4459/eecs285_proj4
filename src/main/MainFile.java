package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import pokemon.Bulbasaur;
import pokemon.Caterpie;
import pokemon.Charmander;
import pokemon.Pidgey;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Rattata;
import pokemon.Squirtle;
import simulate.Simulator;

public class MainFile {
  
  public static GameSimulatorGUI win;
  
  public static void main(String[] args) {
    System.out.println("-----Starting Pokemon Tower Defense Game-----");
    Pokemon rattata = new Rattata();
    Pokemon bulbasaur = new Bulbasaur();
    Pokemon charmander = new Charmander();
    Pokemon pikachu = new Pikachu();
    Pokemon pidgey = new Pidgey();
    Pokemon caterpie = new Caterpie();
    Pokemon squirtle = new Squirtle();
    Simulator.add(rattata);
    Simulator.add(bulbasaur);
    Simulator.add(charmander);
    Simulator.add(pikachu);
    Simulator.add(pidgey);
    Simulator.add(caterpie);
    Simulator.add(squirtle);
    
    
    win = new GameSimulatorGUI();
    win.setVisible(true);
    win.pack();
    win.setSize(850, 750);
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    win.setResizable(false);
//    
//    
    
  }
}
