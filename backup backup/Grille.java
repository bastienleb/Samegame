import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener,MouseListener {
    private char tab[][]=new char[10][15];
    int x;
    int y;
    int ancienx;
    int ancieny;
    int posx;
    int posy;
    int tmpx;
    int tmpy;

    
    public Grille(){
        super("Grille");
        
        this.setSize(1125,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void RecupTabAlea(){
        TabAlea ta = new TabAlea();
        tab=ta.alea();

        for(int a=0; a<10;a++){  
            for(int b=0; b<15;b++){  
                System.out.print(tab[a][b]);
            }
            System.out.println("");
        }
    }

    public void RecupTabChoix(){
        TabChoix t=new TabChoix();
        tab=t.choix();

        for(int a=0; a<10;a++){  
            for(int b=0; b<15;b++){  
                System.out.print(tab[a][b]);
            }
            System.out.println("");
        }

    }
    
        
    public void ImageJeu(){
            
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
                    
                }
                //System.out.println("");
            }
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

        public void ModifTAb(){ 
            //System.out.println("Dans la fonction ");

            if(posx==tmpx && posy==tmpy){
                
                posx=RecupX();
                posy=RecupY();
                if(tab[posy][posx]=='R'){
                    tab[posy][posx]='r';
                    
                }
                if(tab[posy][posx]=='V'){
                    tab[posy][posx]='v';
                }
                if(tab[posy][posx]=='B'){
                    tab[posy][posx]='b';
                }
            }
        }
       

    @Override
    public void mouseClicked(MouseEvent e)  {
        //System.out.println("TA cliquer");
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        
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
            ImageJeu();
            
            //System.out.println(" x: "+x+" y :"+y);
        }
        
    }
public void mousePressed(MouseEvent e){}
public void mouseDragged(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseEntered(MouseEvent e){}
public void mouseReleased(MouseEvent e){}

}