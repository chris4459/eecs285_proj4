package exceptions;



public class ImagePathException extends Exception {
  public ImagePathException() {
    System.out.println("ERROR IN IMAGEPATH");
  }
  
  public ImagePathException(String str) {
    System.out.println(str);
  }
}
