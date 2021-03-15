import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame {
    private char tab[][]=new char[10][15];
    
    public Grille(){
        super("Grille");
        this.setSize(1125,790);
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
}