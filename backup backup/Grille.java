import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener {
    private char tab[][]=new char[10][15];
    private Random choix=new Random();
    
    public Grille(){
        super("Grille");
        this.addMouseMotionListener(this);

        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public void AfficheGrille(){
        
        
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
        System.out.println("");
        new Actionmenu(tab);
        
    }
        
    public void ImageJeu(){
        
            System.out.println("dans affichage ImageJeu");
            JFrame fenetre = new JFrame();
            fenetre.setLocationRelativeTo(null);
            fenetre.setResizable(false);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setLayout(new GridLayout(15,10));
            
            JPanel panel =new JPanel();
            
            panel.setLayout(new GridLayout(10,15));
            
            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    this.add(panel);
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
                    
                }
                //System.out.println("");
            }
            
            this.setVisible(true);
        }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
        //this.repaint();
        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        
        int x=e.getX();
        int y=e.getY();
         
        //System.out.println("x="+x+" y="+y);
        for (int i = 0; i < 15; ++i){
            if((x>=8+(75*i) && x<=9+(75*i))&&(y>=31 && y<=5+(75*10))){
                //System.out.println("DANS LE IF I : "+i);
                for(int j=0;j<10;j++){
                    if((x>=8 && x<=9+(75*15))&&(y>=31+(75*j) && y>=5+(75*j))){
                        System.out.println(/*"I:"+i+*/" J:"+j);
                    }
                }
            }   
        }
    }
}
    