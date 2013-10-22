/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package l3app.td4.map;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
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

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        if(this.racine == null){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.racine = null;
        this.size = 0;
    }

    @Override
    public K[] getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean needReorganisation(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
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
                heightD = heightHelper(arbre.racine.fg,degres+1);
            }
            else {
                heightD = degres;
            }
            if(arbre.racine.fd != null){
                heightG = heightHelper(arbre.racine.fd,degres+1);
            }
            else {
                heightG = degres;
            }
            return Math.max(heightD, heightG);
        }
    }
    
    public boolean isBalanced(){
        return isBalancedHelper(this);
    }
    
    private boolean isBalancedHelper(ABR<K,V> arbre){
        //Not working yet Work in progress
        if(arbre.racine.fd == null && arbre.racine.fg != null) {
            return arbre.racine.fg.height() >= 1;
        }
        else if(arbre.racine.fd != null && arbre.racine.fg == null) {
            return arbre.racine.fd.height() >= 1;
        }
        if( arbre.racine.fd.height() == arbre.racine.fg.height()
                || arbre.racine.fd.height() == arbre.racine.fg.height()+1 
                || arbre.racine.fd.height()+1 == arbre.racine.fg.height() ) {
            return arbre.racine.fd.isBalanced() && arbre.racine.fg.isBalanced();
        }
        else {
            return false;
        }
    }
    @Override
    public void reorganize(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
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
    }
}
