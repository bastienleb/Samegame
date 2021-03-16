import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame {
    private char tab[][]=new char[10][15];
    private int posx=0;
    private int posy=0;
    
    
    
    
    public Grille(){
        super("Grille");
        this.setSize(1230,885);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }

    public Grille(int x,int y){
        this.posx=x;
        this.posy=y;
        //System.out.println(tab[posy][posx]);
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

    public void RecupTabChoix(){
        TabChoix t=new TabChoix();        
        tab=t.choix();
        // for(int a=0; a<10;a++){  
        //     for(int b=0; b<15;b++){  
        //         System.out.print(tab[a][b]);
        //     }
        //     System.out.println("");
        //   }

    }

   
    public void ImageJ(){
        
        System.out.println("dans affichage ImageJeu AVEC ARG");

        
       
        for (int i=0;i<10;i++){
            String lettre=Character.toString(tab[posy][posx]);
            for(int j=0;j<15;j++){
                     System.out.println("x :"+posx+" y :"+posy);
                    
                    if(lettre.equals("R")){
                       System.out.println("R");

                    }
                    
                    if(lettre.equals("V")){
                        System.out.println("V");
                        
                    }
                    
                    if(lettre.equals("B")){
                        System.out.println("B");

                    }
                
                }
            }
            
            //System.out.println("");
        
           
    }
    
        
    public void ImageJeu(){
    
        System.out.println("dans affichage ImageJeu");
  
        JPanel panel =new JPanel();
        JPanel panscore = new JPanel();
        
        int score=0;
        JLabel labscore = new JLabel("score = "+ score);
        
        
        
        JPanel all= new JPanel();
        all.setLayout(null);
        panel.setBounds(0, 0, 1221, 815);
        panscore.setBounds(0,810,1221,40);
        labscore.setFont(new Font("Sérif",Font.BOLD,15));
        panscore.setBackground(Color.RED);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout());
        
        try 
        {
            for (int i=0;i<10;i++){
                for(int j=0;j<15;j++){
                    String lettre=Character.toString(tab[i][j]);
                    
                    
                    if(lettre.equals("R")){
                        BufferedImage img = ImageIO.read(new File("../image/rouge.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        pic.setBackground(Color.WHITE);
                        panel.add(pic);

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);

                        PanelListener list = new PanelListener(panel);
                        panel.addMouseListener(list);

                        panel.add(pic);

                        //System.out.print("R");

                    }
                    
                    if(lettre.equals("V")){
                        BufferedImage img = ImageIO.read(new File("../image/vert.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        pic.setBackground(Color.WHITE);
                        

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);

                        PanelListener list = new PanelListener(panel);
                        panel.addMouseListener(list);

                        panel.add(pic);
                    
                        //System.out.print("V");
                        
                    }
                    
                    if(lettre.equals("B")){
                        BufferedImage img = ImageIO.read(new File("../image/bleu.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        pic.setBackground(Color.WHITE);
                        

                        Superposition listener = new Superposition(pic);
                        pic.addMouseListener(listener);

                        PanelListener list = new PanelListener(panel);
                        panel.addMouseListener(list);

                        panel.add(pic);
        
                        //System.out.print("B");

                    }
                    
                }
                //System.out.println("");
            }
        panscore.add(labscore);
        all.add(panel);
        all.add(panscore);
        this.add(all);
        this.setVisible(true);
        
        }
        catch (IOException e) {}         
    }
}