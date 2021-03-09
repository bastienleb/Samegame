import java.util.*;

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
 
        }

    public void AfficheGrille(){
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                    System.out.print(tab[i][j]+" ");      
                }  
                System.out.println("");
            }
 
        }
    
        
    

    // for (int i=0;i<10;i++){
    //     System.out.println("");
    //     for(int j=0;j<15;j++){
    //         System.out.print(tab[i][j]+" ");
    //     }
    // }

}

