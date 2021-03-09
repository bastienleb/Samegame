import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Fenetre extends JFrame {

    private Menu menu=new Menu();
    public Fenetre(){
        super("SameGame");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }
}
