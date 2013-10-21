package interfaceApp;

import java.util.Iterator;

/**
 * Class that implements a stack with a dynamic array.
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Eva Blot <eva.blot.eb@gmail.com>
 */
public class TabDynamiquePile<E> implements Pile<E> {
    
    private E[] tab;
    private int size;
    private int allocatedLength;
    
    public TabDynamiquePile(int length) {
        this.tab = (E[]) new Object[length];
        this.size = 0;
        this.allocatedLength = length;
    }
    
    /**
     * Push an element at the top of this stack.
     * Realloc a new array when tab is full.
     * 
     * @param elem to add to the stack
     * @return boolean success 
     */
    @Override
    public boolean push(E elem){
        if(size != tab.length){
            this.tab[this.size] = elem;
            this.size++;
            return true;
        }
        else {
            E[] temp = this.tab;
            int i = 0;
            this.tab = (E[]) new Object[this.tab.length+this.allocatedLength];
            for(i=0;i<temp.length;i++){
                this.tab[i] = temp[i];
            }
            this.tab[this.size] = elem;
            this.size++;
            return true;
        }
    }
    
    /**
     * Remove an element from the stack and return it. Return null if empty.
     * @return E
     */
    @Override
    public E pop(){
        if(!empty()){
            E poped = this.tab[this.size-1];
            this.tab[this.size-1] = null;
            this.size--;
            return poped;
        }
        return null;
    }

    /**
     * Look at the last object of this stack without removing it.
     * @return E the last pushed element to the stack
     */
    @Override
    public E peek(){
        if(empty()){
            return null;
        }
        return this.tab[this.size-1];
    }

    /**
     * Test if the stack is empty.
     * @return boolean true if and only if number of element equals to zero
     */
    @Override
    public boolean empty(){
        return ( this.size == 0 && this.tab[0] == null );
    }

    /**
     * Remove all the element from the stack.
     */
    @Override
    public void clear(){
        while(!empty()){
            pop();
        }
    }

    /**
     * Return the number of element in the stack.
     * @return size the number of element in the stack.
     */
    @Override
    public int size(){
        return size;
    }
    
    /**
     * An iterator over the dynamic stack.
     * @return E - the type of elements returned by this iterator
     */
    @Override
    public Iterator<E> iterator(){
        return new Itr();
    }
    
    private class Itr implements Iterator<E> {
        E current;
        int indiceCurrent;
        
        /**
         * Test if the next element exist and can return an Element
         * @return true if and only if next element is not null
         */
        @Override
        public boolean hasNext() {
            if(tab.length-1 == indiceCurrent){
                return false;
            }
            if(tab[indiceCurrent+1] != null){
                return true;
            }
            else {
                return false;
            }
        }

        /**
         * Get the next element in the iteration.
         * @return E return the next element of the iteration
         */
        @Override
        public E next() {
            if( !hasNext() ){
                return null;
            }
            if( current == null ) {
                current = tab[0];
                indiceCurrent = 0;
            }
            else {
                indiceCurrent++;
                current = tab[indiceCurrent];
            }
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
