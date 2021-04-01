import javax.swing.*;
import java.awt.event.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a la detection des action de la page de fin
*/

public class ActionFin implements MouseListener{
    JFrame f = new JFrame();

    public ActionFin(JFrame frame){
        this.f=frame; 
    }

    @Override
    public void mouseClicked(MouseEvent e){

        if((e.getX()>260 && e.getX()<475) &&(e.getY()>455 && e.getY()<555)){
            f.dispose();
            new Menu();
        }

        if((e.getX()>520 && e.getX()<740) &&(e.getY()>455 && e.getY()<555)){
           f.dispose();
        }
    }
    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
