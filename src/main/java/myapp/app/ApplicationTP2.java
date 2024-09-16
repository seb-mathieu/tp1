package myapp.app;

import myapp.collections.EndOfListException;
import myapp.collections.Iterator;
import myapp.collections.List;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;

public class ApplicationTP2 {
    

public void exo3(FileReader reader) throws IOException, EndOfListException {
    List <String> list = TextFileTools.readFile(reader);
    Iterator<String> it =  new Iterator<String>(list);
    while (it.hasNext()){
        System.out.format("%s", it.next());
    }
}

}
