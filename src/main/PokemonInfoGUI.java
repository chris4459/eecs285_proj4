package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pokemon.Pokemon;

public class PokemonInfoGUI extends JFrame{

  
  public PokemonInfoGUI(Pokemon pokemon) {
    this.setLayout(new BorderLayout());
    
    this.add("North", pokemon.getPicture());
    
    
  }
}
