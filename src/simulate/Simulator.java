package simulate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import pokemon.Pokemon;

/**
 * This class controls the simulation of the game
 * 
 * This is a static class where the member variables and methods are static
 */


public class Simulator {
  private static ArrayList< Pokemon > towerArrayList = new ArrayList<>();
  private static int level = 0;

  // ---------------------------------------------------------------------------
  /**
   * Adds a pokemon to the towerArrayList;
   */
  public static void add( final Pokemon pokemon){
    towerArrayList.add(pokemon);
  }
  
  // ---------------------------------------------------------------------------
  
  /**
   * 
   * @return An array of tower pokemons from the towerArrayList.
   */
  public static Pokemon[] getTowerArray(){
    return towerArrayList.toArray(new Pokemon[towerArrayList.size()]);
  }
  
  // ---------------------------------------------------------------------------
  
  public static String[] loadState( File inputFile ){
    if (inputFile == null) {
      return null;
    }
    else return null;
  }
  
  
  // ---------------------------------------------------------------------------
  
  /**
   * Saves the state of the game.
   *    Needs to save:
   *        - towerArrayList
   *        - level
   * @param outputFile
   * @throws IOException
   */
  public static void saveState( File outputFile ) throws IOException{
    if (outputFile == null) {
      return;
    }
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
      
      writer.write(String.format("Level: %d", level));
      writer.newLine();
      
      
      for (Pokemon pokemon : towerArrayList) {
        String name = pokemon.getName();
        String type = pokemon.getType();
        String hp = Integer.toString(pokemon.getHp());
        String attack = Integer.toString(pokemon.getAttack());
        String defense = Integer.toString(pokemon.getDefense());
        String speed = Integer.toString(pokemon.getSpeed());
        String attackRange = Double.toString(pokemon.getAttackRange());
        
        writer.write(String.format("%s %s %s %s %s %s %s", 
            name, type, hp, attack, defense, speed, attackRange));
        writer.newLine();
      }
      
      writer.flush();
      writer.close();
      
    } catch (IOException e) {
      throw new IOException(
          String.format("Error saving file. Error: %s\n", e.getMessage())
      );
    }
  }
  
  
  // ---------------------------------------------------------------------------
  /**
   * Increases the level after defeating a round
   */
  public static void levelIncrease(){
     level++;
  }
  
  // ---------------------------------------------------------------------------
  /**
   * Starts the simulation of the game when the "start simulation" button is 
   * clicked
   */
  public static void startSimulation(){
    
  }
  
  
}
