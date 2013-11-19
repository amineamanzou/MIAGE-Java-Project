package l3app.td5.index;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This Class is an implementation of an index that offer the possibilitie to
 * store the number of the lines where the word appear in a texte.
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @param <K> the used key to store data in this implementation it's a String 
 * that we index
 * @param <V> the value associated to the key, in our implementation it's a ordred
 * list of line where the key appear in the source texte.
 */
public class IndexTreeMap<K extends Comparable<K>, V extends Comparable<V>> implements Index<K, V> {
    
    /* The tree that allow to order and store keys
     * In our cas we associate a key to a list of Element V
     */
    private SortedMap<K, TreeSet<V>> tree;
    /* Allow to choose if the index is case sensitive or not */
    private boolean caseSensitive ;
    
    /**
     * Default Constructor : initialise the tree 
     * By default case sensitive is activated
     */
    IndexTreeMap() {
        this.tree = new TreeMap<K, TreeSet<V>>();
        caseSensitive = true;
    }
    
    /**
     * Default Constructor : initialise the tree 
     * @param caseSensitive define if the index is case sensitive or not
     */
    IndexTreeMap(boolean caseSensitive) {
        this.tree = new TreeMap<K, TreeSet<V>>();
        this.caseSensitive = caseSensitive;
    }
    
    
    /**
     * Method that allow to add a key/value to the collection
     * @param key key that we want to add or update
     * @param value value that we want to add the the existing List of value
     * @return the updated list of value 
     */
    @Override
    public Set<V> add(K key, V value){
        // verification du respect ou non de la case
        key = checkSensitive(key);
        Set<V> listLine;
        if(isEmpty()){
            listLine = new TreeSet<V>();
            listLine.add(value);
            tree.put(key, (TreeSet<V>)listLine);
            return listLine;
        }
        listLine = search(key);
        if( listLine == null){
            listLine = new TreeSet<V>();
        }
        listLine.add(value);
        tree.put(key, (TreeSet<V>)listLine);
        return listLine ;
    }
    
    /**
     * Test if a pair of key/value exist
     * So it's verifying if the key and the value for this key exist.
     * @param key key to search
     * @param value value searched in the list
     * @return true if the key and the value in this key exist
     */
    @Override
    public boolean search(K key, V value){
        if(isEmpty()){
            return false;
        }
        key = checkSensitive(key);
        Set<V> listLine = search(key);
        if(listLine == null){
            return false;
        }
        return listLine.contains(value);
    }
    
    /**
     * Allow to get the list of value associated to a specific key
     * @param key key that we want to get
     * @return list of value if the key exist, null if not
     */
    @Override
    public Set<V> search(K key){
        if(isEmpty()){
            return null;
        }
        key = checkSensitive(key);
        Set<V> listLine = tree.get(key);
        return listLine;
    }
    
    /**
     * Allow to get all the key of the collection.
     * @return List of key
     */
    @Override
    public Set<K> getKeys(){
        return tree.keySet();
    }
    
    /**
     * Remove a pair : key/value
     * @param key key used to search and remove
     * @return  list of value that was associated to the key
     */
    @Override
    public Set<V> remove(K key){
        return tree.remove(key);
    }
    
    /**
     * Removing a specific value associated with a key
     * @param key key used to find the pair key/value
     * @param value value used to search and remove
     * @return the updated list of value or null if the key doesn't exist in the
     * index or if the value is not associated with this key
     */
    @Override
    public Set<V> remove(K key, V value){
        if(isEmpty()){
            return null;
        }
        key = checkSensitive(key);
        Set<V> listLine = search(key);
        if (listLine == null || (!listLine.remove(value) ) ){
            return null;
        }
        tree.put(key, (TreeSet<V>) listLine);
        return listLine;
    }
    
    /**
     *
     * @return the number of key stored in the index
     */
    @Override
    public int nbKeys(){
        return tree.size() ;
    }
    
    /**
     * Test if the index is empty or not
     * @return true if the index is empty
     */
    @Override
    public boolean isEmpty(){
        return ( tree.size() == 0) ;
    }
    
    /**
     * Remove all the key stored in the index
     */
    @Override
    public void clear(){
       tree.clear();
    }

    /**
     * Test if case sensitivity is activated and treat the passed key :
     * if it's disabled the key is passed to lower case
     * @param key
     * @return the final trated key
     */
    public K checkSensitive(K key){
        if( !caseSensitive ){
            return (K) ((String)key).toLowerCase();
        }
        return key;
    }
    
    /**
     * String representation of a pair of key/value in the index
     * @param key searched key
     * @return String representing an entry of the index or null if the key
     * doesn't exist
     */
    public String getStringOf(K key){
        if(isEmpty()){
            return "empty";
        }
        Set<V> listValue = search(key);
        if (listValue == null){
            return null;
        }
        String result = key + " : ";
        Iterator<V> itr = listValue.iterator();
        if(listValue.isEmpty()){
            return (result + "--- no value ---");  
        }
        while(itr.hasNext()){
            result += itr.next() + " ";
        }
        return result;
    }
    
    /**
     * String representation of all the index content.
     * @return String representing the index content.
     */
    @Override
    public String toString() {
        if(isEmpty()){
            return "empty";
        }
        Set<K> listKey = getKeys();
        Iterator<K> itr = listKey.iterator();
        String result = "" ;
        while(itr.hasNext()){
            result += "\n\t" + getStringOf(itr.next());
        }
        return result;
    }
    
}
