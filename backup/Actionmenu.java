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
      

      if (composant == "Al\u00e9atoire") {
      // Grille grille= new Grille();
      // grille.AfficherGrille();
      // grille.ImageJeu();
      tmp = 1;
      new Menu(tmp);
        
        AffichageGrille affiche=new AffichageGrille(tab);
        affiche.ImageJeu();
        System.out.println(composant+" "+tmp);
      }

      if (composant == "D\u00e9fault") {
          System.out.println(composant);
      }
      if (composant == "Quitter") {
        System.out.println(composant);
          System.exit(0);
      }
   }

    
}
