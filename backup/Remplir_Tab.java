import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


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
            panel.add(new Image(new ImageIcon("../image/rouge_j.png").getImage()));

        }
        
        if(lettre.equals("v")){
            panel.add(new Image(new ImageIcon("../image/vert_j.png").getImage()));
        }
        
        if(lettre.equals("b")){
            panel.add(new Image(new ImageIcon("../image/bleu_j.png").getImage()));

        }

        if(lettre.equals(" ")){
            panel.add(new Image(new ImageIcon("../image/fond_b.png").getImage()));
        }
    }
}
