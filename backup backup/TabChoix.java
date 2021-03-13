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
        // Le fichier d'entrée
        FileInputStream file = new FileInputStream(chemin);   
        Scanner scanner = new Scanner(file);  
        
        
        //renvoie true s'il y a une autre ligne à lire
        while(scanner.hasNext())
        {
            //System.out.println(scanner.next());
            String s=scanner.next();
            
            for(i=0; i<15;i++){  
                char c = s.charAt(i);  
                System.out.print(c);
                tab[j][i]=c;  
            }
            j++;
            //System.out.println(" j="+j);
            
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
