import javax.swing.*;
import java.awt.event.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a la detection des action de la page de fin
*/

public class ActionFin implements ActionListener{
    JFrame f = new JFrame();

    public ActionFin(JFrame frame){
        this.f=frame; 
    }

    public void actionPerformed(ActionEvent evt) {
      
        String composant = evt.getActionCommand();
        
  
        if (composant.equals("REJOUER")) {
            f.dispose();
            new Menu();

        }
        if (composant.equals("QUITTER")) {
            System.exit(0);
        }
     }
}
