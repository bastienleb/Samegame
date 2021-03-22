import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class RecupFichier {

    public String recuperation() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        String chemin="a";

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            chemin=selectedFile.getPath();
            // System.out.println(chemin);
        }
        return chemin;
    }
}