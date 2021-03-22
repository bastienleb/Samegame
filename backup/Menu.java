import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    JPanel titre = new JPanel();
    JPanel logo = new JPanel();
    JLabel nomjeu = new JLabel("SameGame");
    Actionmenu m = new Actionmenu(panneau);
    int validation=0;
    
    
    public Menu(){
        super("SameGame");
        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout grillage = new GridLayout(3,1);
        this.setLayout(grillage);

        JButton aleatoire = new JButton("Al\u00e9atoire");
        aleatoire.addActionListener(m -> {
            Grille grille=new Grille();
            grille.RecupTabAlea();
            grille.ImageJeu();
            this.dispose();
        });
        aleatoire.setFont(new Font("Sérif",Font.BOLD,15));
        panneau.add(aleatoire);


        JButton bouton2 = new JButton("Choix fichier");
        bouton2.addActionListener(m -> {
            Grille grille=new Grille();
            validation = grille.RecupTabChoix();
            System.out.println(validation+" dans menu");
            if(validation==0){
                grille.ImageJeu();
            }
            this.dispose();
        });
        bouton2.setFont(new Font("Sérif",Font.BOLD,15));
        panneau.add(bouton2);
        bouton2.addActionListener(m);

        JButton bouton3 = new JButton("Quitter");
        bouton3.setFont(new Font("Sérif",Font.BOLD,15));
        panneau.add(bouton3);
        bouton3.addActionListener(m);

        nomjeu.setFont(new Font("Sérif",Font.BOLD,45));
        titre.add(nomjeu);


        ImageIcon icone = new ImageIcon("../image/jeu.png");
        JLabel jlabel = new JLabel(icone, JLabel.CENTER);
        logo.add(jlabel);

    
        titre.setBackground(new Color(0,128,128));
        panneau.setBackground(new Color(0,128,128));
        logo.setBackground(new Color(0,128,128));

        this.add(titre);
        this.add(panneau);
        this.add(logo);
        this.setVisible(true);
    }   
}