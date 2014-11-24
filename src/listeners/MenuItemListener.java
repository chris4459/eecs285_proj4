package listeners;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import pokemon.Pokemon;
import simulate.Simulator;
import main.BuyTowerGUI;
import main.GameSimulatorGUI;
import main.MainFile;
import main.NewGameGUI;

public class MenuItemListener implements ActionListener{
  private JFileChooser chooser;
  private int chooserReturn;
  File chosenFile;
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == GameSimulatorGUI.getStartNewGameItem()) {
      NewGameGUI newGameWin = new NewGameGUI();
    }
    else if(e.getSource() == GameSimulatorGUI.getSaveStateItem()){
      chooser = new JFileChooser();
      chooser.setDialogTitle("Save State");
      chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
      chooserReturn = chooser.showSaveDialog(MainFile.win);
      
      if (chooserReturn == JFileChooser.APPROVE_OPTION) {
        chosenFile = chooser.getSelectedFile();
        try {
          Simulator.saveState(chosenFile);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
      
    }
    else if(e.getSource() == GameSimulatorGUI.getLoadStateItem()){
      chooser = new JFileChooser();
      chooser.setDialogTitle("Load State");
      chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
      chooserReturn = chooser.showOpenDialog(MainFile.win);
      
      if (chooserReturn == JFileChooser.APPROVE_OPTION) {
        chosenFile = chooser.getSelectedFile();
        
        //remove all towers 
        Simulator.removeAllTowers();
        GameSimulatorGUI.towerListModel.removeAllElements();
        
        try {
          Simulator.loadState(chosenFile);
        } catch (Exception e2) {
          // TODO: handle exception
        }
        
        Vector< Pokemon > pokemons = Simulator.getTowerVector();
        for (Pokemon pokemon : pokemons) {
          GameSimulatorGUI.towerListModel.addElement(pokemon.getName());
        }
        
      }
      
    }
    else if(e.getSource() == GameSimulatorGUI.getExitGameItem()){
      System.exit(0);
    }
    else if(e.getSource() == GameSimulatorGUI.getBuyTowerItem()){
      BuyTowerGUI buyTowerGUI = new BuyTowerGUI();
    }
    
  }
}
