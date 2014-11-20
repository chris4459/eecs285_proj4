package factory;

import pokemon.Pokemon;
import pokemon.Rattata;

public class PokemonFactory {
  
  
  public static Pokemon createPokemon(String name, int hp, int attack, 
      int defense, int speed, double attackRange) throws Exception{
    
    switch ( name ) {
    case "Rattata":
      return new Rattata(name, hp, attack, defense, speed, attackRange);

    default:
      throw new Exception();
    }
    
  }
  
  
}
