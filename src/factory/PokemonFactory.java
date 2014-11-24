package factory;

import pokemon.Bulbasaur;
import pokemon.Caterpie;
import pokemon.Charmander;
import pokemon.Geodude;
import pokemon.Pidgey;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Rattata;
import pokemon.Squirtle;

public class PokemonFactory {
  
  
  public static Pokemon createPokemon(String name) throws Exception{
    
    switch ( name ) {
    case "Bulbasaur":
      return new Bulbasaur();
    case "Chamander":
      return new Charmander();
    case "Squirtle":
      return new Squirtle();
    case "Caterpie":
      return new Caterpie();
    case "Pidgey":
      return new Pidgey();
    case "Rattata":
      return new Rattata();
    case "Pikachu":
      return new Pikachu();
    case "Geodude":
      return new Geodude();
    
    default:
      throw new Exception();
    }
    
  }
  
  
}
