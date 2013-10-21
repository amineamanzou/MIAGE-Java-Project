
package interfaceApp;

import java.util.Iterator;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class interfaceApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         /** A faire :
         *      - Parcours dans le meme sens pour l'iterateur
         *      - Implem remove
         *      - Factoriser le code tabdynamique herite de tabstatic
         *      - return (E[]) Array.newInstance(Object.class, taille);
         *      - Arrays.fill(pile, 0, sommet, null); pour vider et size = 0;
         *      - Pas de copy dans iterator
         *      - Arrays.copyOf(pile, pile.length + increment);
         *      - Ajouter precedent dans iterator de ListeChainee
         * 
         */
        System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("Creation d'une pile statique de String de taille 10 : ");
        Pile<String> tabtest = new TabStatiquePile<String>(10);
        System.out.println(tabtest.peek());
        System.out.println("On empile : A puis B.");
        tabtest.push("A");
        tabtest.push("B");
        System.out.println("On affiche grace a Iterator le contenu.");
        Iterator i = tabtest.iterator();
        while(i.hasNext()) {
            System.out.println("\t - " + i.next());
        }
        System.out.println("On depile le dernier element.");
        tabtest.pop();
        System.out.println("Test de la methode peek renvoyant le dernier element present dans la pile :");
        System.out.println(tabtest.peek());
        System.out.println("Test de la methode empty : " + tabtest.empty());
        System.out.println("On vide la pile.");
        tabtest.clear();
        System.out.println("Test de la methode empty : " + tabtest.empty());
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        
        
        
        
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("Creation d'une pile de type Liste chainee de Int : ");
        Pile<Integer> listtest = new ListeChaineePile<Integer>();
        System.out.println(listtest.peek());
        System.out.println("On empile : 230, 560, 430 et 230.");
        listtest.push(230);
        listtest.push(560);
        listtest.push(430);
        listtest.push(230);
        System.out.println("On affiche grace a Iterator le contenu :");
        i = listtest.iterator();
        while(i.hasNext()) {
            System.out.println("\t - " + i.next());
        }
        System.out.println("On depile le dernier element.");
        listtest.pop();
        System.out.println("Test de la methode peek renvoyant le dernier element present dans la pile :");
        System.out.println(listtest.peek());
        System.out.println("Test de la methode empty : " + listtest.empty());
        System.out.println("On vide la pile.");
        listtest.clear();
        System.out.println("Test de la methode empty : " + listtest.empty());
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        
        
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("Creation d'une pile dynamique de String de taille 5 : ");
        Pile<String> dynamiqueTest = new TabDynamiquePile<String>(5);
        System.out.println(dynamiqueTest.peek());
        System.out.println("On empile : A, B, C, D et E.");
        dynamiqueTest.push("A");
        dynamiqueTest.push("B");
        dynamiqueTest.push("C");
        dynamiqueTest.push("D");
        dynamiqueTest.push("E");
        System.out.println("Le tableau est remplis nous testons Iterator.");
        i = dynamiqueTest.iterator();
        while(i.hasNext()) {
            System.out.println("\t - " + i.next());
        }
        System.out.println("On empile F et G un nouveau tableau est realoue.");
        dynamiqueTest.push("F");
        dynamiqueTest.push("G");
        i = dynamiqueTest.iterator();
        while(i.hasNext()) {
            System.out.println("\t - " + i.next());
        }
        System.out.println("On depile le dernier element.");
        dynamiqueTest.pop();
        System.out.println("Test de la methode peek renvoyant le dernier element present dans la pile :");
        System.out.println(dynamiqueTest.peek());
        System.out.println("Test de la methode empty : " + dynamiqueTest.empty());
        System.out.println("On vide la pile.");
        dynamiqueTest.clear();
        System.out.println("Test de la methode empty : " + dynamiqueTest.empty());
        System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        

    }
}
