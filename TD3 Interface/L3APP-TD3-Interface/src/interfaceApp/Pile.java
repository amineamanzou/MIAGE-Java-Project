package interfaceApp;

import java.util.Iterator;

/**
 * Interface of the data structure
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Eva Blot <eva.blot.eb@gmail.com>
 */
public interface Pile<E> {
        
	/**
         * Push an element at the top of this stack.
         * 
         * @param elem
         * @return boolean success 
         */
        boolean push(E elem);
        
        /**
         * Remove an element from the stack and return it.
         * @return E
         */
	E pop();
        
        /**
         * Look at the last object of this stack without removing it.
         * @return E
         */
	E peek();
        
        /**
         * Test if the stack is empty.
         * @return boolean
         */
	boolean empty();
        
        /**
         * Remove all the element from the stack.
         */
	void clear();
        
        /**
         * Return the number of element in the stack.
         * @return size
         */
	int size();
	
        /**
         * Method that allow to move throught the stack.
         * Implements Iterable.
         * @return 
         */
        Iterator<E> iterator();
}

