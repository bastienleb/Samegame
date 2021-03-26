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
    private int x;
    private int y;
    private int ancienx;
    private int ancieny;
    private int posx;
    private int posy;
    private int tmpx;
    private int tmpy;
    private char tmplettre;
    private double score=0.0;
    private int intscore=0;
    private int boules=0;
    private int boulesscore=0;
    private boolean tupeutpascliquer;
    
    public Grille(){
        super("Grille");
        
        this.setSize(767,580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void RecupTabAlea(){
        TabAlea ta = new TabAlea();
        tab=ta.alea();
    }

    public int RecupTabChoix(){
        TabChoix t=new TabChoix();
        tab=t.choix();
        int validation=t.verif();
        if(validation==1){
            this.dispose();
            new Menu();
        }
        return validation;
    }
    
        
    public void ImageJeu(){
            
        JPanel panel =new JPanel();
        JPanel panscore = new JPanel();
        intscore=(int)score;
        JLabel labscore = new JLabel("SCORE = "+ intscore);

        JPanel all= new JPanel();
        all.setLayout(null);
        panel.setBounds(0, 0, 750, 500);
        panscore.setBounds(0,500,750,40);
        labscore.setFont(new Font("Sérif",Font.BOLD,25));
        panscore.setBackground(Color.WHITE);
        
        panel.setLayout(new GridLayout(10,15));
        
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                // this.add(panel);
                String lettre=Character.toString(tab[i][j]);
                
                new Remplir_Tab(lettre,panel);
                
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
        boules=0;
        
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

    public void ChuteBoule(){

        for (int k=0; k<10; k++) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<15; j++) {
                    if ((tab[i+1][j]==' ') && (tab[i][j]!=' ')) {
                        tab[i+1][j]= tab[i][j];
                        tab[i][j]=' ';
                    }
                }
            }
        }
        ImageJeu();
    }

    public void TailleGroupe(){
        
        for (int i=0; i<10; i++) {
            for (int j=0; j<15; j++) {
                if(tabsurvol[i][j]==1){
                    boules++;
                    boulesscore++;
                    tupeutpascliquer=false;
                }
            }
        }
        if(boules==1){
            tab[RecupY()][RecupX()]=Character.toUpperCase(tab[RecupY()][RecupX()]);
            tabsurvol[RecupY()][RecupX()]=0;
            tupeutpascliquer=true;
        }
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
        TailleGroupe();
        ResetTabSurvol();
    }

    public void AutourCase(int x,int y){
        char tempL;
        tempL=tab[y][x];

        if(x>0){
            if (tab[y][x]==Character.toLowerCase(tab[y][x-1]) && tabsurvol[y][x-1]==0 && tab[y][x]!=' '){
                tab[y][x-1]=Character.toLowerCase(tempL);
                tabsurvol[y][x-1]=1;
                AutourCase((x-1),y);
                ImageJeu();
            }      
        }
        

        if(y>0){
            if (tab[y][x]==Character.toLowerCase(tab[y-1][x]) && tabsurvol[y-1][x]==0 && tab[y][x]!=' '){
                tab[y-1][x]=Character.toLowerCase(tempL);
                tabsurvol[y-1][x]=1;
                AutourCase(x, (y-1));
                ImageJeu();

            }

        }

        if(y<9){
            if (tab[y][x]==Character.toLowerCase(tab[y+1][x]) && tabsurvol[y+1][x]==0 && tab[y][x]!=' '){
                tab[y+1][x]=Character.toLowerCase(tempL);
                tabsurvol[y+1][x]=1;
                AutourCase(x, (y+1));
                ImageJeu();

            }
        }

        if(x<14){
            if (tab[y][x]==Character.toLowerCase(tab[y][x+1]) && tabsurvol[y][x+1]==0 && tab[y][x]!=' '){
                tab[y][x+1]=Character.toLowerCase(tempL);
                tabsurvol[y][x+1]=1;
                AutourCase(x+1, y);
                ImageJeu();

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

    public void Score(int i,int j){
        if(tab[j][i]!=' '){
            score=score+Math.pow(boulesscore-2.0, 2.0);
            boulesscore=0;
        }
    }

    public void VerifFin(){
        if(tab[9][0]==' '){
            this.dispose();
            new Fin();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)  {
        if(tupeutpascliquer!=true){
            changerfond();
            ChuteBoule();
            BougeGauche();
            TailleGroupe();
            ImageJeu();
            Score(RecupX(), RecupY());
            VerifFin();
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
            
        if((e.getX()/50>=0)&&(e.getX()/50<15)&&(e.getY()/50>=0)&&(e.getY()/50<10)){
            if(x==ancienx && y==ancieny){
                x=(e.getX()/50);
                y=(e.getY()/50);
            } 
            else{  
                ancienx=x;
                ancieny=y;
                RecupX();
                RecupY();
                
                ModifTAb();
            }
            ChuteBoule();
            BougeGauche();
            ImageJeu();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}