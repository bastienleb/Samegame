import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelListener implements MouseListener
{
    private JPanel label;

    public PanelListener(JPanel label)
    {
        this.label = label;
    }

    @Override
    public void mouseClicked(MouseEvent evenement)          // un bouton cliqué
    {
    }

    @Override
    public void mouseEntered(MouseEvent evenement)          // debut du survol
    {
        
        System.out.println((evenement.getX()-14) + "," + evenement.getY());
        System.out.println("x="+((evenement.getX()-14)/75)+" y="+(evenement.getY()/75));
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

