import java.io.*;
import java.util.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette classe sert a lire le fichier et remplir le tableau
*/

public class TabChoix {
    char[][] tab=new char[10][15];
    int valider=0;

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
        
        
        while(scanner.hasNext())
        {
            String s=scanner.next();
            
            for(i=0; i<15;i++){  
                char c = s.charAt(i);  
                tab[j][i]=c;  
            }
            j++;
            
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