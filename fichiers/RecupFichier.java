import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
*@author Kévin METRI et Bastien LEBLET
* Cette Class sert a récuperer le tableau a l'aide la fonction JFileChooser
*/

public class RecupFichier {

    public String recuperation() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        String chemin="";

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            chemin=selectedFile.getPath();
        }
        return chemin;
    }
}