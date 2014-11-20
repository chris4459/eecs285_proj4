package factory;

import pokemon.Pokemon;
import pokemon.Rattata;

public class PokemonFactory {
  
  
  public static Pokemon createPokemon(String name) throws Exception{
    
    switch ( name ) {
    case "Rattata":
      return new Rattata();

    default:
      throw new Exception();
    }
    
  }
  
  
}
