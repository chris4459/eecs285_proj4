package listeners;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exceptions.ImagePathException;
import factory.ImagePathFactory;
import main.GameSimulatorGUI;
import simulate.Simulator;

public class ListSelectListener implements ListSelectionListener{
  private static String imagePath;
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (e.getValueIsAdjusting()) {
      return;
    }
    JList<String> theList = (JList<String>)e.getSource();
    if (theList.isSelectionEmpty()) {
      System.out.println("Empty");
    }
    else{
      int index = theList.getSelectedIndex();
      System.out.println(Simulator.towerAtIndex(index).getName());
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
