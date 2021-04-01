import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher la page de fin 
*/

public class Fin extends JFrame {
    int score=0;
    ImageIcon icone = new ImageIcon("../image/image de fin.jpg");
    JLabel images = new JLabel(icone);
    JPanel fond = new JPanel();
    ActionFin af = new ActionFin(this);
    public Fin(int scorefin){
        this.score=scorefin;
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fond.add(images);
        fond.addMouseListener(af);
        this.add(fond);
        // RecupScore();
        this.setVisible(true);
    }
    /**
     * Cette Methode sert a recuperer le score de la class Grille
     */
    /*
    public void RecupScore(){
        JLabel affiscore = new JLabel("SCORE :"+score);
        affiscore.setFont(new Font("Sérif",Font.BOLD,20));
        panscore.add(affiscore);
    }*/
}
