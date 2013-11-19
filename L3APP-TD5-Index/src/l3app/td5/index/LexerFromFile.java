package l3app.td5.index;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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
    
    public LexerFromFile(String filename) {
        try {
            this.fp = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
    }
    
    public LexerFromFile(String filename, String delimiter) {
        try {
            this.fp = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
        this.delimiter = delimiter;
    }
    
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
    
    public String addDelimiter(String delimiter){
        StringBuilder result = new StringBuilder(this.delimiter);
        result.append(delimiter);
        this.delimiter = result.toString();
        return this.delimiter;
    }
    
    public String useDelimiter(String delimiter){
        this.delimiter = delimiter;
        return this.delimiter;
    }
    
    public String addLineSeparator(String lineSeparator){
        StringBuilder result = new StringBuilder(this.lineSeparator);
        result.append(lineSeparator);
        this.lineSeparator = result.toString();
        return this.lineSeparator;
    }
    
    public String useLineSeparator(String separator){
        this.lineSeparator = separator;
        return this.delimiter;
    }
    
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
    
    public boolean isLineSeparator(String character){
        if(character.matches(this.lineSeparator)){
            return true;
        }
        return false;
    }
    
    /**
     * An iterator over the static stack.
     * @return E - the type of elements returned by this iterator
     */
    @Override
    public Iterator iterator(){
        return new Itr();
    }
    
    private class Itr implements Iterator<InfoWord> {
        InfoWord current;
        
        /**
         * Test if the next element exist and can return an Element.
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
         * @return E return the next element of the iteration
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
         * Not implemented because doesn't have sense in a stack data structure.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
