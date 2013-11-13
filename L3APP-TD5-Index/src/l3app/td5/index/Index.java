package l3app.td5.index;

import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public interface Index<K extends Comparable<K>, V extends Comparable<K>> {
    
    Set<V> add(K key, V value);
    
    boolean search(K key, V value);
    
    Set<V> search(K key);
    
    Set<K> getKeys();
    
    Set<V> remove(K key);
    
    Set<V> remove(K key, V value);
    
    int nbKeys();
    
    boolean isEmpty();
    
    boolean clear();
    
}
