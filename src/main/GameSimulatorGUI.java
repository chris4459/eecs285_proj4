package main;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import exceptions.ImagePathException;
import factory.ImagePathFactory;
import listeners.MenuItemListener;

public class GameSimulatorGUI extends JFrame{
  
  //Menu Bar GUI
  private static JMenuBar menuBar;
  private static JMenu fileMenu;
  static JMenuItem startNewGameItem;
  static JMenuItem saveStateItem;
  static JMenuItem loadStateItem;
  static JMenuItem exitGameItem;
  
  //Game Screen GUI
  private static JLabel background_label;
  private String imagePath;
  private static JPanel gamePanel, gameButtonPanel;
  private static JButton startButton;
  private static JButton pauseButton;
  private static JButton resumeButton;
  private static JButton resetButton;
  
  
  
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
    saveStateItem = new JMenuItem("Save State");
    saveStateItem.addActionListener(new MenuItemListener());
    loadStateItem = new JMenuItem("Load State");
    loadStateItem.addActionListener(new MenuItemListener());
    exitGameItem = new JMenuItem("Exit Game");
    exitGameItem.addActionListener(new MenuItemListener());
    
    //Add items to Menu
    fileMenu.add(startNewGameItem);
    fileMenu.add(saveStateItem);
    fileMenu.add(loadStateItem);
    fileMenu.add(exitGameItem);
    
    //Add menu to menuBar
    menuBar.add(fileMenu);
    
    //Add menuBar to Jframe
    this.setJMenuBar(menuBar);
    
    
    /*======================= Game Screen GUI ==============================*/
    /*======================================================================*/
    gamePanel = new JPanel(new BorderLayout());
    gameButtonPanel = new JPanel();
    
    //Game image
    setImagePath("Route 1");
    background_label = new JLabel(createImageIcon(imagePath));
    gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 0));
    
    //Game Buttons
    startButton = new JButton("Start Game");
    pauseButton = new JButton("Pause Game");
    pauseButton.setEnabled(false);
    resumeButton = new JButton("Resume Game");
    resumeButton.setEnabled(false);
    resetButton = new JButton("Reset");
    
    gameButtonPanel.add(startButton);
    gameButtonPanel.add(pauseButton);
    gameButtonPanel.add(resumeButton);
    gameButtonPanel.add(resetButton);
    
    gamePanel.add("Center", background_label);
    gamePanel.add("South", gameButtonPanel);
    
    
    /*======================= Control Screen GUI ===========================*/
    /*======================================================================*/
    
    
    
    
    
    /*============================ Main Screen =============================*/
    /*======================================================================*/
    
    this.add("West", gamePanel);
    
  }


  public static JMenuItem getStartNewGameItem() {
    return startNewGameItem;
  }
  
  public static JMenuItem getSaveStateItem() {
    return saveStateItem;
  }
  
  public static JMenuItem getLoadStateItem() {
    return loadStateItem;
  }
  
  public static JMenuItem getExitGameItem() {
    return exitGameItem;
  }
  
  private void setImagePath(String str){
    try {
      imagePath = ImagePathFactory.createImagePath(str);
    } catch (ImagePathException e) {
      e.printStackTrace();
    }
  }
  
  
  private ImageIcon createImageIcon(String path) {
    System.out.println(path);
    return new ImageIcon(getClass().getClassLoader().getResource(path));
  }
  
  
  
}
