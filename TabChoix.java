import java.io.*;
import java.util.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette classe sert a lire le fichier et remplir le tableau
*/

public class TabChoix {
    char[][] tab=new char[10][15];
    int valider=0;
    int ligne=0;
    int colonne=0;
    boolean lignes=true;

    public char[][] choix() {
        String chemin;
        RecupFichier t=new RecupFichier();
        chemin=t.recuperation();
        
        int i=0;
        int j=0;
        try
        {
        FileInputStream file = new FileInputStream(chemin);   
        Scanner scanner = new Scanner(file);  
    
        
        while(colonne!=10){
            String s=scanner.next();
            
            if(s.length()==15){
                for(i=0; i<15;i++){  
                    char c = s.charAt(i);  
                    tab[j][i]=c;  
                }
                j++;
            }
            else{
                ligne=1;
            }
            colonne++;
            if(colonne == 10){
                lignes=false;
            }
        }
        if(ligne==1){
            System.err.println("Fichier mal écrit, il doit etre de 15 par 10 ! ");            
            valider=1;
        }
        
        scanner.close();    
        }
        catch(IOException e)
        {
            System.err.println("Fichier introuvable");
            valider=1;
        }
        return tab;
    }

    public int verif(){
        return valider;
    }
}