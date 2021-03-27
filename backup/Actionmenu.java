import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
@author Kévin METRI et Bastien LEBLET
*/


public class Actionmenu implements ActionListener {
  
  JPanel pagemenu;
  public char tab[][]=new char[10][15];
  int tmp;
  
  public Actionmenu(JPanel panel){
    this.pagemenu=panel; 
  }

  public Actionmenu(char tab[][]){
    this.tab=tab;
  }

  
  
    
    public void actionPerformed(ActionEvent evt) {
      String composant = evt.getActionCommand();
      if (composant.equals("Quitter")) {
          System.exit(0);
      }
   }

    
}