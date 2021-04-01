import javax.swing.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a afficher les image dans la grille
*/

public class Remplir_Tab {
    ImageIcon rouge = new ImageIcon("../image/rouge.png");
    ImageIcon bleu = new ImageIcon("../image/bleu.png");
    ImageIcon vert = new ImageIcon("../image/vert.png");
    ImageIcon rouge_survol = new ImageIcon("../image/rouge_select.png");
    ImageIcon bleu_survol = new ImageIcon("../image/bleu_select.png");
    ImageIcon vert_survol = new ImageIcon("../image/vert_select.png");
    ImageIcon fond = new ImageIcon("../image/fond_b.png");

    JLabel labrouge = new JLabel(rouge);
    JLabel labbleu = new JLabel(bleu);
    JLabel labvert = new JLabel(vert);
    JLabel labrouge_survol = new JLabel(rouge_survol);
    JLabel labbleu_survol = new JLabel(bleu_survol);
    JLabel labvert_survol = new JLabel(vert_survol);
    JLabel labfond = new JLabel(fond);

    public Remplir_Tab(String lettre,JPanel panel){
        if(lettre.equals("R")){
            panel.add(labrouge);
        }
        
        if(lettre.equals("V")){
            panel.add(labvert);
        }
        
        if(lettre.equals("B")){
            panel.add(labbleu);
        }
        if(lettre.equals("r")){
            panel.add(labrouge_survol);
        }
        
        if(lettre.equals("v")){
            panel.add(labvert_survol);
        }
        
        if(lettre.equals("b")){
            panel.add(labbleu_survol);
        }

        if(lettre.equals(" ")){
            panel.add(labfond);
        }
    }
}
