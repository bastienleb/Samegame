import java.util.*;

public class TabAlea {
    private char[][] tab=new char[10][15];
    private Random choix=new Random();

    public char[][] alea(){
       // System.out.println("dans alea");
        
        
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
        
        return tab;

    }

    

    



}
