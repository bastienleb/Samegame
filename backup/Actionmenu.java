import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
@author Kévin METRI et Bastien LEBLET
*/


public class Actionmenu implements ActionListener {
  
  JPanel pagemenu;
  public char tab[][]=new char[10][15];
  
  public Actionmenu(JPanel panel){
    this.pagemenu=panel; 
    //Menu m = new Menu();
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
        

        new Menu().fermer();
        AffichageGrille affiche=new AffichageGrille(tab);
        affiche.ImageJeu();

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
