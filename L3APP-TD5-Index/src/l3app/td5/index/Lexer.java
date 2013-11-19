package l3app.td5.index;

import java.util.Iterator;

/**
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface Lexer {
    
    InfoWord nextWord();
    
    /**
     * Method that allow to move throught the stack.
     * Implements Iterable.
     * @return 
     */
    Iterator iterator();
    
}
