import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    Actionmenu m = new Actionmenu(panneau);
    

    public Menu(){
        super("SameGame");
        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        System.out.println("dans le menu");

        JButton aleatoire = new JButton("Al\u00e9atoire");
        aleatoire.addActionListener(m);
        panneau.add(aleatoire);
        JButton bouton2 = new JButton("D\u00e9fault");
        panneau.add(bouton2);
        bouton2.addActionListener(m);

        JButton bouton3 = new JButton("Quitter");
        panneau.add(bouton3);
        bouton3.addActionListener(m);
        
        this.add(panneau);
        this.setVisible(true);
    }

    public void fermer(){
        System.out.println("dans la fonction qui ferme");
        this.dispose();
    }
   
}
