import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelListener implements MouseListener
{
    private JPanel label;
    // public Grille grille;
    private int posx=0;
    private int posy=0;

    


    public PanelListener(JPanel label)
    {
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent evenement)          // un bouton cliqué
    {
        posx=((evenement.getX()-14)/75);
        posy=(evenement.getY()/75);
        
        
    }

    @Override
    public void mouseEntered(MouseEvent evenement)          // debut du survol
    {
        if(evenement.getX()<(12+(75*15)) && evenement.getX()>12){
            if(evenement.getY()<(50+(75*10)) && evenement.getY()>31){
                posx=((evenement.getX()-16)/75);
                posy=((evenement.getY()-31)/75);

                if(posy >9){
                    posy=9;
                }
                if(posx <0){
                    posx=0;
                }

            }
            
        }
        
        Grille grille=new Grille(posx,posy);
        grille.ImageJ();
        //System.out.println((evenement.getX()-14) + "," + evenement.getY());
        // System.out.println("x="+posx+" y="+posy);
    }

    @Override
    public void mouseExited(MouseEvent evenement)           // fin du survol
    {

    }

    @Override
    public void mousePressed(MouseEvent evenement)          // un bouton appuyé
    {
        // Rien
    }

    @Override
    public void mouseReleased(MouseEvent evenement)         // un bouton relâché
    {
        // Rien
    }
}

