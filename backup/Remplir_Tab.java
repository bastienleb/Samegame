import javax.swing.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher les image dans la grille
*/

public class Remplir_Tab {
    public Remplir_Tab(String lettre,JPanel panel){
        if(lettre.equals("R")){
            panel.add(new Image(new ImageIcon("../image/rouge.png").getImage()));
        }
        
        if(lettre.equals("V")){
            panel.add(new Image(new ImageIcon("../image/vert.png").getImage()));
        }
        
        if(lettre.equals("B")){
            panel.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
        }
        if(lettre.equals("r")){
            panel.add(new Image(new ImageIcon("../image/rouge_select.png").getImage()));
        }
        
        if(lettre.equals("v")){
            panel.add(new Image(new ImageIcon("../image/vert_select.png").getImage()));
        }
        
        if(lettre.equals("b")){
            panel.add(new Image(new ImageIcon("../image/bleu_select.png").getImage()));
        }

        if(lettre.equals("5")){
            panel.add(new Image(new ImageIcon("../image/fond_b.png").getImage()));
        }
    }
}
