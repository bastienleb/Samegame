import javax.swing.*;
import java.awt.*;

public class AffichageGrille{
    private char tab[][]=new char[10][15];
    

    public AffichageGrille(char tab[][]){
        this.tab=tab;
        
    }
        public void ImageJeu(){
            System.out.println("dans affichage ImageJeu");
            JFrame fenetre = new JFrame();
            fenetre.setLocationRelativeTo(null);
            fenetre.setResizable(false);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setSize(300, 300);
            fenetre.setLayout(new GridLayout(15,10));

            // for (int i=0;i<10;i++){
            //     for(int j=0;j<15;j++){
            //         System.out.print(tab[i][j]+" ");                        //le tableau n'est pas renvoyer   
            //     }  
            //     System.out.println("");
            // }
     
            
            

            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    String lettre=Character.toString(tab[i][j]);
                    //System.out.println(lettre);

                    if(lettre.equals("R")){
                        fenetre.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
                        System.out.println("DANS LE IF ROUGE ");

                    }

                    if(lettre.equals("V")){
                        fenetre.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
                        System.out.println("DANS LE IF VERT ");

                    }

                    if(lettre.equals("B")){
                        fenetre.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
                        System.out.println("DANS LE IF BLEUE");

                    }
                    
                }

            }
        
        }
    }

