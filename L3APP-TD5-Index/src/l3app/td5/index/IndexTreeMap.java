/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package l3app.td5.index;

import java.util.Collection;
import java.util.Iterator;
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
    
    private SortedMap<K, TreeSet<V>> tree;
    
    IndexTreeMap() {
        this.tree = new TreeMap<K, TreeSet<V>>();
    }
    
    @Override
    public Set<V> add(K key, V value){
        Set<V> listLine;
        if(isEmpty()){
            listLine = new TreeSet<V>();
            listLine.add(value);
            tree.put(key, (TreeSet<V>)listLine);
            return listLine;
        }
        listLine = search(key);
        if(listLine == null){
            listLine = new TreeSet<V>();
            listLine.add(value);
            tree.put(key, (TreeSet<V>)listLine);
            return listLine;
        }
        listLine.add(value);
        tree.put(key, (TreeSet<V>)listLine);
//      listLine.remove(value);
        return listLine ;
    }
    
    @Override
    public boolean search(K key, V value){
       Set<V> listLine = new TreeSet<V>(search(key));
       return listLine.contains(value);
    }
    
    @Override
    public Set<V> search(K key){
        return tree.get(key);
    }
    
    @Override
    public Set<K> getKeys(){
        return tree.keySet();
    }
    
    @Override
    public Set<V> remove(K key){
        return tree.remove(key);
    }
    
    @Override
    public Set<V> remove(K key, V value){
       Set<V> listLine = new TreeSet<V>(search(key));
       listLine.remove(value);
       tree.put(key, (TreeSet<V>) listLine);
     // listLine.add(value);
       return listLine;
    }
    
    @Override
    public int nbKeys(){
        return tree.size() ;
    }
    
    @Override
    public boolean isEmpty(){
        return ( tree.size() == 0) ;
    }
    
    @Override
    public void clear(){
       tree.clear();
    }

    @Override
    public String toString() {
        String result = new String();
        Collection entrySet = this.tree.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            result += "\t" + it.next() + "\n";
        }
        return result;
    }
    
}
