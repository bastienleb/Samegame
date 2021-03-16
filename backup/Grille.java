import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
@author Kévin METRI et Bastien LEBLET
*/

public class Grille extends JFrame implements MouseMotionListener,MouseListener{
    private char tab[][]=new char[10][15];
    private int posx=0;
    private int posy=0;
    
    
    
    
    public Grille(){
        super("Grille");
        this.setSize(1230,885);
        this.setLocationRelativeTo(null);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
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

   
    public void ImageJ(int x,int y){
        
            if((x==0)&&(y==0)){
                System.out.println("erreur ");
            }
        
             System.out.println("x :"+x+" y :"+y);
        
                
        // this.add(panel);
        String lettre=Character.toString(tab[y][x]);
        for (int i=0;i<10;i++){
            for(int j=0;j<15;j++){
                    
                    if(lettre.equals("R")){
                        //  panel.add(new Image(new ImageIcon("../image/rouge_j.png").getImage()));
                        // panel.repaint();
                       System.out.println("R");

                    }
                    
                    if(lettre.equals("V")){
                        // panel.add(new Image(new ImageIcon("../image/vert_j.png").getImage()));
                    //    panel.repaint();
                        System.out.println("V");
                        
                    }
                    
                    if(lettre.equals("B")){
                        //  panel.add(new Image(new ImageIcon("../image/bleu_j.png").getImage()));
                    //    panel.repaint();
                        System.out.println("B");

                    }
                
                }
            }
            
            //System.out.println("");
        
           
        this.setVisible(true);
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
            panel.addMouseListener(new MouseAdapter() {
                @Override 
                public void mousePressed(MouseEvent e) {
                    System.out.println(e.getX() + "," + e.getY());
                    ImageJ((e.getX()/75), (e.getY()/75));
        }
      });
            for (int i=0;i<10;i++){
        
                for(int j=0;j<15;j++){
                    String lettre=Character.toString(tab[i][j]);
                    
                    
                    if(lettre.equals("R")){
                        BufferedImage img = ImageIO.read(new File("../image/rouge.png"));
                        JLabel pic = new JLabel(new ImageIcon(img));
                        pic.setBackground(Color.WHITE);
                        panel.add(pic);

                        Superposition listener = new Superposition(pic);
                        pic.addMouseMotionListener(this);
                        pic.addMouseListener(this);
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
                        pic.addMouseMotionListener(this);
                        pic.addMouseListener(this);
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
                        pic.addMouseMotionListener(this);
                        pic.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e)  {
        
        
        // System.out.println(" x: "+(x/75)+" y :"+(y/75));  
        
        int x=(e.getX()/75);
        int y=(e.getY()/75);  
        
        //  System.out.println("x="+x+" y="+y);
        
        // ImageJ(x, y);
        
    }
    
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
        
        
        // System.out.println(" x: "+x+" y :"+y);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
}
