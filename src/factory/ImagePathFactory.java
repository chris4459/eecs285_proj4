package factory;

import exceptions.ImagePathException;

/**
 * This a Factory Method Class for creating a file path to an image.
 */
public class ImagePathFactory
{
  /**
   * Creates a path to a pokemon image
   *
   * @param type
   *     The type of image you want to find the path for.
   *
   * @return The path of the image.
   *
   * @throws exceptions.ImagePathException
   *     Occurs when the type isn't recognized.
   */
  public static String createImagePath( String name ) throws ImagePathException
  {
    switch ( name )
    {
      
      case "Bulbasaur":
        return "images/bulbasaur.png";
      case "Charmander":
        return "images/charmander.png";
      case "Squirtle":
        return "images/squirtle.png";
      case "Pikachu":
        return "images/pikachu.png";
      case "Caterpie":
        return "images/caterpie.png";
      case "Pidgey":
        return "images/pidgey.png";
      case "Rattata":
        return "images/rattata.png";
      case "Geodude":
        return "images/geodude.png";
      default:
        throw new ImagePathException();
    }
  }

  // ---------------------------------------------------------------------------
}
