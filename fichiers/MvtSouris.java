import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MvtSouris extends JPanel implements MouseMotionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int cx;
    private int cy;
    private char[][] tab;
    private JFrame fenetre;

    public MvtSouris(char[][] tab,JFrame fenetre) {
        this.tab=tab;
        this.fenetre=fenetre;
    }

    public void mouseMoved(MouseEvent event){
        cx=event.getPoint().x;
        cy=event.getPoint().y;
        System.out.println("Dans le ifff");

        for (int i=0;i<10;i++){
            if((cx>=75+(75*i) && cx<=75+(75*i))&&(cy>=75 && cy<=75+(75*10))){
                for(int j=0;j<15;j++){
                    if((cx>=75 && cx<=75+(75*15))&&(cy>=75+(75*j) && cy<=75+(75*j))){
                        System.out.println("Dans le ifff");
                }
            }
            //	if((cx>=50+(50*i) && _X<=150+(50*i))&&(_Y>=50 && _Y<=50+(50*taille))){
    
    }

}


}

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}

