import java.util.*;
import javax.swing.*;
import java.awt.*;
/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille {
    private char tab[][]=new char[10][15];
    private Random choix=new Random();
    public Grille(){
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

    

    public void AfficherGrille(){
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                    System.out.print(tab[i][j]+" ");      
                }  
                System.out.println("");
            }
 
        }      

}

