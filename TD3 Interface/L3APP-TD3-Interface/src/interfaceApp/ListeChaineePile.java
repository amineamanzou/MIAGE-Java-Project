package interfaceApp;

import java.util.Iterator;

/**
 * Class that implements a stack with a static array.
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Eva Blot <eva.blot.eb@gmail.com>
 */
public class ListeChaineePile<E> implements Pile<E> {
    
    /**
     * Class that compose a LinkedList.
     */
    class Node {
        E elem;
        Node next;

        Node(E elem, Node next){
            this.elem = elem;
            this.next = next;
        }
    }
    private Node first;
    private int size = 0;
    
    // No need to use a constructor
    
    /**
     * Push an element at the top of this stack.
     * 
     * @param elem to add to the stack
     * @return boolean success 
     */
    @Override
    public boolean push(E elem){
        this.first = new Node(elem,this.first);
        this.size++;
        return (this.first != null);
    }
        
    /**
     * Remove an element from the stack and return it. Return null if empty.
     * @return E
     */
    @Override
    public E pop(){
        if(!empty()){
            E poped = this.first.elem;
            this.first = this.first.next;
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
        if(!empty()){
            return this.first.elem;
        }
        return null;
    }

    /**
     * Test if the stack is empty.
     * @return boolean true if and only if number of element equals to zero
     */
    @Override
    public boolean empty(){
        return (this.first == null && this.size == 0);
    }

    /**
     * Remove all the element from the stack.
     */
    @Override
    public void clear(){
        while(!empty()){
            pop();
        }
        this.size = 0;
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
     * An iterator over the Linked List from the top of the stack 
     * to the first pushed element.
     * @return E - the type of elements returned by this iterator
     */
    @Override
    public Iterator<E> iterator(){
        return new Itr();
    }
    
    private class Itr implements Iterator<E> {
        Node current = first;

        /**
         * Test if the next element exist and can return an Element
         * @return true if and only if next element is not null
         */
        @Override
        public boolean hasNext() {
            if(current == null){
                return false;
            }
            return true;
        }

        /**
         * Get the next element in the iteration.
         * @return E return the element of the next node.
         */
        @Override
        public E next() {
            if( current == null ) {
                current = first;
            }
            else {
                if( hasNext() ){
                    E temp = current.elem;
                    current = current.next;
                    return temp;
                }
            }
            return current.elem;
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
