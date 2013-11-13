package l3app.td5.index;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramy Al Aloocy <ramy.aloocy@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class InfoWord {
    
    private String word;
    private int numLine;
    private int numCol;

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
    
}
