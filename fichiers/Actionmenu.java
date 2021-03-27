import javax.swing.*;
import java.awt.event.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a la detection des action de la page du menu
*/


public class Actionmenu implements ActionListener {
  
  JPanel pagemenu;
  JFrame framemenu;
  public char tab[][]=new char[10][15];
  int validation=0;
  
  public Actionmenu(JPanel panel,JFrame frame){
    this.pagemenu=panel; 
    this.framemenu=frame;
  }
  
  public Actionmenu(char tab[][]){
    this.tab=tab;
  }
  
  public void actionPerformed(ActionEvent evt) {
    String composant = evt.getActionCommand();
    
    if (composant.equals("Al\u00e9atoire")) {
      Grille grille=new Grille();
      grille.RecupTabAlea();
      grille.ImageJeu();
      framemenu.dispose();
    }
    
    if (composant.equals("Choix fichier")) {
      Grille grille=new Grille();
      validation = grille.RecupTabChoix();
      if(validation==0){
          grille.ImageJeu();
      }
      framemenu.dispose();
    }

    if (composant.equals("Quitter")) {
      System.exit(0);
    }
  } 
}