/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package l3app.td5.index;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class IndexTreeMap<K extends Comparable<K>, V extends Comparable<V>> implements Index<K, V> {
    
    private SortedMap content;
    
    IndexTreeMap() {
        this.content = new TreeMap<K, TreeSet<V>>();
    }
    
    @Override
    public Set<V> add(K key, V value){
        this.content.put(key,value);
        return (Set<V>) this.content.get(key);
    }
    
    @Override
    public boolean search(K key, V value){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Set<V> search(K key){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Set<K> getKeys(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Set<V> remove(K key){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Set<V> remove(K key, V value){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public int nbKeys(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isEmpty(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean clear(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "IndexTreeMap{" + "content=" + content + '}';
    }

}
