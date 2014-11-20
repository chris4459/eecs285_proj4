package listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.GameSimulatorGUI;
import main.NewGameGUI;

public class MenuItemListener implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == GameSimulatorGUI.getStartNewGameItem()) {
      NewGameGUI newGameWin = new NewGameGUI();
    }
    else if(e.getSource() == GameSimulatorGUI.getLoadStateItem()){
      
    }
    else if(e.getSource() == GameSimulatorGUI.getExitGameItem()){
      
    }
  }
}
