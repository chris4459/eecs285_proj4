package main;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import pokemon.Pokemon;
import simulate.Simulator;
import exceptions.ImagePathException;
import factory.ImagePathFactory;
import listeners.ListListener;
import listeners.ListSelectListener;
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
  private static JLabel backgroundLabel;
  private String imagePath;
  private static JPanel gamePanel, gameButtonPanel, gameNorthPanel;
  private static JButton startButton, pauseButton, resumeButton, resetButton;
  private static JLabel roundLabel, levelLabel;
  private static JTextField roundTextField, levelTextField;
  
  //Control Score GUI
  private static JTextField scoreTextField, moneyTextField, livesTextField;
  private static JLabel scoreLabel, moneyLabel, livesLabel;
  private static JPanel controlPanel, infoPanel, towerListPanel;
  private static JList<String> towerList;
  private static JSplitPane towerSplitPane;
  public static JLabel pictureLabel;
  
  
  
  private static JPanel center, towerPanel, towerPanelTop, towerPanelBottom;
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
    gameNorthPanel = new JPanel();
    
    //Rounds and level
    roundLabel = new JLabel("Round:");
    roundTextField = new JTextField("0", 4);
    roundTextField.setEditable(false);
    levelLabel = new JLabel("Level:");
    levelTextField = new JTextField("0", 4);
    levelTextField.setEditable(false);
    gameNorthPanel.add(roundLabel);
    gameNorthPanel.add(roundTextField);
    gameNorthPanel.add(levelLabel);
    gameNorthPanel.add(levelTextField);
    
    
    //Game image
    setImagePath("Route 1");
    backgroundLabel = new JLabel(createImageIcon(imagePath));
    gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
    
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
    
    gamePanel.add("North", gameNorthPanel);
    gamePanel.add("Center", backgroundLabel);
    gamePanel.add("South", gameButtonPanel);
    
    
    /*======================= Control Screen GUI ===========================*/
    /*======================================================================*/
    controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
    infoPanel = new JPanel();
    infoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    livesLabel = new JLabel("Lives:");
    livesTextField = new JTextField("??",4);
    livesTextField.setEditable(false);
    
    scoreLabel = new JLabel("Score:");
    scoreTextField = new JTextField("0",6);
    scoreTextField.setEditable(false);
    
    moneyLabel = new JLabel("Money:");
    moneyTextField = new JTextField("$0",6);
    moneyTextField.setEditable(false);
    
    infoPanel.add(livesLabel);
    infoPanel.add(livesTextField);
    infoPanel.add(scoreLabel);
    infoPanel.add(scoreTextField);
    infoPanel.add(moneyLabel);
    infoPanel.add(moneyTextField);
    

    
    //list
    towerListPanel = new JPanel();
    
    towerList = new JList<>(Simulator.getTowerVectorInString());
    towerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    towerList.setSelectedIndex(0);
    towerList.setVisibleRowCount(20);
    towerList.addMouseListener(new ListListener());
    towerList.addListSelectionListener(new ListSelectListener());
    JScrollPane towerListScrollPane = new JScrollPane(towerList);
    towerListScrollPane.setPreferredSize(new Dimension(350,200));
    towerListPanel.add(towerListScrollPane);
    
    //picture for list
    setImagePath("Bulbasaur");
    pictureLabel = new JLabel(createImageIcon(imagePath));
    
    
    towerSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
        towerListPanel, pictureLabel);
    towerSplitPane.setPreferredSize(new Dimension(350, 500));
    towerSplitPane.setEnabled(false);
    towerSplitPane.setBorder(new EmptyBorder(30, 0, 20, 0));
    
    
    
    controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    controlPanel.add(infoPanel);
//    controlPanel.add(Box.createRigidArea(new Dimension(0, 0)));
    controlPanel.add(towerSplitPane);
    
    
    
    
    
    /*============================ Main Screen =============================*/
    /*======================================================================*/
    
    this.add("West", gamePanel);
    this.add("East", controlPanel);
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
//    System.out.println(path);
    return new ImageIcon(getClass().getClassLoader().getResource(path));
  }
  
  
  
}
