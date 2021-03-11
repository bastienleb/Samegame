import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    int valeur;
    Actionmenu m = new Actionmenu(panneau);
    
    
    public Menu(int tmp){
        super("SameGame");
        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        System.out.println("dans le menu "+valeur);

        JButton aleatoire = new JButton("Al\u00e9atoire");
        aleatoire.addActionListener(m -> {
            Grille grille=new Grille();
            grille.AfficheGrille();
            grille.ImageJeu();
            this.dispose();
        });
        panneau.add(aleatoire);

        JButton bouton2 = new JButton("D\u00e9fault");
        panneau.add(bouton2);
        bouton2.addActionListener(m);

        JButton bouton3 = new JButton("Quitter");
        panneau.add(bouton3);
        bouton3.addActionListener(m);

        this.valeur=tmp;
        
        if(valeur == 1){
            this.dispose();
            System.out.println("c fermer");
        }
        
        panneau.setBackground(new Color(0,128,128));
        this.add(panneau);
        this.setVisible(true);
    }   
}
