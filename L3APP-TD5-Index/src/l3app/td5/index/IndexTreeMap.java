package l3app.td5.index;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @param <K> les cles utilisé pour stocker les données, dans notre cas ce sont 
 * les chaines de caractere que nous indexons
 * @param <V> les valeurs associées aux cles, dans notre cas ce sont les lignes 
 * ou apparais la chaine de caractere associe c'est ce qui nous permet d'indexer
 * la chaine de caractère cette classe est l'implementation d'un index qui offre
 * a son utilisateur la possibilite d'indexer un texte entier et de trier les 
 * cles de façon constructive afin d'accelerer les recherches.
 */
public class IndexTreeMap<K extends Comparable<K>, V extends Comparable<V>> implements Index<K, V> {
    
    // l'arbre qui permet de trier les cles ainsi que les valeurs associes.
    // dans notre cas on associe a une cle une liste contenant les valeurs V 
    private SortedMap<K, TreeSet<V>> tree;
    // permet a l'utilisateur de decider s'il veut respecter la case ou pas
    private boolean caseSensitive ;
    
    /**
     * constructeur par defaut : on initialise l'arbre contenant les cles et valeurs 
     * ainsi que la varible caseSensitive
     */
    IndexTreeMap() {
        this.tree = new TreeMap<K, TreeSet<V>>();
        caseSensitive = true;
    }
    
    /**
     * 
     * @param caseSensitive choix de l'utilisateur : respecter la case ou non
     * on initialise l'arbre comme le constructeur par defaut et variable caseSensitive avec le parametre.
     */
    IndexTreeMap(boolean caseSensitive) {
        this.tree = new TreeMap<K, TreeSet<V>>();
        this.caseSensitive = caseSensitive;
    }
    
    
    /**
     * cette méthode permet de completer l'arbre de façon construite et garder les cles trier
     * @param key la cle que l'on veut ajouter a l'arbre ou modifier la valeur associe a cette cle
     * @param value la valeur que l'on ajoute a la cle associe
     * @return la nouvelle liste de valeur associe a la cle 
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
     * cette méthode permet de savoir si une valeur existe pour une cle donne,
     * donc de verifier a la fois si cette cle existe et si la valeur existe
     * @param key la cle utilise pour la recherche 
     * @param value la valeur rechercher
     * @return true si la valeur  et la cle existe
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
     * permet d'obtenir la liste contenant l'ensemble des valeurs associe a la cle donnee en parametre
     * @param key la cle utilisee pour la recherche
     * @return le liste des valeurs, null si la cle utilise n'existe pas dans l'arbre
     */
    @Override
    public Set<V> search(K key){
        key = checkSensitive(key);
        Set<V> listLine = tree.get(key);
        return listLine;
    }
    
    /**
     * permet d'obtenir l'ensemble des cles stockees dans l'arbre
     * @return la liste des cles
     */
    @Override
    public Set<K> getKeys(){
        return tree.keySet();
    }
    
    /**
     * permet de retirer un enregistrement : cle\valeur
     * @param key la cle utiliser pour trouver l'enregistrement a suprimmer
     * @return la liste des valeurs associe a la cle, retourne null si la cle n'existe pas l'arbre;
     */
    @Override
    public Set<V> remove(K key){
        return tree.remove(key);
    }
    
    /**
     * retire une valeur precise associe a une cle donner
     * @param key cle utilise pour la recherche de l'enregistrement
     * @param value la valeur a supprimer de la liste associee a la cle donnee
     * @return la nouvelle liste de valeur associee a la cle donnee, 
     * retourne null si la cle utilise n'existe pas dans l'arbre
     */
    @Override
    public Set<V> remove(K key, V value){
        key = checkSensitive(key);
        Set<V> listLine = search(key);
        if (listLine == null)
            return null;
        listLine.remove(value);
        tree.put(key, (TreeSet<V>) listLine);
        return listLine;
    }
    
    /**
     *
     * @return le nombre de cle enregistrer dans l'arbre
     */
    @Override
    public int nbKeys(){
        return tree.size() ;
    }
    
    /**
     * 
     * @return permet de savoir si l'arbre de donnee est vide
     */
    @Override
    public boolean isEmpty(){
        return ( tree.size() == 0) ;
    }
    
    /**
     * permet de vider l'arbre de donnee
     */
    @Override
    public void clear(){
       tree.clear();
    }

    /**
     * permet de verifier si l'on respecte la case ou pas, et dans le cas ou on ne la respecte pas
     * on renvoi la chaine de caractere en parametre en minuscule.
     * @param key
     * @return la chaine de caractere final : respectant la case ou non
     */
    public K checkSensitive(K key){
        if( !caseSensitive ){
            return (K) ((String)key).toLowerCase();
        }
        return key;
    }
    
    /**
     * permet de choisir si on respecte la case ou non
     * @param caseSensitive 
     */
    public void setCaseSensitive(boolean caseSensitive){
        this.caseSensitive = caseSensitive ;
    }
    
    /**
     * permet d'avoir la representation d'une partie de l'arbre : obtenue grace a la cle en parametre
     * @param key cle utilise pour la recherche
     * @return return la chaine de caractere representant la partie de l'arbre,
     * return null si la cle n'existe pas dans l'arbre
     */
    public String getStringOf(K key){
        Set<V> listValue = search(key);
        if (listValue == null){
            return null;
        }
        String result = key + " : ";
        Iterator<V> itr = listValue.iterator();
        while(itr.hasNext()){
            result += itr.next() + " ";
        }
        return result;
    }
    
    /**
    * permet de representer l'arbre de donne via une chaine de caractere
    * @return la chaine de caractere representant l'arbre de donnee
    */
    @Override
    public String toString() {
        Set<K> listKey = getKeys();
        Iterator<K> itr = listKey.iterator();
        String result = "" ;
        while(itr.hasNext()){
            result += "\n\t" + getStringOf(itr.next());
        }
        return result;
    }
    
}
