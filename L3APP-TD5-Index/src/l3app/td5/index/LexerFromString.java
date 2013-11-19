package l3app.td5.index;

import java.util.Iterator;

/**
 * This class implements Lexer and allow to tokenize a text from a String according
 * to delimiters and line breaker.
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
    
    /**
     * Initialise the text String and prepare for reading.
     * @param text String containing the text to index
     */
    public LexerFromString(String text) {
        this.text = text;
    }
    
    /**
     * Initialise the test String and Setup the delimiters and prepare for 
     * reading.
     * @param text String containing the text to index
     * @param delimiter contain the delimiters characters
     */
    public LexerFromString(String text, String delimiter) {
        this.text = text;
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
     * An iterator over the String.
     * @return Info - the information about the indexed key.
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
            if(position+1 >= text.length()){
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
