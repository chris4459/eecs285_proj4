package util;

public enum Type {
  NORMAL("Normal"),
  FIRE("Fire"),
  WATER("Water"),
  GRASS("Grass"),
  ELECTRIC("Electric");
  
  private final String str;
  
  private Type(String s){
    str = s;
  }
  
  public String toString() {
    return str;
  }
}
