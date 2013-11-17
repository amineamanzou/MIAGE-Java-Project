package l3app.td5.index;

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
public class LexerFromString implements Lexer {
    
    public static final boolean caseSensitive = false;
    
    private String text;
    private int position;
    private int numLine;
    private int numCol;
    
    public LexerFromString(String text) {
        this.text = text;
        this.position = 0;
        this.numLine = 1;
        this.numCol = 1;
    }
    
    @Override
    public InfoWord nextWord(){
        StringBuilder word = new StringBuilder();
        char current = this.text.charAt(position);
        this.numCol++;
        position++;
        InfoWord result;
        
        while(!Character.isLetterOrDigit(current) && position+1 < this.text.length()){
            if(current == '\n'){
                this.numLine++;
                this.numCol = 1;
            }
            current = this.text.charAt(position);
            this.numCol++;
            position++;
        }
        while(Character.isLetterOrDigit(current) && position+1 < this.text.length()){
            word.append(current);
            current = this.text.charAt(position);
            this.numCol++;
            position++;
        }
        result = new InfoWord(word.toString(),this.numLine,this.numCol-word.length()-1);
        
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
            if(position+1 >= text.length()){
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
