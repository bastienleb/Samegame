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
  
    public JButton quitter=new JButton("Quitter");
    public JButton alea=new JButton("Aléatoire");

    public void actionPerformed(ActionEvent evt) {
      
      String composant = evt.getActionCommand();
      

      if (composant == "al\u00e9atoire") {
          System.out.println(composant);
      }
      if (composant == "default") {
          System.out.println(composant);
      }
      if (composant == "quitter") {
          System.out.println(composant);
      }
   }
}
