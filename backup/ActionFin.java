import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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
