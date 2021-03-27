import javax.swing.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a recuperer une image et a la paint 
*/
public class Image extends JComponent{
  

    private final java.awt.Image img;
        
    public Image(java.awt.Image image)
    {
        img = image;
    }
    
    @Override
    public void paint(java.awt.Graphics g)
    {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null, null);
    }
}