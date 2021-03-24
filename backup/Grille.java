import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener,MouseListener {
    private char tab[][]=new char[10][15];
    private int tabsurvol[][]=new int[10][15];
    int x;
    int y;
    int ancienx;
    int ancieny;
    int posx;
    int posy;
    int tmpx;
    int tmpy;
    char tmplettre;
    int score=0;
    int boules=1;
    
    public Grille(){
        super("Grille");
        
        this.setSize(1230,885);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void RecupTabAlea(){
        TabAlea ta = new TabAlea();
        tab=ta.alea();

        // for(int a=0; a<10;a++){  
        //     for(int b=0; b<15;b++){  
        //         System.out.print(tab[a][b]);
        //     }
        //     System.out.println("");
        // }
    }

    public int RecupTabChoix(){
        TabChoix t=new TabChoix();
        tab=t.choix();
        int validation=t.verif();
        if(validation==1){
            this.dispose();
            new Menu();
        }

        // for(int a=0; a<10;a++){  
        //     for(int b=0; b<15;b++){  
        //         System.out.print(tab[a][b]);
        //     }
        //     System.out.println("");
        // }
        return validation;
    }
    
        
    public void ImageJeu(){
            
            JPanel panel =new JPanel();
            JPanel panscore = new JPanel();
            JLabel labscore = new JLabel("score = "+ score);

            JPanel all= new JPanel();
            all.setLayout(null);
            panel.setBounds(0, 0, 1221, 815);
            panscore.setBounds(0,810,1221,40);
            labscore.setFont(new Font("Sérif",Font.BOLD,15));
            panscore.setBackground(Color.RED);
            
            panel.setLayout(new GridLayout(10,15));
            
            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    // this.add(panel);
                    String lettre=Character.toString(tab[i][j]);
                    
                    if(lettre.equals("R")){
                        panel.add(new Image(new ImageIcon("../image/rouge.png").getImage()));
                        //System.out.print("R");
                        

                    }
                    
                    if(lettre.equals("V")){
                        panel.add(new Image(new ImageIcon("../image/vert.png").getImage()));
                        //System.out.print("V");
                        
                        
                    }
                    
                    if(lettre.equals("B")){
                        panel.add(new Image(new ImageIcon("../image/bleu.png").getImage()));
                        //System.out.print("B");
                        

                    }
                    if(lettre.equals("r")){
                        panel.add(new Image(new ImageIcon("../image/rouge_j.png").getImage()));
                        //System.out.print("r");
                        

                    }
                    
                    if(lettre.equals("v")){
                        panel.add(new Image(new ImageIcon("../image/vert_j.png").getImage()));
                        //System.out.print("v");
                        
                        
                    }
                    
                    if(lettre.equals("b")){
                        panel.add(new Image(new ImageIcon("../image/bleu_j.png").getImage()));
                        //System.out.print("b");
                    }

                    if(lettre.equals(" ")){
                        panel.add(new Image(new ImageIcon("../image/fond_b.png").getImage()));
                        //System.out.print("b");
                    }
                    
                }
                //System.out.println("");
                 // BougeGauche();
            }


            panscore.add(labscore);
            all.add(panel);
            all.add(panscore);

            this.add(all);
            panel.addMouseMotionListener(this);
            panel.addMouseListener(this);
            this.setVisible(true);
        }

        public int RecupX(){
            // System.out.println("Dans la fonction "+x);
            return x;
        }

        public int RecupY(){
            // System.out.println("Dans la fonction "+y);
            return y;
        }
        public void AfficherTabSurvol(){
            // for(int a=0; a<10;a++){  
            //     for(int b=0; b<15;b++){  
            //         System.out.print(tabsurvol[a][b]);
            //     }
            //     System.out.println("");
            // }
        }
        public void ResetTabSurvol(){
            for(int a=0; a<10;a++){  
                for(int b=0; b<15;b++){  
                    tabsurvol[a][b]=0;
                }
            }
        }

        // public char VerifColonne(int colonnes){
        //     for (int i=0; i<9; i++) {
        //         if (tab[colonnes][i]!=' ') {
        //             return 'N';
        //             }
        //     }
        //     return 'O';
        // }

        public void BougeGauche () {
           
                for (int j=0; j<14; j++) {
                    if (tab[9][j]==' ') {
                         // System.out.println(" tab 9 "+tab[9][j+1]);
                            for (int i=0; i<9; i++) {
                                char tmp=tab[i][j];
                                tab[i][j]= tab[i][j+1];
                                tab[i][j+1]=tmp;
                                }
            }
            
        }
        
        BougeTab();
}



        public void BougeTab(){

            for (int k=0; k<10; k++) {
             for (int i=0; i<9; i++) {
                for (int j=0; j<14; j++) {
                    if ((tab[i+1][j]==' ') && (tab[i][j]!=' ')) {
                        tab[i+1][j]= tab[i][j];
                        tab[i][j]=' ';
                    }
                // System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
                }
            }
        }
        ImageJeu();
        }


        public void ModifTAb(){ 
            //System.out.println("Dans la fonction ");

            
                
            posx=RecupX();
            posy=RecupY();
            //VerifC(posx,posy);
            
            RefreshTab();
            
            if(tab[posy][posx]=='R'){
                tab[posy][posx]='r';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                // VerifC(posx,posy);
                tmpx=posx;
                tmpy=posy;
            }
            if(tab[posy][posx]=='V'){
                tab[posy][posx]='v';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                // VerifC(posx,posy);
                tmpx=posx;
                tmpy=posy;
            }
            if(tab[posy][posx]=='B'){
                tab[posy][posx]='b';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                // VerifC(posx,posy);
                tmpx=posx;
                tmpy=posy;
            }
            AfficherTabSurvol();
            AutourCase(posx, posy);
            ResetTabSurvol();
        }

    public void AutourCase(int x,int y){
        AfficherTabSurvol();
        char tempL;
        tempL=tab[y][x];


        // System.out.println("DANS AUTOURCASE  x: " +x+" y: "+y);

        // if((x>=0)&&(x<14)&&(y>=0)&&(y<9)){

        // for(int i=0;i<10;i++){
        //     for(int j=0;j<15;j++){
            // System.out.println(" AUTOUR CASE");

            


        if(x>0){
            // System.out.println("Dans le if x>0 tab="+tab[y][x]+" et l'autre ="+tab[y][x-1]+ " et tab survol ="+tabsurvol[y][x]+" a gauche");
            if (tab[y][x]==Character.toLowerCase(tab[y][x-1]) && tabsurvol[y][x-1]==0){
                // System.out.println("A GAUCHE IL Y A UNE CASE :" + tab[y][x-1]+" aux coordonnées x:"+(x-1)+" y:"+y);
                tab[y][x-1]=Character.toLowerCase(tempL);
                tabsurvol[y][x-1]=1;
                AutourCase((x-1),y);
                ImageJeu();
                boules++;
            }      
        }
        

        if(y>0){
            // System.out.println("Dans le if y>0 tab="+tab[y][x]+" et l'autre ="+tab[y-1][x]+ " et tab survol ="+tabsurvol[y][x]+" en haut");
            if (tab[y][x]==Character.toLowerCase(tab[y-1][x]) && tabsurvol[y-1][x]==0){
                // System.out.println("EN HAUT IL Y A UNE CASE :" + tab[y-1][x]+" aux coordonnées x:"+x+" y:"+(y-1));
                tab[y-1][x]=Character.toLowerCase(tempL);
                tabsurvol[y-1][x]=1;
                AutourCase(x, (y-1));
                ImageJeu();
                boules++;

            }

        }

        if(y<9){
            // System.out.println("Dans le if y<9 tab="+tab[y][x]+" et l'autre ="+tab[y+1][x]+ " et tab survol ="+tabsurvol[y][x]+" en bas");
            if (tab[y][x]==Character.toLowerCase(tab[y+1][x]) && tabsurvol[y+1][x]==0){
                // System.out.println("EN BAS IL Y A UNE CASE :" + tab[y+1][x]+" aux coordonnées x:"+x+" y:"+(y+1));
                tab[y+1][x]=Character.toLowerCase(tempL);
                tabsurvol[y+1][x]=1;
                AutourCase(x, (y+1));
                ImageJeu();
                boules++;

            }
        }

        if(x<14){
            // System.out.println("Dans le if x<14 tab="+tab[y][x]+" et l'autre ="+tab[y][x+1]+ " et tab survol ="+tabsurvol[y][x]+" a droite");
            if (tab[y][x]==Character.toLowerCase(tab[y][x+1]) && tabsurvol[y][x+1]==0){
                // System.out.println("A DROITE IL Y A UNE CASE :" + tab[y][x+1]+" aux coordonnées x:"+(x+1)+" y:"+y);
                tab[y][x+1]=Character.toLowerCase(tempL);
                tabsurvol[y][x+1]=1;
                AutourCase(x+1, y);
                ImageJeu();
                boules++;

            }
        } 
        // System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////");
    }
    

    public void RefreshTab(){
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                char lettre_en_cours=tab[i][j];
                tab[i][j]=Character.toUpperCase(lettre_en_cours);
            }
        }
    }

    public void changerfond(){
        for(int dx=0; dx<10;dx++){  
            for(int dy=0; dy<15;dy++){
                //char tempL=;
                //boolean tmp=Character.isLowerCase(tab[dx][dy]);  
                System.out.print(tab[dx][dy]);
                if(Character.isLowerCase(tab[dx][dy])){
                    System.out.print(Character.isLowerCase(tab[dx][dy]));
                    tab[dx][dy]=' '; 
                    ImageJeu();
                }
            }
            System.out.println("");
            
        }
    }
       

    @Override
    public void mouseClicked(MouseEvent e)  {
        //System.out.println("TA cliquer");
        changerfond();
        score+=(boules-2)^2;
        boules=1;
        BougeTab();
        BougeGauche();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if((e.getX()/75>=0)&&(e.getX()/75<15)&&(e.getY()/75>=0)&&(e.getY()/75<10)){
        
        if(x==ancienx && y==ancieny){
            //System.out.println("c'est le meme pelo x="+x+" y="+y+" ancienx="+ancienx+" ancieny="+ancieny);
            x=(e.getX()/75);
            y=(e.getY()/75);
        } 
        else{  
            ancienx=x;
            ancieny=y;
            RecupX();
            RecupY();
            
            ModifTAb();
            // AutourCase(x, y);
            
            // System.out.println(" x: "+x+" y :"+y);
        }
            ImageJeu();
    }
        
    }
public void mousePressed(MouseEvent e){}
public void mouseDragged(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseEntered(MouseEvent e){}
public void mouseReleased(MouseEvent e){}

}