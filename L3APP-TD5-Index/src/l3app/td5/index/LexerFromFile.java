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
    private boolean endOfFile;
    private int numLine;
    private int numCol;
    
    public LexerFromFile(String filename) {
        try {
            this.fp = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
        this.numLine = 1;
        this.numCol = 1;
        this.endOfFile = false;
    }
    
    @Override
    public InfoWord nextWord(){
        StringBuilder word = new StringBuilder();
        int current = 0;
        InfoWord result;
        
        try {
            current = this.fp.read();
        } catch (IOException e) {
            System.err.println("Error : " + e);
            System.exit(1);
        }
        this.numCol++;
        while(!Character.isLetterOrDigit(current) && current != -1){
            if(current == '\n'){
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
        
        while(Character.isLetterOrDigit(current) && current != -1){
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
