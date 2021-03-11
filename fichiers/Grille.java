import java.util.*;
import java.util.function.Supplier;

import javax.swing.*;
import java.awt.*;
/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame {
    private char tab[][]=new char[10][15];
    private Random choix=new Random();
    
    public Grille(){
        super("Grille");
        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public void AfficheGrille(){
        
        
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                int hasard=choix.nextInt(3);

                if(hasard==0){
                    tab[i][j]='R';
                    
                }

                if(hasard==1){
                    tab[i][j]='B';
                    
                }
                
                if(hasard==2){
                    tab[i][j]='V';
                    
                }
                
            }

        }
        System.out.println("");
        new Actionmenu(tab);
        
    }
        
    public void ImageJeu(){
        
            System.out.println("dans affichage ImageJeu");
            JFrame fenetre = new JFrame();
            fenetre.setLocationRelativeTo(null);
            fenetre.setResizable(false);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(300, 300);
            fenetre.setLayout(new GridLayout(15,10));
            
            JPanel panel =new JPanel();
            
            
            panel.setLayout(new GridLayout(15,10));
            
            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    this.add(panel);
                    String lettre=Character.toString(tab[i][j]);
                    //System.out.println(lettre);
                    
                    if(lettre.equals("R")){
                        panel.add(new Image(new ImageIcon("../image/rouge.png").getImage()));
                        
                        System.out.print("R");

                    }
                    
                    if(lettre.equals("V")){
                        panel.add(new Image(new ImageIcon("../image/vert.png").getImage()));
                        System.out.print("V");
                        
                    }
                    
                    if(lettre.equals("B")){
                        panel.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
                        System.out.print("B");

                    }
                    
                }
                System.out.println("");
            }
            
            this.setVisible(true);
        }
        
    }
    
    