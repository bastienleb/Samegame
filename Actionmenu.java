import javax.swing.*;
import java.awt.event.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a la detection des action de la page du menu
*/

public class Actionmenu implements MouseListener {
  
  JFrame framemenu;
  public char tab[][]=new char[10][15];
  int validation=0;
  
  public Actionmenu(JFrame frame){
    this.framemenu=frame;
  }
  
  
  @Override
  public void mouseClicked(MouseEvent e){
    if((e.getX()>120 && e.getX()<337) &&(e.getY()>500 && e.getY()<600)){  // ZONE FICHIER
      Grille grille=new Grille();
      grille.setVisible(false);
      validation = grille.RecupTabChoix();
      if(validation==0){
        grille.setVisible(true);
        grille.ImageJeu();
      }
      framemenu.dispose();
    }

    if((e.getX()>415 && e.getX()<625) &&(e.getY()>490 && e.getY()<600)){  // ZONE ALEATOIRE
      Grille grille=new Grille();
      grille.RecupTabAlea();
      grille.ImageJeu();
      framemenu.dispose();
    }

    if((e.getX()>720 && e.getX()<935) &&(e.getY()>490 && e.getY()<600)){ // ZONE QUITTER
      framemenu.dispose();
    }
    
  }

  public void mousePressed(MouseEvent e){}
  public void mouseExited(MouseEvent e) {}
  public void mouseEntered(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
}