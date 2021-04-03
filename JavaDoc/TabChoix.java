import java.io.*;
import java.util.*;

/**
* La classe <b><code>TabChoix</code></b> sert \u00e0 remplir un tableau a l'aide d'un fichier.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class TabChoix{
    /**
    * Composante qui remplie un tableau.
    *
    *@return le tableau apr\u00e8s l'avoir remplie avec un fichier
    */
    public char[][] choix() {
        return TabChoix.tab;
    }
    
    /**
    * Composante qui retourne un validation.
    *
    *@return valider (0 ou 1)
    */
    public int verif(){
        return TabChoix.valider;
    }   
}