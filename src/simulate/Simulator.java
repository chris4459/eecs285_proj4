package simulate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import factory.PokemonFactory;
import pokemon.Pokemon;

/**
 * This class controls the simulation of the game
 * 
 * This is a static class where the member variables and methods are static
 */


public class Simulator {
  private static Vector< Pokemon > towerVector = new Vector<>();
  private static int round = 0;
  private static int level = 0;
  private static Scanner in;
  private static Scanner lineScanner;

  // ---------------------------------------------------------------------------
  /**
   * Adds a pokemon to the towerVector;
   */
  public static void add( final Pokemon pokemon){
    towerVector.add(pokemon);
  }
  
  // ---------------------------------------------------------------------------
  
  /**
   * @return An array of tower pokemons from the towerVector.
   */
  public static Vector<Pokemon> getTowerVector(){
    return towerVector;
  }
  
  // ---------------------------------------------------------------------------
  
  public static Vector<String> getTowerVectorInString(){
    Vector<String> stringVec = new Vector<>();
    for (Pokemon pokemon : towerVector) {
      stringVec.add(pokemon.getName());
    }
    return stringVec;
  }
  
//---------------------------------------------------------------------------
  
  public static Pokemon towerAtIndex(int index){
    return towerVector.get(index);
  }
  
  
  /**
   * loadState opens a file and loads the info needed to start a game from a 
   * specific state. 
   * First loads the level
   * Second it reads in the pokemon and its stats
   * 
   * Format must be as follows
   *    Int
   *    String(valid pokemon name) String(valid type) Int Int Int Int Double 
   * 
   * @param inputFile
   * @return
   */
  public static void loadState( File inputFile ){
    if (inputFile == null) {
      return ;
    }
    Vector< Pokemon > towerVector = new Vector<>();
    try {
      in = new Scanner(inputFile);
      
      //read in the level
      if (in.hasNextLine()) {
        //make sure it is an integer that is read
        try {
          level = in.nextInt(); 
          round = in.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Cannot read this level as an integer ERROR");
        }
      }
      while (in.hasNextLine()) {
        try {
          String line = in.nextLine();
          lineScanner = new Scanner(line);
          
          String name = lineScanner.next();
          String type = lineScanner.next();
          int hp = Integer.parseInt(lineScanner.next());
          int attack = Integer.parseInt(lineScanner.next());
          int defense = Integer.parseInt(lineScanner.next());
          int speed = Integer.parseInt(lineScanner.next()); 
          double attackRange = Double.parseDouble(lineScanner.next());
          
          Pokemon pokemon = PokemonFactory.createPokemon(name);
          Simulator.add(pokemon);
          
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
      
      
      
      
      
    } catch (Exception e) {
      // TODO: handle exception
    }
    
    
  }
  
  
  // ---------------------------------------------------------------------------
  
  /**
   * Saves the state of the game.
   *    Needs to save:
   *        - towerVector
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
      
      writer.write(String.format("%d %d", level, round));
      writer.newLine();
      
      
      for (Pokemon pokemon : towerVector) {
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
