package listeners;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

import main.PokemonInfoGUI;
import pokemon.Pokemon;
import simulate.Simulator;

public class ListListener extends MouseAdapter {
  private PokemonInfoGUI pokemonInfoWin;

  @Override
  public void mouseClicked(MouseEvent e) {
    JList<String> list = (JList<String>)e.getSource();
    
    if (e.getClickCount() == 2) {
      String pokemonString = list.getSelectedValue();
      
      Pokemon pokemonToShow = null;
      Vector<Pokemon> pokemons = Simulator.getTowerVector();
      for (Pokemon pokemon : pokemons) {
        if (pokemon.getName().equals(pokemonString)) {
          pokemonToShow = pokemon;
        }
      }
      
      pokemonInfoWin = new PokemonInfoGUI(pokemonToShow);
      pokemonInfoWin.setMinimumSize(new Dimension(500, 300));
      pokemonInfoWin.pack();
      pokemonInfoWin.setVisible(true);
      pokemonInfoWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      pokemonInfoWin.setResizable(false);
      
    }
  }
}
