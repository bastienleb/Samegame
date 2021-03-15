import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Superposition implements MouseMotionListener,MouseListener {
    private JLabel label;

    public Superposition(JLabel label)
    {
        this.label = label;
        label.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent evenement)          // un bouton cliqué
    {
        label.setBackground(Color.WHITE);
        System.out.println(evenement.getX() + "," + evenement.getY());
    }

    @Override
    public void mouseEntered(MouseEvent evenement)          // debut du survol
    {
        label.setBackground(Color.YELLOW);
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