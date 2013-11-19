package l3app.td5.index;

import java.util.Iterator;

/**
 * This class allow to tokenize a text according to delimiter and line breaker.
 * 
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface Lexer {
    
    /**
     * Go the next matched text and tokenize it.
     * @return Information about the next tokenized object.
     */
    InfoWord nextWord();
    
    /**
     * Method that allow to move throught the file or text.
     * Implements Iterable.
     * @return 
     */
    Iterator iterator();
    
}
