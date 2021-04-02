import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class gere tout la partie jeux
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
        super("SameGame");
        this.setSize(767,580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Cette Methode sert a recupérer le tableau si le mode de jeu choisie est Aléatoire
    */
    
    public void RecupTabAlea(){
        TabAlea ta = new TabAlea();
        tab=ta.alea();
    }

    /**
     * Cette Methode sert a recupérer le tableau si le mode de jeu choisie est par fichier plus verification que le ficheir est bien un .txt
    */

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
    
    /**
     * Cette Methode sert a afficher la page de jeux
    */  
    public void ImageJeu(){

        JPanel panel =new JPanel();
        JPanel panscore = new JPanel();
        JLabel labscore = new JLabel("SCORE = "+ intscore);

        JPanel all= new JPanel();
        all.setLayout(null);
        panel.setBounds(0, 0, 750, 500);
        panscore.setBounds(0,500,750,40);
        labscore.setFont(new Font("Sérif",Font.BOLD,25));
        panscore.setBackground(new Color(124,175,219));
        labscore.setForeground(new Color(0,84,166));
        
        panel.setLayout(new GridLayout(10,15));
        
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
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

    /**
     * Cette Methode sert a recupérer les Coordonée Y de la souris pour l'utiliser partout dans le fichier 
    */
    public int RecupY(){
        return y;
    }
    
    /**
     * Cette Methode sert a rénitialiser le tableau de survol une fois la forme changer 
    */
    public void ResetTabSurvol(){
        for(int a=0; a<10;a++){  
            for(int b=0; b<15;b++){  
                tabsurvol[a][b]=0;
            }
        }
        boules=0;
        
    }

    /**
     * Cette Methode sert a verifier que la colonne est bien vide
    */
    public int VerifColonne(int colonnes) {
        for (int i=0; i<10; i++) {
            if (tab[i][colonnes]!=' ') {
                return 0;
            }
        }
        return 1;
    }

    /**
     * Cette Methode sert a décaler la ligne a gauche si la colonne est vide
    */
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

    /**
     * Cette Methode sert a décaler les pions vers le bas si en desous de lui une zone a été cliquer 
    */
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
        
    }

    /**
     * Cette Methode sert a recuperer la taille du groupe et aussi à verifier que le groupe est >1 
    */
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
        Score(RecupX(), RecupY());
    }

    /**
     * Cette Methode sert a modifier le tableau lors s'un survol de groupe pour changer l'état et l'affichage de la grille
    */
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

    /**
     * Cette Methode sert a regarder si autour du pion en survol est la même couleur 
    */
    public void AutourCase(int x,int y){
        char tempL;
        tempL=tab[y][x];

        if(x>0){
            if (tab[y][x]==Character.toLowerCase(tab[y][x-1]) && tabsurvol[y][x-1]==0 && tab[y][x]!=' '){
                tab[y][x-1]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y][x-1]=1;
                AutourCase((x-1),y);
            }      
        }
        

        if(y>0){
            if (tab[y][x]==Character.toLowerCase(tab[y-1][x]) && tabsurvol[y-1][x]==0 && tab[y][x]!=' '){
                tab[y-1][x]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y-1][x]=1;
                AutourCase(x, (y-1));

            }

        }

        if(y<9){
            if (tab[y][x]==Character.toLowerCase(tab[y+1][x]) && tabsurvol[y+1][x]==0 && tab[y][x]!=' '){
                tab[y+1][x]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y+1][x]=1;
                AutourCase(x, (y+1));

            }
        }

        if(x<14){
            if (tab[y][x]==Character.toLowerCase(tab[y][x+1]) && tabsurvol[y][x+1]==0 && tab[y][x]!=' '){
                tab[y][x+1]=Character.toLowerCase(tempL);
                tabsurvol[y][x]=1;
                tabsurvol[y][x+1]=1;
                AutourCase(x+1, y);

            }
        }
    }

    /**
     * Cette Methode sert a ré-actualiser le tableau lorsqu'un autre groupe est selectionné
    */
    public void RefreshTab(){
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                char lettre_en_cours=tab[i][j];
                tab[i][j]=Character.toUpperCase(lettre_en_cours);
            }
        }
    }

    /**
     * Cette Methode sert a vider les cases du groupes lorsque l'on clique dessus 
    */
    public void changerfond(){
        for(int dx=0; dx<10;dx++){  
            for(int dy=0; dy<15;dy++){
                if(Character.isLowerCase(tab[dx][dy])){
                    tab[dx][dy]=' '; 
                }
            }

        }
    }

    /**
     * Cette Methode sert a calculer le score 
    */
    public void Score(int i,int j){
        if(tab[j][i]!=' '){
            score=intscore+Math.pow(boulesscore-2.0, 2.0);
            if(boulesscore==1){
                score=intscore;
            }
            boulesscore=0;
        }
        RecupScore();
    }

    /**
     * Cette Methode sert a Renvoyer le score 
    */
    public int RecupScore(){
        int scoreajout=(int)score;
        return scoreajout;
    }

    /**
     * Cette Methode sert a verifier la fin du jeu 
    */
    public void VerifFin(){
        
        int fin=1;


         for (int y=9;y>1;y--){
            for(int x=0;x<14;x++){

                char tempL;
                tempL=tab[y][x];


                if(x>0){
                    if (tab[y][x]==tab[y][x-1] &&tab[y][x]!=' '){
                       fin=0;
                    }     
                }
                
        
                if(y>0){
                    if (tab[y][x]==tab[y-1][x] &&tab[y][x]!=' '){
                        fin=0;                       
                    }   
                }
        
                if(y<9){
                    if (tab[y][x]==tab[y+1][x] &&tab[y][x]!=' ' ){
                        fin=0;
                    }  
                }
        
                if(x<14){
                    if (tab[y][x]==tab[y][x+1] &&tab[y][x]!=' ') {
                        fin=0;
                    }
                }
            }
        }
                
        Fin(fin);      
    }

    public void Fin(int fin){

        if(fin==1){
            new Fin(intscore);
            this.dispose();
        }
    }

    

    @Override
    public void mouseClicked(MouseEvent e)  {
        intscore=RecupScore();
        if(tupeutpascliquer!=true){
            changerfond();
            ChuteBoule();
            BougeGauche();
            TailleGroupe();
            score=score+0;
        }
        VerifFin();
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
            ImageJeu();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}