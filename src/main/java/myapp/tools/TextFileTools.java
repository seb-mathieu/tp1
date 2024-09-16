package myapp.tools;
import java.io.IOException;
import  java.nio.file.Files;
import  java.nio.file.Path;
import  java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileTools {
    
    public static String readWord(FileReader reader) {

        if(reader.isEndOfFile()) return null;
            var currentChar = reader.readChar();
            var currentWord = "";
            while ((currentChar != ' ') && (currentChar != '.') && (currentChar != ',') && (currentChar != ';') && (currentChar != ':') && (currentChar != '\n') && (currentChar != '\r')) {
                currentWord += currentChar;
                if (reader.isEndOfFile()){ break;}
                currentChar = reader.readChar();
            }
        
        return currentWord;
    }

    public static int countWord(FileReader reader, String currentWord) {
        if(reader.isEndOfFile()) return 0;

        var word="";
        var count=0;

        while ((word = readWord(reader)) != null) {
            if(currentWord.equals(word)){
                count++;
            }
        }
        return count;
    }

    public static void walkDirectory( String directory, ProcessFile processFile) throws IOException {
        Files.walk(Paths.get(directory))
                .filter(Files::isRegularFile)
                .sorted()
                .forEach(processFile::process);
        
    }

public static List<String> readFile(FileReader reader) {
    List<String> wordList = new ArrayList<>();
    String word;
    while ((word = readWord(reader)) != null) {
        wordList.add(word);
    }
    return wordList;
}

    
}
