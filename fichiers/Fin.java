import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher la page de fin 
*/

public class Fin extends JFrame {
    int score=0;
    ImageIcon icone = new ImageIcon("../image/dinguerie.png");
    JLabel images = new JLabel(icone);
    JPanel panscore = new JPanel();
    JPanel fond = new JPanel();
    JPanel btn = new JPanel();
    ActionFin af = new ActionFin(this);
    public Fin(int scorefin){
        this.score=scorefin;
        this.setSize(750,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        RecupScore();
        btn();
        images();
        this.setVisible(true);
    }

    /**
     * Cette Methode sert a afficher les image
    */
    public void images(){
        
        panscore.setBackground(new Color(127,255,0));;
        fond.add(images);
        btn.setBackground(new Color(127,255,0));;
        this.add(panscore);
        this.add(fond);
        this.add(btn);
    }

    /**
     * Cette Methode sert a recuperer le score de la class Grille
    */
    public void RecupScore(){
        JLabel affiscore = new JLabel("SCORE :"+score);
        affiscore.setFont(new Font("Sérif",Font.BOLD,20));
        panscore.add(affiscore);
    }

    /**
     * Cette Methode sert a ajouter tout les boutons
    */
    public void btn(){
        JButton rejouer = new JButton("REJOUER");
        JButton quitter = new JButton("QUITTER");
        
        rejouer.setFont(new Font("Sérif",Font.BOLD,20));
        quitter.setFont(new Font("Sérif",Font.BOLD,20));

        rejouer.addActionListener(af);
        quitter.addActionListener(af);

        btn.add(rejouer);
        btn.add(quitter);

    }
}
