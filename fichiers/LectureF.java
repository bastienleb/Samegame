import java.io.*;
import java.util.Scanner;
public class LectureF{
  public static void main(String args[])
  {
    char tab[][]=new char[15][10];
    int i=0;
    int j=0;
    try
    {
      // Le fichier d'entrée
      FileInputStream file = new FileInputStream("C:\\Users\\Cadeau!\\Desktop\\liaison git\\PT21_APL2020\\PT21_APL2020\\fichiers\\lecture.txt");   
      Scanner scanner = new Scanner(file);  
      
      
      //renvoie true s'il y a une autre ligne à lire
      while(scanner.hasNext())
      {
        //System.out.println(scanner.next());
        String s=scanner.next();
        
        for(i=0; i<15;i++){  
            char c = s.charAt(i);  
            //System.out.print(c);
            tab[i][j]=c;  
        }
        j++;
        //System.out.println(" j="+j);
        
      }
      for(int a=0; a<10;a++){  
        for(int b=0; b<15;b++){  
            System.out.print(tab[b][a]);
        }
        System.out.println("");
      }
      scanner.close();    
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}