package pokemon;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import exceptions.ImagePathException;
import factory.ImagePathFactory;

public abstract class Pokemon implements Cloneable{
  //Variables
  private int hp;
  private final int attack;
  private final int defense;
  private final int speed;
  private final String name;
  private final String type;
  private final double attackRange;
  private String imagePath;
  private JLabel picture;
  
  // ---------------------------------------------------------------------------
  // Constructor
  Pokemon(String name, String type, int hp, int attack, int defense, int speed, 
      double attackRange)
  {
    this.name = name;
    this.type = type;
    this.hp = hp;
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    this.attackRange = attackRange;
    
    setImagePath(this.name);
    
    
    
    picture = new JLabel(createImageIcon(imagePath));
    
  }
  //---------------------------------------------------------------------------
  
  /**
   * @return A cloned Pokemon if error is throw return null;
   */
  public Object clone() throws CloneNotSupportedException{
    return super.clone();
  }

  // ---------------------------------------------------------------------------
  
  public String getName() {
    return name;
  }
  
  public String getType(){
    return type;
  }
  
  public int getHp() {
    return hp;
  }
  
  public int getAttack() {
    return attack;
  }
  
  public int getDefense() {
    return defense;
  }
  
  public int getSpeed() {
    return speed;
  }
  
  public double getAttackRange() {
    return attackRange;
  }
  
  public void setHp(int hp) {
    this.hp = hp;
  }
  
  /**
   * Returns the JLabel of the picture for the pokemon
   * @return JLabel 
   */
  public JLabel getPicture() {
    return picture;
  }

  @Override
  public String toString()
  {
    return String.format("Pokemon: %s \n\tHP: %d\n\tAttack: %d\n\t"
        + "Defense: %d\n\tAttack Range: %f", 
        getName(), getHp(), getAttack(), getDefense(), getAttackRange());
  }
  
  /**
   * Set the image Path
   * @param str
   */
  private void setImagePath(String str){
    try {
      imagePath = ImagePathFactory.createImagePath(str);
    } catch (ImagePathException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Creates the image icon and returns it
   * @param path
   * @return
   */
  private ImageIcon createImageIcon(String path) {
//    System.out.println(path);
    return new ImageIcon(getClass().getClassLoader().getResource(path));
  }


  // ---------------------------------------------------------------------------
}