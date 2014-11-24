package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import simulate.Simulator;
import main.GameSimulatorGUI;

public class ButtonListener implements ActionListener{
  
  @Override
  public void actionPerformed(ActionEvent e) {
    /*======================================================================*/
    /*======================= Simulation Buttons ===========================*/
    /*======================================================================*/
    //Start Simulation
    if (e.getSource() == GameSimulatorGUI.getStartButton()){
      
      // make sure that if list is empty tell the player to start a new game
      // or load a state
      if (Simulator.getTowerVector().size() == 0) {
        JOptionPane.showMessageDialog(null, 
            "Start a New Game or Load a State before Starting the Game!",
            "Error", JOptionPane.WARNING_MESSAGE);
      }
      else{
        GameSimulatorGUI.getStartButton().setEnabled(false);
        GameSimulatorGUI.getPauseButton().setEnabled(true);
        GameSimulatorGUI.getResetButton().setEnabled(false);
      }
      
    }
    else if(e.getSource() == GameSimulatorGUI.getPauseButton()){
      
      GameSimulatorGUI.getPauseButton().setEnabled(false);
      GameSimulatorGUI.getResumeButton().setEnabled(true);
      GameSimulatorGUI.getResetButton().setEnabled(true);
    }
    else if(e.getSource() == GameSimulatorGUI.getResumeButton()){
      GameSimulatorGUI.getResumeButton().setEnabled(false);
      GameSimulatorGUI.getPauseButton().setEnabled(true);
      GameSimulatorGUI.getResetButton().setEnabled(false);
    }
    else if(e.getSource() == GameSimulatorGUI.getResetButton()){
      GameSimulatorGUI.getStartButton().setEnabled(true);
      GameSimulatorGUI.getPauseButton().setEnabled(false);
      GameSimulatorGUI.getResumeButton().setEnabled(false);
    }
    
    
  }

}
