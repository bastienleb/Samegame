import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/


public class Menu extends JPanel {

    public JButton quitter=new JButton("Quitter");
    public JButton alea=new JButton("Aléatoire");
        public Menu(){
            super();
            this.add(quitter);
            this.add(alea);
            System.out.println("Menu");
        }

@Override
protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    if (this.isOpaque()) {
      secondPinceau.setColor(this.getBackground());
      secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    secondPinceau.setColor(this.getForeground());
    secondPinceau.setColor(new Color(0,255,0));
  }

}
