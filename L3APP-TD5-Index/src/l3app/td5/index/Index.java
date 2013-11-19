package l3app.td5.index;

import java.util.Set;

/**
 * Interface of an index that offer the possibilitie to
 * store informations about a key in an ordered Collection.
 * 
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface Index<K extends Comparable<K>, V extends Comparable<V>> {
    
    /**
     * Method that allow to add a key/value to the collection
     * @param key key that we want to add or update
     * @param value value that we want to add the the existing Set of value
     * @return the updated set of value 
     */
    Set<V> add(K key, V value);
    
    /**
     * Test if a pair of key/value exist
     * So it's verifying if the key and the value for this key exist.
     * @param key key to search
     * @param value value searched in the set
     * @return true if the key and the value in this key exist
     */
    boolean search(K key, V value);
    
    /**
     * Allow to get the set of value associated to a specific key
     * @param key key that we want to get
     * @return set of value if the key exist, null if not
     */
    Set<V> search(K key);
    
    /**
     * Allow to get all the key of the collection.
     * @return List of key
     */
    Set<K> getKeys();
    
    /**
     * Remove a pair : key/value
     * @param key key used to search and remove
     * @return  set of value that was associated to the key
     */
    Set<V> remove(K key);
    
    /**
     * Removing a specific value associated with a key
     * @param key key used to find the pair key/value
     * @param value value used to search and remove
     * @return the updated set of value or null if the key doesn't exist in the
     * index
     */
    Set<V> remove(K key, V value);
    
    /**
     *
     * @return the number of key stored in the index
     */
    int nbKeys();
    
    /**
     * Test if the index is empty or not
     * @return true if the index is empty
     */
    boolean isEmpty();
    
    /**
     * Remove all the key stored in the index
     */
    void clear();
        
}
