import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
@author Kévin METRI et Bastien LEBLET
*/


public class Actionmenu implements ActionListener {
  
  JPanel pagemenu;
  
  public Actionmenu(JPanel panel){
    this.pagemenu=panel; 


  }
  
 
    public void actionPerformed(ActionEvent evt) {
      
      String composant = evt.getActionCommand();
      

      if (composant == "Al\u00e9atoire") {
       Grille grille= new Grille();
       grille.AfficheGrille();

          System.out.println(composant);
      }
      if (composant == "D\u00e9fault") {
          System.out.println(composant);
      }
      if (composant == "Quitter") {
        System.exit(0);
          System.out.println(composant);
      }
   }
}
