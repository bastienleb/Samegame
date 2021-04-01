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
    JPanel panscore= new JPanel();
    ActionFin af = new ActionFin(this);
    JPanel all= new JPanel();

    public Fin(int scorefin){
        this.score=scorefin;
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        all.setLayout(null);
        fond.setBounds(0,0,1024,768);
        panscore.setBounds(0,575,1024,60);
        fond.add(images);
        fond.addMouseListener(af);
        RecupScore();
        all.add(panscore);
        all.add(fond);
        this.add(all);
        this.setVisible(true);
    }
    /**
    * Cette Methode sert a recuperer le score de la class Grille
    */
    
    public void RecupScore(){
        JLabel affiscore = new JLabel("SCORE :"+score);
        affiscore.setFont(new Font("Sérif",Font.BOLD,40));
        panscore.setBackground(new Color(124,175,219));
        affiscore.setForeground(new Color(0,84,166));
        panscore.add(affiscore);
    }
}
