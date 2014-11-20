package main;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listeners.MenuItemListener;

public class GameSimulatorGUI extends JFrame{
  
  private static JMenuBar menuBar;
  private static JMenu fileMenu;
  static JMenuItem startNewGameItem;
  static JMenuItem loadStateItem;
  static JMenuItem exitGameItem;
  
  
  
  private static JLabel background_label;
  private static JPanel center, towerPanel, towerPanelTop, towerPanelBottom;
  private static JLabel money_label, lives_label;
  private static JButton bulbTower, pikaTower, charTower, squirtTower;
  private static ImageIcon bulbIcon, pikaIcon, charIcon, squirtIcon;
  private static Cursor cursor;
  
  
  public GameSimulatorGUI() {
    super("Pokemon Tower Defense");
    this.setLayout(new BorderLayout());
    
    /*============================== Menu Bar ==============================*/
    /*======================================================================*/
    menuBar = new JMenuBar();
    
    fileMenu = new JMenu("File");
    startNewGameItem = new JMenuItem("Start New Game");
    startNewGameItem.addActionListener(new MenuItemListener());
    loadStateItem = new JMenuItem("Load State");
    loadStateItem.addActionListener(new MenuItemListener());
    exitGameItem = new JMenuItem("Exit Game");
    exitGameItem.addActionListener(new MenuItemListener());
    
    //Add items to Menu
    fileMenu.add(startNewGameItem);
    fileMenu.add(loadStateItem);
    fileMenu.add(exitGameItem);
    
    //Add menu to menuBar
    menuBar.add(fileMenu);
    
    //Add menuBar to Jframe
    this.setJMenuBar(menuBar);
    
    
    
    
    
    
  }


  public static JMenuItem getStartNewGameItem() {
    return startNewGameItem;
  }
  
  public static JMenuItem getLoadStateItem() {
    return loadStateItem;
  }
  
  public static JMenuItem getExitGameItem() {
    return exitGameItem;
  }
  
  
  
}
