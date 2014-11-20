package pokemon;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import exceptions.ImagePathException;
import factory.ImagePathFactory;

public abstract class Pokemon implements Cloneable{
  //Variables
  private static int hp;
  private final int attack;
  private final int defense;
  private final int speed;
  private final String name;
  private final String type;
  private final double attackRange;
  private ImageIcon img;
  private String filePath;
  private JLabel imgLabel;
  
  // ---------------------------------------------------------------------------
  // Constructor
  Pokemon(String name, String type, int hp, int attack, int defense, int speed, 
      double attackRange)
  {
    this.name = name;
    this.type = type;
    Pokemon.hp = hp;
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    this.attackRange = attackRange;
    
    try {
      filePath = ImagePathFactory.createImagePath(name);
      System.out.println("Filepath: " + filePath);
    } catch (ImagePathException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    img = new ImageIcon(getClass().getClassLoader().getResource(filePath));
    imgLabel = new JLabel();
    imgLabel.setIcon(img);
    
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
  
  public static int getHp() {
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
  
  public static void setHp(int hp) {
    Pokemon.hp = hp;
  }

  @Override
  public String toString()
  {
    return String.format("Pokemon: %s \n\tHP: %d\n\tAttack: %d\n\t"
        + "Defense: %d\n\tAttack Range: %f", 
        getName(), Pokemon.hp, getAttack(), getDefense(), getAttackRange());
  }


  // ---------------------------------------------------------------------------
}