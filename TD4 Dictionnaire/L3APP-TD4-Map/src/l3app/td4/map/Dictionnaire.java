/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package l3app.td4.map;

/**
 * Interface that Map key to value. A key is unique in a map.
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface Dictionnaire<K,V> {
    
    /**
     * Put a key-value in the map.
     * @param key key that we want to insert.
     * @param value value that we want to insert.
     * @return value of the created key or old value of the replaced key.
     */
    V put(K key, V value);
    
    /**
     * Returns the value of the key or null if the key doesn't
     * exist.
     * @param key that we want to get.
     * @return value of the researched key in the map of null if the key doesn't exist.
     */
    V get(K key);
    
    /**
     * Test if the key exist in the current map.
     * @param key that we want to test
     * @return true if the key exist in the map
     */
    boolean exist(K key);
    
    /**
     * Remove a key from this map if it exist.
     * Return the value of the removed key or null if the key
     * doesn't exist.
     * @param key that we want to remove.
     * @return value of the deleted key or null if the key doesn't exist.
     */
    V remove(K key);
    
    /**
     * Return true if this map contains no key-value in this map.
     * @return true if this map contains no key-value in this map.
     */
    boolean isEmpty();
    
    /**
     * Returns the number of key-value in this map.
     * @return the number of key-value in this map.
     */
    int size();
    
    /**
     * Remove all of the key and value from this map.
     */
    void clear();
    
    /**
     * Retrieve all the key and value from the map into an Array.
     * @return an array with all the key and value.
     */
    K[] getAll();
    
    /**
     * Test if the map need to be reorganised in case we use a structure that
     * slowdown the traitement when it's not well organised.
     * For example : Binary tree ABR.
     * @return true if the structure need to be organised.
     */
    boolean needReorganisation();
    
    /**
     * Reorganise the structure and balance data to increase the cost of time
     * for put and get operation.
     */
    void reorganize();
    
}
