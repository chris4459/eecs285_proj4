package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Squirtle;
import simulate.Simulator;
import exceptions.ImagePathException;
import factory.ImagePathFactory;

public class NewGameGUI extends JFrame implements ActionListener{
  private static JLabel pickStarterLabel;
  private static JRadioButton bulbasaurButton;
  private static JRadioButton charmanderButton;
  private static JRadioButton squirtleButton;
  private static JRadioButton pikachuButton;
  
  private static JLabel picture;
  private String imagePath;
  
  private static JButton confirmButton;
  private static JButton cancelButton;
  
  private static int reply;
  
  
  public NewGameGUI() {
    initialize();
    this.setLayout(new BorderLayout());
    
    /*============================= Top Panel ==============================*/
    /*======================================================================*/
    
    JPanel topPanel = new JPanel();
    
    pickStarterLabel = new JLabel("Pick A Starter");
    topPanel.add(pickStarterLabel);
    topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    
    /*========================== Center Panel ==============================*/
    /*======================================================================*/
    
    JPanel centerPanel = new JPanel();
    
    bulbasaurButton = new JRadioButton("Bulbasaur");
    bulbasaurButton.setSelected(true);
    bulbasaurButton.addActionListener(this);
    charmanderButton = new JRadioButton("Charmander");
    charmanderButton.addActionListener(this);
    squirtleButton = new JRadioButton("Squirtle");
    squirtleButton.addActionListener(this);
    pikachuButton = new JRadioButton("Pikachu");
    pikachuButton.addActionListener(this);
    
    
    ButtonGroup group = new ButtonGroup();
    
    group.add(bulbasaurButton);
    group.add(charmanderButton);
    group.add(squirtleButton);
    group.add(pikachuButton);
    
    centerPanel.add(bulbasaurButton);
    centerPanel.add(charmanderButton);
    centerPanel.add(squirtleButton);
    centerPanel.add(pikachuButton);
    
    //set initial picture to bulbasaur    
    setImagePath("BulbasaurIcon");
    picture = new JLabel(createImageIcon(imagePath));
    
    centerPanel.add(picture);
    
    
    /*========================== Bottom Panel  =============================*/
    /*======================================================================*/
    
    JPanel bottomPanel = new JPanel();
    confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        reply = JOptionPane.showConfirmDialog(null, 
            "Are you sure you want this starter?", "Confirmation", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
          if (bulbasaurButton.isSelected()) {
            //remove all towers
            Simulator.removeAllTowers();
            GameSimulatorGUI.towerListModel.removeAllElements();
            
            Pokemon bulbasaur = new Bulbasaur();
            GameSimulatorGUI.towerListModel.addElement(bulbasaur.getName());
            Simulator.add(bulbasaur);
            
            JOptionPane.showMessageDialog(null, 
                bulbasaurButton.getActionCommand() + " is your starter");
          }
          else if (charmanderButton.isSelected()) {
            //remove all towers
            Simulator.removeAllTowers();
            GameSimulatorGUI.towerListModel.removeAllElements();
            
            Pokemon charmander = new Charmander();
            GameSimulatorGUI.towerListModel.addElement(charmander.getName());
            Simulator.add(charmander);
            
            JOptionPane.showMessageDialog(null, 
                charmanderButton.getActionCommand() + " is your starter");
          }
          else if (squirtleButton.isSelected()) {
            //remove all towers
            Simulator.removeAllTowers();
            GameSimulatorGUI.towerListModel.removeAllElements();
            
            Pokemon squirtle = new Squirtle();
            GameSimulatorGUI.towerListModel.addElement(squirtle.getName());
            Simulator.add(squirtle);
            
            JOptionPane.showMessageDialog(null, 
                squirtleButton.getActionCommand() + " is your starter");
          }
          else if (pikachuButton.isSelected()) {
            //remove all towers
            Simulator.removeAllTowers();
            GameSimulatorGUI.towerListModel.removeAllElements();
            
            Pokemon pikachu = new Pikachu();
            GameSimulatorGUI.towerListModel.addElement(pikachu.getName());
            Simulator.add(pikachu);
            
            JOptionPane.showMessageDialog(null, 
                pikachuButton.getActionCommand() + " is your starter");
          }
        }
        dispose();
        
      }
    });
    
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    
    bottomPanel.add(confirmButton);
    bottomPanel.add(cancelButton);
    
    /*=========================== Main Frame  ==============================*/
    /*======================================================================*/
    
    
    this.add("North", topPanel);
    this.add("Center", centerPanel);
    this.add("South", bottomPanel);
    
    
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bulbasaurButton) {
      
      
      setImagePath("BulbasaurIcon");
      picture.setIcon(createImageIcon(imagePath));
    }
    else if (e.getSource() == charmanderButton) {
      setImagePath("CharmanderIcon");
      picture.setIcon(createImageIcon(imagePath));      
    }
    else if (e.getSource() == squirtleButton) {
      setImagePath("SquirtleIcon");
      picture.setIcon(createImageIcon(imagePath)); 
    }
    else if (e.getSource() == pikachuButton) {
      setImagePath("PikachuIcon");
      picture.setIcon(createImageIcon(imagePath)); 
    }
  }
  
  /**
   * Initializes the frame for this class
   */
  private void initialize(){
    this.setMinimumSize(new Dimension(400,200));
    this.setBounds(200, 250, 0, 0);
    this.setTitle("Pick A Starter");
    this.setVisible(true);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.pack();
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
