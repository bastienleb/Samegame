import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener,MouseListener {
    private char tab[][]=new char[10][15];
    int i;
    
    public Grille(){
        super("Grille");
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setSize(1125,790);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Grille(int i){
        this.i=i;
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

    public char[][] returnTab(){
        return tab;
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
    
        System.out.println("dans affichage ImageJeu");
  
        JPanel panel =new JPanel();
        JPanel panscore = new JPanel();

        JLabel score = new JLabel("score");
        
        JPanel all= new JPanel();
        all.setLayout(null);
        panel.setBounds(0, 0, 1112, 717);
        panscore.setBounds(0,715,1125,40);
        score.setFont(new Font("Sérif",Font.BOLD,15));
        panscore.setBackground(Color.RED);
        
        panel.setLayout(new GridLayout(10,15));
        try 
        {
            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    String lettre=Character.toString(tab[i][j]);
                    
                    
                    if(lettre.equals("R")){
                        BufferedImage img = ImageIO.read(new File("../image/rouge.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        panel.add(pic);

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);

                        //System.out.print("R");

                    }
                    
                    if(lettre.equals("V")){
                        BufferedImage img = ImageIO.read(new File("../image/vert.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        panel.add(pic);

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);
                    
                        //System.out.print("V");
                        
                    }
                    
                    if(lettre.equals("B")){
                        BufferedImage img = ImageIO.read(new File("../image/bleu.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        panel.add(pic);

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);
        
                        //System.out.print("B");

                    }
                    
                }
                //System.out.println("");
            }
        
        }
        catch (IOException e) {} 
        
        panscore.add(score);
        all.add(panel);
        all.add(panscore);
        this.add(all);
        this.setVisible(true);
        
    }



        public void ImageJeu(int x,int y){
        
            // System.out.println("dans affichage ImageJeu AVEC ARG");
  
            
            JPanel panel =new JPanel();
            
            panel.setLayout(new GridLayout(10,15));
            
            
                    
            this.add(panel);
            for (int i=0;i<10;i++){
                String lettre=Character.toString(tab[y][x]);
                for(int j=0;j<15;j++){
                         System.out.println("x :"+x+" y :"+y);
                        
                        if(lettre.equals("R")){
                            panel.add(new Image(new ImageIcon("../image/rouge_j.png").getImage()));
                            panel.repaint();
                           System.out.println("R");

                        }
                        
                        if(lettre.equals("V")){
                            panel.add(new Image(new ImageIcon("../image/vert_j.png").getImage()));
                            panel.repaint();
                            System.out.println("V");
                            
                        }
                        
                        if(lettre.equals("B")){
                            panel.add(new Image(new ImageIcon("../image/bleu_j.png").getImage()));
                            panel.repaint();
                            System.out.println("B");

                        }
                    
                    }
                }
                
                //System.out.println("");
            
               
            this.setVisible(true);
        }

    @Override
    public void mouseClicked(MouseEvent e)  {
        int x=(e.getX()/75);
        int y=(e.getY()/75);  
         
        //System.out.println("x="+x+" y="+y);
        ImageJeu();
        ImageJeu(x, y);

    }
    // System.out.println(" x: "+(x/75)+" y :"+(y/75));  


@Override
public void mouseMoved(MouseEvent e) {
    
    int x=(e.getX()/75);
    int y=(e.getY()/75);   
    
    

            // System.out.println(" x: "+x+" y :"+y);
    }
public void mousePressed(MouseEvent e){}
public void mouseDragged(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseEntered(MouseEvent e){}
public void mouseReleased(MouseEvent e){}

}
    