import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher la page du menu 
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    JPanel titre = new JPanel();
    JPanel logo = new JPanel();
    JLabel nomjeu = new JLabel("SameGame");
    Actionmenu m = new Actionmenu(panneau,this);
    
    
    public Menu(){
        super("SameGame");
        this.setSize(750,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout grillage = new GridLayout(3,1);
        this.setLayout(grillage);

        JButton aleatoire = new JButton("Al\u00e9atoire");
        aleatoire.addActionListener(m);
        aleatoire.setFont(new Font("Sérif",Font.BOLD,20));
        aleatoire.setBackground(new Color(186,22,28));
        aleatoire.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        aleatoire.setForeground(Color.BLACK);
        panneau.add(aleatoire);


        JButton fichier = new JButton("Choix fichier");
        fichier.addActionListener(m);
        fichier.setFont(new Font("Sérif",Font.BOLD,20));
        fichier.setBackground(new Color(0,168,81));
        fichier.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        fichier.setForeground(Color.BLACK);
        panneau.add(fichier);

        JButton quiter = new JButton("Quitter");
        quiter.addActionListener(m);
        quiter.setFont(new Font("Sérif",Font.BOLD,20));
        quiter.setBackground(new Color(2,176,241));
        quiter.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        quiter.setForeground(Color.BLACK);        
        panneau.add(quiter);

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