import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    

    JPanel panneau = new JPanel();
    Actionmenu m = new Actionmenu(panneau);
    

    public Menu(){
        super("SameGame");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton aleatoire = new JButton("al\u00e9atoire");
        aleatoire.addActionListener(m);
        panneau.add(aleatoire);
        JButton bouton2 = new JButton("default");
        panneau.add(bouton2);
        bouton2.addActionListener(m);

        JButton bouton3 = new JButton("quitter");
        panneau.add(bouton3);
        bouton3.addActionListener(m);
        
        this.add(panneau);
        this.setVisible(true);
    }
   
}
