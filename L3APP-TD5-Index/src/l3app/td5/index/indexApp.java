package l3app.td5.index;

import java.util.Iterator;

/**
 * Main of the application where the different class are tested.
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class indexApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Index idx, idxTwo;
        idx = new IndexTreeMap<String, Integer>();
        idxTwo = new IndexTreeMap<String, Integer>();
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
        Lexer lexStr = new LexerFromString(text, " \t,;.");
        Iterator iStr = lexStr.iterator();
        Lexer lexFp = new LexerFromFile("src/l3app/td5/index/lorem.txt", " \t,;.");
        Iterator iFp = lexFp.iterator();

        InfoWord word;

        while (iStr.hasNext() || iFp.hasNext()) {
            word = (InfoWord) iStr.next();
            System.out.println("\t - " + word + "\t\t - " + iFp.next());
            if (word != null) {
                idx.add(word.getWord(), new Integer(word.getNumLine()));
            }
        }
        System.out.println("\n\tTesting an other nextWord :");
        System.out.println("\t - " + lexStr.nextWord());
        System.out.println("\t - " + lexFp.nextWord());

        System.out.println("–––––––––––––––––––– Indexation in idx –––––––––––––––––––––––");
        System.out.println(idx);


        System.out.println("–––––––––––––––––––––– Test search –––––––––––––––––––––––––");
        System.out.println("Search in idxTwo (empty) : " + idxTwo.search("Duis"));
        System.out.println("Search in idx :");
        System.out.println("\t Search QEUYHRTKSDTK : " + idx.search("QEUYHRTKSDTK"));
        System.out.println("\t Search QEUYHRTKSDTK : " + idx.search("Duis"));
        System.out.println("\t Search if Duis is in line 3 : " + idx.search("Duis", new Integer(3)));
        System.out.println("\t Search if Duis is in line 1 : " + idx.search("Duis", new Integer(1)));
        System.out.println("\t Search if QEUYHRTKSDTK is in line 1 : " + idx.search("QEUYHRTKSDTK", new Integer(1)));
        System.out.println("\t Search if QEUYHRTKSDTK is in line 3 : " + idx.search("QEUYHRTKSDTK", new Integer(3)));
        System.out.println("\t Search if Duis is in line 1 : " + idx.search("Duis", new Integer(1)));


        System.out.println("–––––––––––––––––––––– Test getKeys –––––––––––––––––––––––––");
        System.out.println("idx : " + idx.getKeys());
        System.out.println("idxTwo : " + idxTwo.getKeys());


        System.out.println("–––––––––––––––––––––– Test remove –––––––––––––––––––––––––");
        System.out.println("Removing ut in line 1 two times : ");
        System.out.println(idx.remove("ut", new Integer(1)));
        System.out.println(idx.remove("ut", new Integer(1)));
        System.out.println("Removing ut, voluptate, velit and ullamco :");
        idx.remove("ut");
        idx.remove("voluptate");
        idx.remove("velit");
        idx.remove("ullamco");
        System.out.println("Index idx : ");
        System.out.println(idx);
        System.out.println("Some other remove case : ");
        System.out.println(idx.remove("QEUYHRTKSDTK"));
        System.out.println(idx.remove("Duis"));
        System.out.println(((IndexTreeMap) idx).getStringOf("Duis"));
        System.out.println(idx.remove("Duis"));
        System.out.println("Removing Duis in an empty index idxTwo : ");
        System.out.println(idxTwo.remove("Duis"));

        System.out.println("Removing dolore from line : 1, 1, 3, 50");
        System.out.println(idx.remove("dolore", new Integer(1)));
        System.out.println(idx.remove("dolore", new Integer(1)));
        System.out.println(idx.remove("dolore", new Integer(3)));
        System.out.println(idx.remove("dolore", new Integer(50)));

        System.out.println("–––––––––––––––––––––– Test nbKeys –––––––––––––––––––––––––");
        System.out.println(idx.nbKeys());
        System.out.println(idxTwo.nbKeys());

        System.out.println("––––––––––––––––––––– Test getStringOf ––––––––––––––––––––––");
        System.out.println(((IndexTreeMap) idx).getStringOf("veniam"));
        System.out.println(((IndexTreeMap) idx).getStringOf("tempor"));
        System.out.println(((IndexTreeMap) idx).getStringOf("dolore"));
        System.out.println(((IndexTreeMap) idx).getStringOf("dolqerhqerhqehe"));
        System.out.println(((IndexTreeMap) idxTwo).getStringOf("dolore"));
        
        System.out.println("–––––––––––––––––––––– Test toString –––––––––––––––––––––––––");
        System.out.println(idx);
        System.out.println(idxTwo);
        
        System.out.println("–––––––––––––––––––––– Test clear –––––––––––––––––––––––––");
        idx.clear();
        System.out.println(idx);
        
        System.out.println("–––––––––––––––––––––– End test index –––––––––––––––––––––––––");
    }
}
