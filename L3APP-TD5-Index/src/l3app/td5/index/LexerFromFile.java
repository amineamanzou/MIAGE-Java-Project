package l3app.td5.index;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * This class implements Lexer and allow to tokenize a text from a File according
 * to delimiters and line breaker.
 * 
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class LexerFromFile implements Lexer {

    FileInputStream fp;
    private boolean endOfFile = false;
    private int numLine = 1;
    private int numCol = 1;
    private String delimiter = "";
    private String lineSeparator = "[\n]";
    
    /**
     * Initialise the fileInputStream and prepare for reading.
     * @param filename name of the file
     */
    public LexerFromFile(String filename) {
        try {
            this.fp = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
    }
    
    /**
     * Initialise the fileInputStram and Setup the delimiters and prepare for 
     * reading.
     * @param filename name of the file
     * @param delimiter contain the delimiters characters
     */
    public LexerFromFile(String filename, String delimiter) {
        try {
            this.fp = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
        this.delimiter = delimiter;
    }
    
    /**
     * Tokenize the next word by passing throught the delimiter or character that
     * are not letter or digit and by fetching after the letterOrDigit.
     * @return 
     */
    @Override
    public InfoWord nextWord(){
        StringBuilder word = new StringBuilder();
        int current = 0;
        InfoWord result;
        
        try {
            current = this.fp.read();
        } catch (IOException e){
            System.err.println("Error : " + e);
            System.exit(1);
        }
        this.numCol++;
        while(  (this.isDelimiter(current) || this.isLineSeparator(Character.toString((char)current)))
                && current != -1){
            if( this.isLineSeparator(Character.toString((char)current))){
                this.numLine++;
                this.numCol = 1;
            }
            try {
                current = this.fp.read();
            } catch (IOException e) {
                System.err.println("Error : " + e);
                System.exit(1);
            }
            this.numCol++;
        }
        
        while(  !this.isDelimiter(current) && !this.isLineSeparator(Character.toString((char)current))
                && current != -1){
            word.append((char)current);
            try {
                current = this.fp.read();
            } catch (IOException e) {
                System.err.println("Error : " + e);
                System.exit(1);
            }
            this.numCol++;
        }
        result = new InfoWord(word.toString(),this.numLine,this.numCol-word.length()-1);
        
        if(current == -1){
            this.endOfFile = true;
        }
        if(word.length() == 0){
            return null;
        }
        
        return result;
    }
    
    /**
     * Add a String of new delimiters to the existing delimiters
     * @param delimiter String containing delimiter character
     * @return new delimiter
     */
    public String addDelimiter(String delimiter){
        StringBuilder result = new StringBuilder(this.delimiter);
        result.append(delimiter);
        this.delimiter = result.toString();
        return this.delimiter;
    }
    
    /**
     * Reset the existing delimiters and use a particular String of delimiters
     * @param delimiter String containing delimiter character
     * @return new delimiter
     */
    public String useDelimiter(String delimiter){
        this.delimiter = delimiter;
        return this.delimiter;
    }
    
    /**
     * Reset the existing lineSeparator and use a particular Regex
     * @param lineSeparator String containing lineSeparator Regex
     * @return new lineSeparator 
     */
    public String useLineSeparator(String separator){
        this.lineSeparator = separator;
        return this.delimiter;
    }
    
    /**
     * Test if Delimiter is set.
     * In this case we test if the character is in the list
     * Otherwise we test if the character is a Letter or Digit
     * @param character
     * @return true if the character is a delimiter
     */
    public boolean isDelimiter(int character){
        // if delimiter is set
        if(this.delimiter.length() > 0){
            // The character in Delimiter String are delimiter
            if(this.delimiter.contains(Character.toString((char)character))){
                return true;
            }
            return false;
        }
        else { // If delimiter is not set
            // All thing that are not LetterOrDigit are delimiter
            if(!Character.isLetterOrDigit((char)character)){
                return true;
            }
            return false;
        }
    }
    
    /**
     * Test if the character is matching the LineSeparator Regex.
     * @param character
     * @return true if the character is a line separator.
     */
    public boolean isLineSeparator(String character){
        if(character.matches(this.lineSeparator)){
            return true;
        }
        return false;
    }
    
    /**
     * An iterator over the index.
     * @return Info - the information about the key
     */
    @Override
    public Iterator iterator(){
        return new Itr();
    }
    
    private class Itr implements Iterator<InfoWord> {
        InfoWord current;
        
        /**
         * Test if the next element exist.
         * @return true if and only if next element is not null
         */
        @Override
        public boolean hasNext() {
            if(endOfFile){
                return false;
            }
            return true;
        }
        
        /**
         * Get the next element in the iteration.
         * @return Info about the next element of the iteration
         */
        @Override
        public InfoWord next() {
            if( !hasNext() ){
                return null;
            }
            current = nextWord();
            return current;
        }
        
        /**
         * Not implemented because doesn't need it necessarely.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
