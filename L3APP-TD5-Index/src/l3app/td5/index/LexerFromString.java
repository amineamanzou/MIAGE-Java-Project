package l3app.td5.index;

import java.util.Iterator;

/**
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class LexerFromString implements Lexer {
    
    private String text;
    private int position = 0;
    private int numLine = 1;
    private int numCol = 1;
    private String delimiter = "";
    private String lineSeparator = "[\n]";
    
    public LexerFromString(String text) {
        this.text = text;
    }
    
    public LexerFromString(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }
    
    @Override
    public InfoWord nextWord(){
        StringBuilder word = new StringBuilder();
        char current = this.text.charAt(position);
        this.numCol++;
        position++;
        InfoWord result;
        while( (this.isDelimiter(current) || this.isLineSeparator(Character.toString(current)))
                && position+1 < this.text.length() ){
            if( this.isLineSeparator(Character.toString(current))){
                this.numLine++;
                this.numCol = 1;
            }
            this.numCol++;
            current = this.text.charAt(position);
            position++;
        }
        while( !this.isDelimiter(current) && !this.isLineSeparator(Character.toString(current))
                && position+1 < this.text.length()){
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
    
    public boolean isDelimiter(char character){
        // if delimiter is set
        if(this.delimiter.length() > 0){
            // The character in Delimiter String are delimiter
            if(this.delimiter.contains(Character.toString(character))){
                return true;
            }
            return false;
        }
        else { // If delimiter is not set
            // All thing that are not LetterOrDigit are delimiter
            if(!Character.isLetterOrDigit(character)){
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
     * An iterator over the String.
     * @return InfoWord - the type of elements returned by this iterator
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
