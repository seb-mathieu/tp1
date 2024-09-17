package myapp.app;

import myapp.collections.EndOfListException;
import myapp.collections.Iterator;
import myapp.collections.List;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;

public class ApplicationTP2 {
    

    public void exo3(FileReader reader) throws IOException, EndOfListException  {
        List<String> wordList = TextFileTools.readFile(reader);
        Iterator<String> it = new Iterator<>(wordList);
        while (it.hasNext()) {
            System.out.format("%s ", it.next());
        }
    }

    public static void exo4(String directory) throws IOException, EndOfListException {
    Iterator<List<String>> it = new Iterator<>(TextFileTools.readDirectory(directory));
    while (it.hasNext()) {
        System.out.println("---------------------------");
        Iterator<String> wordIt = new Iterator<>(it.next());
        while (wordIt.hasNext()) {
            System.out.format("%s ", wordIt.next());
        }
        System.out.println();
    }
}
}
