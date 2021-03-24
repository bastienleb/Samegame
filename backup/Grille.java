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
                        

                    }
                    
                    if(lettre.equals("V")){
                        panel.add(new Image(new ImageIcon("../image/vert.png").getImage()));
  
                    }
                    
                    if(lettre.equals("B")){
                        panel.add(new Image(new ImageIcon("../image/bleu.png").getImage()));

                    }
                    if(lettre.equals("r")){
                        panel.add(new Image(new ImageIcon("../image/rouge_j.png").getImage()));

                    }
                    
                    if(lettre.equals("v")){
                        panel.add(new Image(new ImageIcon("../image/vert_j.png").getImage()));
                    }
                    
                    if(lettre.equals("b")){
                        panel.add(new Image(new ImageIcon("../image/bleu_j.png").getImage()));

                    }

                    if(lettre.equals(" ")){
                        panel.add(new Image(new ImageIcon("../image/fond_b.png").getImage()));
                    }
                    
                }
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
            return x;
        }

        public int RecupY(){
            return y;
        }
    
        public void ResetTabSurvol(){
            for(int a=0; a<10;a++){  
                for(int b=0; b<15;b++){  
                    tabsurvol[a][b]=0;
                }
            }
        }

       

public int VerifColonne(int colonnes) {
	for (int i=0; i<10; i++) {
	    if (tab[i][colonnes]!=' ') {
		    return 0;
	    }
	}
	return 1;
    }


    public void BougeGauche () {
    	for (int k=0; k<10; k++) {
	        for (int j=0; j<14; j++) {
		        if (VerifColonne(j)==1) {
		            for (int i=0; i<10; i++) {
                        tab[i][j]= tab[i][j+1];
                        tab[i][j+1]=' ';
		    }
		}
	    }
	}
    ImageJeu();
    }



        public void BougeTab(){

            for (int k=0; k<10; k++) {
             for (int i=0; i<9; i++) {
                for (int j=0; j<14; j++) {
                    if ((tab[i+1][j]==' ') && (tab[i][j]!=' ')) {
                        tab[i+1][j]= tab[i][j];
                        tab[i][j]=' ';
                    }
                }
            }
        }
        ImageJeu();
        }


        public void ModifTAb(){ 
         
            posx=RecupX();
            posy=RecupY();
            RefreshTab();
            if(tab[posy][posx]=='R'){
                tab[posy][posx]='r';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                tmpx=posx;
                tmpy=posy;
            }
            if(tab[posy][posx]=='V'){
                tab[posy][posx]='v';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                tmpx=posx;
                tmpy=posy;
            }
            if(tab[posy][posx]=='B'){
                tab[posy][posx]='b';
                tabsurvol[posy][posx]=1;
                tmplettre=tab[tmpy][tmpx];
                tmplettre=Character.toUpperCase(tmplettre);
                tab[tmpy][tmpx]=tmplettre;
                tmpx=posx;
                tmpy=posy;
            }
    
            AutourCase(posx, posy);
            ResetTabSurvol();
        }

    public void AutourCase(int x,int y){
;
        char tempL;
        tempL=tab[y][x];

        if(x>0){
            if (tab[y][x]==Character.toLowerCase(tab[y][x-1]) && tabsurvol[y][x-1]==0){
                tab[y][x-1]=Character.toLowerCase(tempL);
                tabsurvol[y][x-1]=1;
                AutourCase((x-1),y);
                ImageJeu();
                boules++;
            }      
        }
        

        if(y>0){
            if (tab[y][x]==Character.toLowerCase(tab[y-1][x]) && tabsurvol[y-1][x]==0){
                tab[y-1][x]=Character.toLowerCase(tempL);
                tabsurvol[y-1][x]=1;
                AutourCase(x, (y-1));
                ImageJeu();
                boules++;

            }

        }

        if(y<9){
            if (tab[y][x]==Character.toLowerCase(tab[y+1][x]) && tabsurvol[y+1][x]==0){
                tab[y+1][x]=Character.toLowerCase(tempL);
                tabsurvol[y+1][x]=1;
                AutourCase(x, (y+1));
                ImageJeu();
                boules++;

            }
        }

        if(x<14){
            if (tab[y][x]==Character.toLowerCase(tab[y][x+1]) && tabsurvol[y][x+1]==0){
                tab[y][x+1]=Character.toLowerCase(tempL);
                tabsurvol[y][x+1]=1;
                AutourCase(x+1, y);
                ImageJeu();
                boules++;

            }
        } 
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
                if(Character.isLowerCase(tab[dx][dy])){
                    tab[dx][dy]=' '; 
                    ImageJeu();
                }
            }

        }
    }
       

    @Override
    public void mouseClicked(MouseEvent e)  {
        changerfond();
        score+=(boules-2)^2;
        boules=1;
        BougeTab();
        ImageJeu();
        BougeGauche();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if((e.getX()/75>=0)&&(e.getX()/75<15)&&(e.getY()/75>=0)&&(e.getY()/75<10)){
        
        if(x==ancienx && y==ancieny){
            x=(e.getX()/75);
            y=(e.getY()/75);
        } 
        else{  
            ancienx=x;
            ancieny=y;
            RecupX();
            RecupY();

            ModifTAb();
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