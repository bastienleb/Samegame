import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher la page du menu 
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    ImageIcon icone = new ImageIcon("../image/image du menu.jpg");
    JLabel images = new JLabel(icone);
    
    Actionmenu m = new Actionmenu(panneau,this);
    
    public Menu(){
        super("SameGame");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton aleatoire = new JButton("Al\u00e9atoire");
        aleatoire.addActionListener(m);
        aleatoire.setFont(new Font("Sérif",Font.BOLD,20));
        aleatoire.setBackground(new Color(186,22,28));
        aleatoire.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        aleatoire.setForeground(Color.BLACK);
        //panneau.add(aleatoire);


        JButton fichier = new JButton("Choix fichier");
        fichier.addActionListener(m);
        fichier.setFont(new Font("Sérif",Font.BOLD,20));
        fichier.setBackground(new Color(0,168,81));
        fichier.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        fichier.setForeground(Color.BLACK);
        //panneau.add(fichier);

        JButton quiter = new JButton("Quitter");
        quiter.addActionListener(m);
        quiter.setFont(new Font("Sérif",Font.BOLD,20));
        quiter.setBackground(new Color(2,176,241));
        quiter.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        quiter.setForeground(Color.BLACK);        
        //panneau.add(quiter);

        panneau.add(images);

        //this.add(titre);
        this.add(panneau);
        //this.add(logo);
        this.setVisible(true);
    }   
}