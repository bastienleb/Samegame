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
        
        panneau.add(images);
        panneau.addMouseListener(m);
        
        //this.add(titre);
        this.add(panneau);
        //this.add(logo);
        this.setVisible(true);
    }   
}