import javax.swing.*;
import java.awt.*;

/**
* @author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher la page du menu 
*/

public class Menu extends JFrame {

    JPanel panneau = new JPanel();
    ImageIcon icone = new ImageIcon("../image/image du menu.jpg");
    JLabel images = new JLabel(icone);
    Actionmenu m = new Actionmenu(this);
    
    public Menu(){
        super("SameGame");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ajout_image();
        this.setVisible(true);
    } 
    
    private void ajout_image(){
        panneau.add(images);
        panneau.addMouseListener(m);
        this.add(panneau);
    }
}