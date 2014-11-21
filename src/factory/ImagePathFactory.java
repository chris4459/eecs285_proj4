package factory;

import javax.swing.ImageIcon;

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
      case "BulbasaurIcon":
        return "images/bulbasaurIcon.gif";
      case "Charmander":
        return "images/charmander.png";
      case "CharmanderIcon":
        return "images/charmanderIcon.gif";
      case "Squirtle":
        return "images/squirtle.png";
      case "SquirtleIcon":
        return "images/squirtleIcon.gif";
      case "Pikachu":
        return "images/pikachu.png";
      case "PikachuIcon":
        return "images/pikachuIcon.gif";
      case "Caterpie":
        return "images/caterpie.png";
      case "Pidgey":
        return "images/pidgey.png";
      case "Rattata":
        return "images/rattata.png";
      case "Geodude":
        return "images/geodude.png";
      case "Route 1":
        return "images/route1.png";
      default:
        throw new ImagePathException();
    }
  }
 
  // ---------------------------------------------------------------------------
  

  
  // ---------------------------------------------------------------------------
}
