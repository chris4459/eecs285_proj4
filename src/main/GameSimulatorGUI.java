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
  public static DefaultListModel<String> towerListModel;
  private static JList<String> towerList;
  private static JSplitPane towerSplitPane;
  public static JLabel pictureLabel;
  
  private static Cursor cursor;

  //Constructor
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
    gameNorthPanel.add(levelLabel);
    gameNorthPanel.add(levelTextField); 
    gameNorthPanel.add(roundLabel);
    gameNorthPanel.add(roundTextField);
    
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
    livesTextField = new JTextField("0",3);
    livesTextField.setEditable(false);
    
    scoreLabel = new JLabel("Score:");
    scoreTextField = new JTextField("0",5);
    scoreTextField.setEditable(false);
    
    moneyLabel = new JLabel("Money($):");
    moneyTextField = new JTextField("0",5);
    moneyTextField.setEditable(false);
    
    infoPanel.add(livesLabel);
    infoPanel.add(livesTextField);
    infoPanel.add(scoreLabel);
    infoPanel.add(scoreTextField);
    infoPanel.add(moneyLabel);
    infoPanel.add(moneyTextField);
    
    //list
    towerListPanel = new JPanel();
    
    towerListModel = new DefaultListModel<>();
    towerList = new JList<>(towerListModel);
    towerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    towerList.setSelectedIndex(0);
    towerList.setVisibleRowCount(20);
    towerList.addMouseListener(new ListListener());
    towerList.addListSelectionListener(new ListSelectListener());
    JScrollPane towerListScrollPane = new JScrollPane(towerList);
    towerListScrollPane.setPreferredSize(new Dimension(350,200));
    towerListPanel.add(towerListScrollPane);
    
    //picture for list
    setImagePath("Default");
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

/*===========================================================================*/
/*=========================== Additional Functions ==========================*/  
/*===========================================================================*/  

  /**
   * For the file menu in menu bar
   *    -Start New Game-
   * @return JMenuItem startNewGameItem
   */
  public static JMenuItem getStartNewGameItem() {
    return startNewGameItem;
  }
  
  /**
   * For the file menu in menu bar
   *    -Save State-
   * @return JMenuItem saveStateItem
   */
  public static JMenuItem getSaveStateItem() {
    return saveStateItem;
  }
  
  /**
   * For the file menu in menu bar
   *    -Load State-
   * @return JMenuItem loadStateItem
   */
  public static JMenuItem getLoadStateItem() {
    return loadStateItem;
  }
  
  /**
   * For the file menu in menu bar
   *    -Exit Game-
   * @return
   */
  public static JMenuItem getExitGameItem() {
    return exitGameItem;
  }
  
  /**
   * Needed when loading a state
   *    Sets round
   * @param round
   */
  public static void setRound(int round){
    roundTextField.setText(Integer.toString(round));
  }
  
  /**
   * Needed when saving a state
   *    Gets round in int
   * @return 
   */
  public static int getRound(){
    return Integer.parseInt(roundTextField.getText());
  }
  
  /**
   * Needed when loading a state
   * @param level
   */
  public static void setLevel(int level){
    levelTextField.setText(Integer.toString(level));
  }
  
  /**
   * Needed when saving a state
   * @return
   */
  public static int getLevel(){
    return Integer.parseInt(levelTextField.getText());
  }
  
  /**
   * Needed when loading a state
   * @param lives
   */
  public static void setLives(int lives){
    livesTextField.setText(Integer.toString(lives));
  }
  
  /**
   * Needed when saving a state
   * @return
   */
  public static int getLives(){
    return Integer.parseInt(livesTextField.getText());
  }
  
  /**
   * Needed when loading a state
   * @param score
   */
  public static void setScore(int score){
    scoreTextField.setText(Integer.toString(score));
  }
  
  /**
   * Needed when saving a state
   * @return
   */
  public static int getScore(){
    return Integer.parseInt(scoreTextField.getText());
  }
  
  /**
   * Needed when loading a state
   * @param money
   */
  public static void setMoney(int money){
    moneyTextField.setText(Integer.toString(money));
  }
  
  /**
   * Needed when saving a state
   * @return
   */
  public static int getMoney(){
    return Integer.parseInt(moneyTextField.getText());
  }
  
  
  /**
   * Finds the image from str and sets the imagePath
   * @param str
   */
  private void setImagePath(String str){
    try {
      imagePath = ImagePathFactory.createImagePath(str);
    } catch (ImagePathException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * From the imagePath, returns the imageIcon
   * @param path
   * @return
   */
  private ImageIcon createImageIcon(String path) {
    return new ImageIcon(getClass().getClassLoader().getResource(path));
  }
  
  
  
}
