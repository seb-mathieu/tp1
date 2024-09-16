package myapp.app;

import myapp.tools.FileReader;
import myapp.tools.ProcessFile;
import java.nio.file.Path;
import myapp.tools.TextFileTools;
import java.nio.charset.Charset;

import java.io.IOException;

public class ApplicationTP1 {
    public Character readChar(FileReader FileReader) {
        if(FileReader.isEndOfFile()) return null;
        return FileReader.readChar();
    }

    public int countAl(FileReader reader){
        var count = 0;
        var A = false;
        while (!reader.isEndOfFile()) {
            var currentChar = reader.readChar();
            if (A && (currentChar == 'l')){
                count = count + 1;
            }
            A = currentChar == 'a';
        }
        return count;
    }


    public int countWords(FileReader reader){
        var wordCount = 0;
        while(!reader.isEndOfFile()) {
            var charCount = 0;
            var currentChar = reader.readChar(); 
            while ((currentChar != ' ') && (currentChar != '.') && (currentChar != ',') && (currentChar != ';') && (currentChar != ':') && (currentChar != '\n')) {
                charCount= charCount + 1;
                if (reader.isEndOfFile()){ break;}
                currentChar = reader.readChar();
            }
            if (charCount > 0 ){
                wordCount= wordCount + 1;
            }
        }
        return wordCount;
    }

    public String[] read5Words(FileReader reader){
        String[] words = new String[5];
        var wordCount = 0;
        while((!reader.isEndOfFile()) && (wordCount < 5)){
            var currentChar = reader.readChar(); 
            var currentWord = "";
            while ((currentChar != ' ') && (currentChar != '.') && (currentChar != ',') && (currentChar != ';') && (currentChar != ':') && (currentChar != '\n') && (currentChar != '\r')) {
                currentWord += currentChar;
                if (reader.isEndOfFile()){ break;}
                currentChar = reader.readChar();
            }
            if (!currentWord.isEmpty()){
                words[wordCount]=currentWord;
                wordCount++ ;
            }
        }
        return words;
    }

    public static class Occurrences{
        char character;
        int count;
        
        public Occurrences(char character) {
            this.character = character;
        }

        public Occurrences(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public char getCharacter() {
            return character;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + character;
            result = prime * result + count;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Occurrences other = (Occurrences) obj;
            if (character != other.character)
                return false;
            if (count != other.count)
                return false;
            return true;
        }

        public void incrementCount() {
                    count++;
                }

        
    }
    
    public Occurrences[] countPunctuations(FileReader reader){
        Occurrences[] occurrences = new Occurrences[] {
            new Occurrences('.'),
            new Occurrences(','),
            new Occurrences(':'),
            new Occurrences(';'),
        };
        while(!reader.isEndOfFile()) {
            var currentChar = reader.readChar();

            for (Occurrences occurrence : occurrences){
                if (currentChar == occurrence.getCharacter()){
                    occurrence.incrementCount();
                }
            }
        }
        return occurrences;
    }
    public static class DisplayFileName implements ProcessFile {

        @Override
        public void process(Path fileName) {
            System.out.println(fileName); 
        }
    }
    public void displayDirectoryContent (String directory) throws IOException {
        //TextFileTools.walkDirectory(directory, new DisplayFileName());

        // TextFileTools.walkDirectory(directory, new ProcessFile(){
        
        //     @Override
        //     public void process(Path fileName) {
        //         System.out.println(fileName);
        //     }
        // });
        
        TextFileTools.walkDirectory(directory, fileName-> {
            System.out.println(fileName);
        });

    }

    public void displayFilesWithWord (String directory, String word) throws IOException{
        TextFileTools.walkDirectory(directory, fileName ->{
            FileReader reader = new FileReader(fileName.toString(), Charset.forName("Windows-1252"));
            if (TextFileTools.countWord(reader, word) > 0) {
                System.out.println(fileName);
            }
        });
    }
}

