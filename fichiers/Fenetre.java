import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Fenetre extends JFrame {

    private static final long serialVersionUID = 1L;
    
    
    
    public Fenetre(){
        super("SameGame");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.CYAN);
        this.setVisible(true);

        System.out.println("fenetre");
    }
    Menu menu=new Menu();
}
