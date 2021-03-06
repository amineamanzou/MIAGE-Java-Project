package l3app.td4.map;

import java.util.Scanner;

/**
 * Main testing class.
 * @author Amine Amanzou <amineamanzou@gmail.com>
 * @author Eva Blot <eva.blot.eb@gmail.com>
 */
public class mapApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ABR<Integer,String> dico = new ABR<Integer,String>();
        System.out.println("Construction d'un arbre vide.");
        
        System.out.println("Put 50");
        dico.put(new Integer(50), "info de 50");
        System.out.println(dico);
        
        System.out.println("Put 69");
        dico.put(new Integer(69), "info de 69");
        System.out.println(dico);
        
        System.out.println("Put 45");
        dico.put(new Integer(45), "info de 45");
        System.out.println(dico);
        
        System.out.println("Put 49");
        dico.put(new Integer(49), "info de 49");
        System.out.println(dico);
        
        System.out.println("Put 70");
        dico.put(new Integer(70), "info de 70");
        System.out.println(dico);
        
        System.out.println("Put 44");
        dico.put(new Integer(44), "info de 44");
        System.out.println(dico);
        
        System.out.println("Get the value of key 44.");
        System.out.println(dico.get(new Integer(44)) + '\n');
        
        System.out.println("Testing the method exist : ");
        System.out.println("49 exist ? " + dico.exist(new Integer(49)));
        System.out.println("80 exist ? " + dico.exist(new Integer(80)) + '\n');
        
        System.out.println("Testing the method size : " + dico.size() + '\n');
        
        System.out.println("Testing the method height : " + dico.height());
        System.out.println("Put 100");
        dico.put(new Integer(100), "info de 100");
        System.out.println(dico);
        System.out.println("Height : " + dico.height() + '\n');
        
        // Not working yet. Work in progress
        System.out.println("At this moment the tree is balanced.");
        System.out.println("Testing isBalanced method : " + dico.isBalanced());
        System.out.println("Put 101");
        dico.put(new Integer(101), "info de 101");
        System.out.println(dico);
        System.out.println("Testing isBalanced method : " + dico.isBalanced() + '\n');
        
        System.out.println("Testing the method remove : ");
        System.out.println("Remove 101 at the end of the tree. And 100.");
        System.out.println(dico.remove(new Integer(101)));
        System.out.println(dico.remove(new Integer(100)));
        System.out.println(dico);
        System.out.println("Remove 69 to test if there is no fg the fd goes up.");
        System.out.println('\t' + dico.remove(new Integer(69)));
        System.out.println(dico);
        System.out.println("Putting 69 to test the case where there is no fd and the fg goes up.");
        dico.put(new Integer(69),"info de 69");
        System.out.println(dico);
        System.out.println("Remove 70 :");
        System.out.println('\t' + dico.remove(new Integer(70)));
        System.out.println(dico);
        System.out.println("Remove 45 to test the case where the both of fg and fd exist.");
        System.out.println('\t' + dico.remove(new Integer(45)));
        System.out.println(dico);
        
    }
}
