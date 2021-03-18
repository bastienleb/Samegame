import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Superposition implements MouseMotionListener,MouseListener {
    private JLabel label;
    private int panx;
    private int pany;
    private Grille grille;

    public Superposition(JLabel label,int x,int y)
    {
        this.label = label;
        this.panx=x;
        this.pany=y;
        label.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent evenement)          // un bouton cliqué
    {
        //System.out.println(evenement.getX() + "," + evenement.getY());
    }

    @Override
    public void mouseEntered(MouseEvent evenement)          // debut du survol
    {
        label.setBackground(Color.YELLOW);
        //System.out.println(evenement.getX()+" et "+evenement.getY());
        panx=grille.RecupX();
        pany=grille.RecupY();
        System.out.println("coord de pan dans sup = "+panx+","+pany+"////DANS SUPPERPOSITION");
        
    }

    @Override
    public void mouseExited(MouseEvent evenement)           // fin du survol
    {
        label.setBackground(Color.WHITE);
    }

    @Override
    public void mousePressed(MouseEvent evenement)          // un bouton appuyé
    {
        //rien
    }

    @Override
    public void mouseReleased(MouseEvent evenement)         // un bouton relâché
    {
        // rien
    }

    @Override
    public void mouseDragged(MouseEvent evenement) {        // bouton rester cliqué
        //rien
    }     

    @Override
    public void mouseMoved(MouseEvent evenement) {          // mouvement souris 
        //rien
    }


}