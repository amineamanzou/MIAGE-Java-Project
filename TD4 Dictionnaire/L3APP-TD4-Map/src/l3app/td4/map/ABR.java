package l3app.td4.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary tree that implement map
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Eva Blot <eva.blot.eb@gmail.com>
 */
public class ABR<K extends Comparable<K>, V> implements Dictionnaire<K,V> {
    
    private class Node {
        K key;
        V value;
        ABR<K,V> fg;
        ABR<K,V> fd;
        
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            fg = null;
            fd = null;
        }
    }
    
    private Node racine;
    private int size;
    
    public ABR(){
        this.racine = null;
        this.size = 0;
    }
    
    public ABR(K key, V value){
        this.racine = new Node(key,value);
        this.size = 1;
    }
    
    /**
     * Put a key-value in the map.
     * method "put" will add a node if the racine is empty, and will increment "size"
     * the method will compare the key put in arguement with the key of the racine
     * if they are eguals we will keep the racine value in temporary variable (that will be return at the end)
     * and we replace the previous key (the racine one) by the key in argument
     * idem for the value
     * if the two key aren't eguals (it's the same treatement for superior and inferior) 
     * we will test if the fg is empty at first (if it's the case, we creat a new tree 
     * that will be the fg tree, if it's not the case, we call the methode for the fg tree)
     * and in second if fd is empty (same process for fd). And the method increment size
     * 
     * @param key key that we want to insert.
     * @param value value that we want to insert.
     * @return value of the created key or old value of the replaced key.
     */
    @Override
    public V put(K key, V value) {
        if(isEmpty()){
            this.racine = new Node(key,value);
            this.size++;
            return this.racine.value;
        }
        int cmp = key.compareTo(this.racine.key);
        if (cmp == 0){
            V tmp = this.racine.value;
            this.racine.key = key;
            this.racine.value = value;
            return tmp;
        }
        if (cmp < 0) {
            if(this.racine.fg == null){
                this.racine.fg = new ABR(key,value);
            }
            else {
                this.racine.fg.put(key,value);
            }
            this.size++;
            return null;
        }
        else {
            if(this.racine.fd == null){
                this.racine.fd = new ABR(key,value);
            }
            else {
                this.racine.fd.put(key,value);
            }
            this.size++;
            return null;
        }
    }

    /**
     * Find a key (the one put in argument)
     * we use a comparator, which compare the key in argument with the
     * key of the racine
     * if they are eguals, the methode return the value of the racine, if not the
     * methode is used again for the fg tree (or the fd tree)
     * 
     * Returns the value of the key or null if the key doesn't exist.    
     * @param key that we want to get.
     * @return value of the researched key in the map of null if the key doesn't exist
     */
    @Override
    public V get(K key) {
        if(isEmpty()){
            return null;
        }
        int cmp = key.compareTo(this.racine.key);
        if (cmp == 0){
            return this.racine.value;
        }
        if (cmp < 0) {
            return this.racine.fg.get(key);
        }
        else {
            return this.racine.fd.get(key);
        }
    }

    @Override
    public boolean exist(K key) {
        if(isEmpty()){
            return false;
        }
        int cmp = key.compareTo(this.racine.key);
        if (cmp == 0){
            return true;
        }
        if (cmp < 0) {
            if(this.racine.fg != null){
                if(this.racine.fg.exist(key)){
                    return true;
                }
            }
        }
        else {
            if(this.racine.fd != null){
                if(this.racine.fd.exist(key)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Remove a key from this map if it exist.
     * Return the value of the removed key or null if the key
     * doesn't exist.
     * the method move in the tree to find the key we want to remove
     * until we find the key, we call again the fonction "remove" on the 
     * fg and fd tree
     * When we find the key (when the two keys compared are eguals the method call
     * an othr one to remove)
     * @param key that we want to remove.
     * @return value of the deleted key or null if the key doesn't exist.
     */
    @Override
    public V remove(K key) {
        if(this.racine == null){
            return null;
        }
        else {
            int cmp = key.compareTo(this.racine.key);
            if(cmp == 0) {
                return this.removeHelper(key);
            }
            else if(cmp < 0){
                return this.racine.fg.remove(key);
            }
            else {
                return this.racine.fd.remove(key);
            }
        }
    }
    
    /**
     * Helper for the method remove that treat all different cases
     * when it's just node that we want to remove
     * when the fg or the fd exist
     * and when fg and the fd exist (the method will call the fonction getMax() to 
     * help)

     * @param key that we want to remove.
     * @return a value
     */
    private V removeHelper(K key){
        if(this.racine == null ){
            return null;
        }
        else {
            // Case where it is at the end of the tree 
            if(this.racine.fd == null && this.racine.fg == null) {
                V tmp = this.racine.value;
                this.racine = null;
                return tmp;
            }
            // Case where the fd is null and fg exist
            if(this.racine.fd == null && this.racine.fg != null) {
                V tmp = this.racine.value;
                this.racine = this.racine.fg.racine;
                return tmp;
            }
            // Case where the fg is null and fd exist
            if(this.racine.fd != null && this.racine.fg == null) {
                V tmp = this.racine.value;
                this.racine = this.racine.fd.racine;
                return tmp;
            }
            if(this.racine.fd != null && this.racine.fg != null) {
                if(this.racine.fd.racine == null && this.racine.fg.racine != null) {
                    V tmp = this.racine.value;
                    this.racine = this.racine.fg.racine;
                    return tmp;
                }
                // Case where the fg is null and fd exist
                if(this.racine.fd.racine != null && this.racine.fg.racine == null) {
                    V tmp = this.racine.value;
                    this.racine = this.racine.fd.racine;
                    return tmp;
                }
                V tmp = this.racine.value;
                ABR<K,V> arbreMax = this.racine.fg.getMax();
                this.racine.key = arbreMax.racine.key;
                this.racine.value = arbreMax.racine.value;
                this.racine.fg.removeHelper(arbreMax.racine.key);
                return tmp;
            }
        }
        return null;
    }
    
    /**
     * Find the value maximal in the tree
     * @return a tree
     */
    public ABR<K,V> getMax(){
        if(this.racine == null){
            return null;
        }
        else {
            if(this.racine.fd != null){
                return this.racine.fd.getMax();
            }
            else {
                return this;
            }
        }
    }
    
    /**
     * Find the value minimal in the tree
     * @return a tree
     */
    public ABR<K,V> getMin(){
        if(this.racine == null){
            return null;
        }
        else {
            if(this.racine.fg != null){
                return this.racine.fg.getMin();
            }
            else {
                return this;
            }
        }
    }
    
    /**
     * Test if the tree is empty.
     * @return true if is empty
     */
    @Override
    public boolean isEmpty() {
        return (this.racine == null);
    }

    /**
     * Return the number of element in the tree
     * @return number of entry
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Erase all the element in the tree
     */
    @Override
    public void clear() {
        this.racine = null;
        this.size = 0;
    }

    @Override
    public K[] getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * 
     * @return the height of the tree
     */
    public int height(){
        return heightHelper(this,0);
    }
    
    private int heightHelper(ABR<K,V> arbre, int degres){
        if(arbre.racine == null){
            return degres;
        }
        else {
            int heightD = 0, heightG = 0;
            if(arbre.racine.fg != null){
                heightG = heightHelper(arbre.racine.fg,degres+1);
            }
            else {
                heightG = degres;
            }
            if(arbre.racine.fd != null){
                heightD = heightHelper(arbre.racine.fd,degres+1);
            }
            else {
                heightD = degres;
            }
            return Math.max(heightD, heightG);
        }
    }
    
    /**
     * The method will return true if the tree id well balanced
     * @return true or false
     */
    @Override
    public boolean isBalanced(){
        if(this.racine == null){
            return true;
        }
        else {
            int heightD = 0, heightG = 0;
            if(this.racine.fg != null && this.racine.fg.racine != null){
                heightG = this.racine.fg.height();
            }
            else {
                heightG = 0;
            }
            if(this.racine.fd != null && this.racine.fd.racine != null){
                heightD = this.racine.fd.height();
            }
            else {
                heightD = 0;
            }
            if(Math.abs(heightD-heightG) > 1){
                return false;
            }
            
            if(this.racine.fd != null && this.racine.fg != null){
                return this.racine.fd.isBalanced() && this.racine.fg.isBalanced();
            }
            return true;
        }
    }
    
    /**
     * Reorganize an tree to make it balanced.
     */
    @Override
    public void reorganize(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Fill an array with node begining from the number deb
     * @param deb number of the cell where to begin to fill
     * @param t array t
     * @return the number of the next free cell in the array.
     */
    private int fillArray(int deb, Node[] t){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Construct a Node from a part of a sorted array.
     * @param t
     * @param deb number of the cell where to begin reading
     * @param end number of the cell where to end reading
     * @return Node with all structure of node that was in the array from deb to end
     */
    private Node treeFromSortedArray(Node[] t, int deb, int end){
//        int milieu = (deb+end)/2;
//        
//        Node result = new Node(t[milieu].key,t[milieu].value);
//        while(deb<end){
//            
//        }
//        result.fd.put(t[milieu].key,t[milieu].value);
//        return result;
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Print the tree
     * @return result
     */
    @Override
    public String toString() {
        return toStringHelper(this,0,"+- ",false);
    }
    
    private String toStringHelper(ABR<K,V> arbre, int degres, String result, boolean isDroit) {
        String tab = new String("    ");
        for(int i = 0; i < degres; i++){
            if(isDroit){
                tab += "    ";
            }
            else {
                tab += "|   ";
            }
        }
        if(arbre == null){
            result = result + tab + "vide\n";
            return result;
        }
        else {
            if(arbre.racine != null) {
                result += arbre.racine.key + "="+ arbre.racine.value + "\n";
                if(arbre.racine.fg != null){
                    result = result + tab + "|- ";
                    result = toStringHelper(arbre.racine.fg,degres+1,result,false);
                }
                else if(arbre.racine.fd != null) {
                    result = result + tab + "|- vide\n";
                }
                if(arbre.racine.fd != null){
                    result = result + tab + "+- ";
                    result = toStringHelper(arbre.racine.fd,degres+1,result,true);
                }
                else if(arbre.racine.fg != null){
                    result = result + tab + "+- vide\n";
                }
                return result;
            }
            else {
                result = result + "vide\n";
                return result;
            }
        }
    }
}
