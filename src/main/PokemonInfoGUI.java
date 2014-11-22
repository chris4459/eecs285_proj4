package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokemon.Pokemon;

public class PokemonInfoGUI extends JFrame{
  private static JPanel picturePanel;
  private static JPanel infoPanel, infoCenterPanel, infoLPanel, infoRPanel;
  private static JPanel infoTitlePanel;
  private static JLabel titleLabel;
  private static JPanel closePanel;
  private static JButton closeButton;
  
  public PokemonInfoGUI(Pokemon pokemon) {
    this.setLayout(new BorderLayout());
    
    //picture (right side) panel
    picturePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    picturePanel.setBorder(new EmptyBorder(0, 0, 0, 20));
    picturePanel.add(pokemon.getPicture());
    
    //info panel
    infoPanel = new JPanel();
    infoPanel.setLayout(new BorderLayout());
    infoTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    infoCenterPanel = new JPanel();
    infoCenterPanel.setLayout(new BoxLayout(infoCenterPanel, BoxLayout.X_AXIS));
    infoLPanel = new JPanel();
    infoLPanel.setLayout(new BoxLayout(infoLPanel, BoxLayout.Y_AXIS));
    infoRPanel = new JPanel();
    infoRPanel.setLayout(new BoxLayout(infoRPanel, BoxLayout.Y_AXIS));
    
    titleLabel = new JLabel(pokemon.getName());
    
//    Font font = titleLabel.getFont();
    Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);
    Font font01 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    titleLabel.setFont(boldFont);
    infoTitlePanel.add(titleLabel);
    infoTitlePanel.setBorder(new EmptyBorder(10, 20, 0, 0));
    
    infoLPanel.add(new JLabel("Type:"));
    infoRPanel.add(new JLabel(pokemon.getType()));
    infoLPanel.add(new JLabel("HP"));
    infoRPanel.add(new JLabel(Integer.toString(pokemon.getHp())));
    infoLPanel.add(new JLabel("Attack:"));
    infoRPanel.add(new JLabel(Integer.toString(pokemon.getAttack())));
    infoLPanel.add(new JLabel("Defense:"));
    infoRPanel.add(new JLabel(Integer.toString(pokemon.getDefense())));
    infoLPanel.add(new JLabel("Speed:"));
    infoRPanel.add(new JLabel(Integer.toString(pokemon.getSpeed())));
    infoLPanel.add(new JLabel("Attack Range:"));
    infoRPanel.add(new JLabel(Double.toString(pokemon.getAttackRange())));
    
    infoLPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
    
    infoCenterPanel.add(infoLPanel);
    infoCenterPanel.add(Box.createRigidArea(new Dimension(30, 0)));
    infoCenterPanel.add(infoRPanel);
    
    infoPanel.add("North", infoTitlePanel);
    infoPanel.add("Center", infoCenterPanel);
    
    
    closePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    closeButton = new JButton("Close");
    closeButton.setPreferredSize(new Dimension(80, 30));
    closeButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
          dispose();
        }
      }
    });
    closePanel.add(closeButton);
    
    
    
    
    
    this.add("East", picturePanel);
    this.add("West", infoPanel);
    this.add("South", closePanel);
    
    
  }
}
