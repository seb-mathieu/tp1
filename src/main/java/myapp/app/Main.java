package myapp.app;

import myapp.app.ApplicationTP1.Occurrences;
import myapp.collections.EndOfListException;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationHelloWorld app = new ApplicationHelloWorld();
        app.sayHello();
 
        var FileName = args[0];
        FileReader fileReader = new FileReader(FileName);
        ApplicationTP1 application = new ApplicationTP1();
        /*Character c = application.readChar(fileReader);
        if (c != null) {
            System.out.println(c);
        } else {
            System.err.println("Fichier vide");
        }*/
       
        //System.out.format("Nombre de 'al' dans le fichier: %d%n", application.countAl(fileReader));
       
        //System.out.format("Nombre de mots dans le fichier: %d%n", application.countWords(fileReader));
        
        //System.out.println(Arrays.toString(application.read5Words(fileReader)));
        
        // for(Occurrences occurrences : application.countPunctuations(fileReader)){
        //     System.out.format("Nombre de %c dans le fichier:%d%n", occurrences.getCharacter(), occurrences.getCount());
        // }
        
        //System.out.format("le mot 'et' apparait %d dans le fichier %n", TextFileTools.countWord(fileReader, "et"));
        
        // try {
        //     application.displayDirectoryContent("textes");
        // } catch (IOException ioe) {
        //     System.err.format("Erreur lors du parcours du répertoire : %s\n", ioe.getMessage());
        // }
        
        // System.out.format("voici les dossier contenant le mot'conformément' dans des fichiers:%n");
        // try{
        //     application.displayFilesWithWord("textes", "conformément");
        // } catch(IOException ioe) {
        //     System.err.format("Erreur lors du parcours du répertoire : %s\n", ioe.getMessage());
        // }
        
        try {
            /*ApplicationTP2.exo4("textes");*/
            ApplicationTP2.exo4("textes");
        } catch (EndOfListException e) {
            e.printStackTrace();
        }
    }
}
