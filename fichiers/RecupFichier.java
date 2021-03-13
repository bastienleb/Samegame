/*
@author Kévin METRI et Bastien LEBLET
*/

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class RecupFichier {

    public String recuperation() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        String chemin="a";

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            chemin=selectedFile.getPath();
            System.out.println(chemin);
        }
        return chemin;
    }
}
