/*
@author Kévin METRI et Bastien LEBLET
*/

import java.io.*;
import java.util.*;

public class TabChoix {
    char[][] tab=new char[10][15];

    public char[][] choix() {
        System.out.println("dans TabChoix");
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
        e.printStackTrace();
        }
        return tab;
  }
}
