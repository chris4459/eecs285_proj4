package listeners;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exceptions.ImagePathException;
import factory.ImagePathFactory;
import main.GameSimulatorGUI;
import simulate.Simulator;


/*
 * This class is for when an element in theJlist is single clicked.
 * It should make the corresponding image change accordingly to the element.
 * When the list is empty, should display the default image.
 * Else display the corresponding pokemon image
 */
public class ListSelectListener implements ListSelectionListener{
  private static String imagePath;
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting()) {
      return;
    }
    JList<String> theList = (JList<String>)e.getSource();
    if (theList.isSelectionEmpty()) {
      
    }
    else{
      int index = theList.getSelectedIndex();
      setImagePath(Simulator.towerAtIndex(index).getName());
      GameSimulatorGUI.pictureLabel.setIcon(createImageIcon(imagePath));
    }
    
  }
  
  private void setImagePath(String str){
    try {
      imagePath = ImagePathFactory.createImagePath(str);
    } catch (ImagePathException e) {
      e.printStackTrace();
    }
  }
  
  
  private ImageIcon createImageIcon(String path) {
//    System.out.println(path);
    return new ImageIcon(getClass().getClassLoader().getResource(path));
  }
}
