package l3app.td5.index;

/**
 * This class store informations about a given word : his position in a text.
 * This class could be more improved and user with a generic type intead of 
 * a String representation of a word. So it could be used with object and Integer...
 * 
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class InfoWord {
    
    private String word;
    private int numLine;
    private int numCol;

    /**
     * Constructor that initialise the object with all the information.
     * @param word
     * @param numLine
     * @param numCol 
     */
    public InfoWord(String word, int numLine, int numCol) {
        this.word = word;
        this.numLine = numLine;
        this.numCol = numCol;
    }
    
    /**
     * Getter and Setter if the word is moved in the text
     */
    
    public String getWord() {
        return word;
    }

    public int getNumLine() {
        return numLine;
    }

    public int getNumCol() {
        return numCol;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setNumLine(int numLine) {
        this.numLine = numLine;
    }

    public void setNumCol(int numCol) {
        this.numCol = numCol;
    }

    /**
     * ToString used for debuging
     * @return 
     */
    @Override
    public String toString() {
        return "InfoWord{" + "word=" + word + ", numLine=" + numLine + ", numCol=" + numCol + '}';
    }
    
}
