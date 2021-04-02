import java.awt.event.*;
/**
* La classe <b><code>Grille</code></b> sert a gerer les action sur la page du menu.
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class Grille implements MouseMotionListener,MouseListener {
    /**
    * Composante qui sert a recup\u00e9rer le tableau si le mode de jeu choisie est Al\u00e9atoire.
    */
    
    public void RecupTabAlea(){
    }

    /**
    * Composante qui sert a recup\u00e9rer le tableau si le mode de jeu choisie est par fichier.
    */
    
    public void RecupTabChoix(){
    }

    /**
    * Composante qui affiche la page de jeux.
    */  
    public void ImageJeu(){
    }

    /**
    * Composante qui recup\u00e9re les Coordon\u00e9 x.
    *
    * @return la positon x de la souris
    */
    public int RecupX(){
        return Grille.x;
    }

    /**
    * Composante qui recup\u00e9re les Coordon\u00e9 y.
    *
    * @return la positon y de la souris
    */
    public int RecupY(){
        return Grille.y;
    }

    /**
    * Composante qui rafraichit le tableau de survol.
    */  
    public void ResetTabSurvol(){
    }

    /**
    * Composante qui verifie que la colonne est bien vide.
    *
    *@param colonnes position de la colonne (entre 0 et 14)
    *@return 1 si la colonne est vide et 0 si la colonne n'est pas vide 
    */  
    public int VerifColonne(int colonnes){
        for (int i=0; i<10; i++) {
            if (tab[i][colonnes]!=' ') {
                return 0;
            }
        }
        return 1;
    }

    /**
    * Composante qui decale la colonne \u00e0 gauche si celle-ci est vide. 
    */  
    public void BougeGauche() {
    }

    /**
    * Composante qui decale le pion vers le bas si le pion a \u00e9t\u00e9 cliqu\u00e9.
    */  
    public void ChuteBoule(){
    }

    /**
    * Composante qui recupere la taille du groupe et verifie qu'il soit superieure \u00e0 1.
    */  
    public void TailleGroupe(){
    }

    /**
    * Composante qui modifie le tableau lors du survol et change l'\u00e9tat et l'affichage de la grille
    */  
    public void ModifTAb(){ 
    }

    /**
    * Composante r\u00e9cursive qui regarde si les pions autour de lui dont de la m\u00eame couleur.
    *
    *@param x l'abcisse (entre 0 et 14)
    *@param y l'ordonn\u00e9e (entre 0 et 9)
    */  

    public void AutourCase(int x,int y){
    }

    /**
    * Composante qui rafraichit le tableau de pion.
    */  
    public void ResetTab(){
    }

    /**
    * Composante qui vide le tableau une fois cliquer 
    */  
    public void changerfond(){
    }
    
    /**
    * Composante qui calcul le score
    *
    *@param x l'abcisse (entre 0 et 14)
    *@param y l'ordonn\u00e9e (entre 0 et 9)
    */  
    public void Score(int x,int y){
    }

    /**
    * Composante qui renvoie le score
    *
    *@return le score en jeu 
    */  
    public int RecupScore(){
        return Grille.scoreajout;
    }

    /**
    * Composante qui verifie si c'est la fin du jeu 
    */  
    public void VerifFin(){
    }

    /**
    * Composante qui affiche la page de fin et renvoie le score \u00e0 celle-ci
    *
    *@param fin une variable fin (1 ou 0)
    */  
    public void Fin(int fin){
    }

    /**
    * Composante qui s'execute apres un  clique sur la souris.
    */
    public void mouseClicked(MouseEvent e){

    }

    /**
    * Composante qui s'execute apres un deplacement de la souris.
    */
    public void mouseMoved(MouseEvent e) {

    }
}