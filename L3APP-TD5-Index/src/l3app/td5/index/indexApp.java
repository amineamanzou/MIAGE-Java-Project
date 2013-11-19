package l3app.td5.index;

import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class indexApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Index idx;
        idx = new IndexTreeMap<String, Integer>();
        String text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit,"
                + " sed do eiusmod tempor incididunt ut labore et dolore magna "
                + "aliqua.\n Ut enim ad minim veniam, quis nostrud exercitation "
                + "ullamco laboris nisi ut aliquip ex ea commodo consequat.\n "
                + "    Duis aute irure dolor in reprehenderit in voluptate velit "
                + "esse cillum dolore eu fugiat nulla pariatur.     Excepteur sint"
                + " occaecat cupidatat non proident, sunt in culpa qui officia "
                + "deserunt mollit anim id est laborum.\n";
        
        System.out.println("Lexing this string from a String and from a File :");
        System.out.println(text);
        
        System.out.println("––––––––––––––––––––––From a String–––––––––––––––––––––––––"
                + "|–––––––––––––––––––––––From a File––––––––––––––––––––––––––");
        Lexer lexStr = new LexerFromString(text," \t,;.");
        Iterator iStr = lexStr.iterator();
        Lexer lexFp = new LexerFromFile("src/l3app/td5/index/lorem.txt"," \t,;.");
        Iterator iFp = lexFp.iterator();
        
        InfoWord word;
        
        while(iStr.hasNext() || iFp.hasNext()) {
            word = (InfoWord) iStr.next();
            System.out.println("\t - " + word + "\t\t - " + iFp.next());
            if(word != null){
                idx.add(word.getWord(), new Integer(word.getNumLine()));
            }
        }
        System.out.println("\n\tTesting an other nextWord :");
        System.out.println("\t - " + lexStr.nextWord());
        System.out.println("\t - " + lexFp.nextWord());
        
        System.out.println("–––––––––––––––––––––– Indexation –––––––––––––––––––––––––");
        System.out.println(idx);

    }
}
