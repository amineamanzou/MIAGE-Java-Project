package util;

/**
 * Console writer for writing operation
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class ConsoleWriter {

    private boolean debugEnabled;

    public ConsoleWriter(){
        this.debugEnabled = false;
    };

    public ConsoleWriter(boolean debugEnabled){
        this.debugEnabled = debugEnabled;
    };

    /**
     * Méthode d'affichage classique avec saut de ligne
     * @param msg 
     */
    public void println(String msg){
        System.out.println(msg);
    };
    
    /**
     * Méthode d'affichage classique sans saut de ligne
     * @param msg 
     */
    public void print(String msg){
        System.out.print(msg);
    };

    /**
     * Méthode pour logger
     * @param msg 
     **/
    public void log(String msg){
        if(isDebugEnabled())
            System.out.println("#LOG : "+msg+"#");
    }

    /**
     * @return the debugEnabled
     */
    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    /**
     * @param debugEnabled the debugEnabled to set
     */
    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }
}
