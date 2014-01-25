package util;
import java.io.IOException;
import java.util.Scanner;

/**
 * Console Reader for reading operation
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class ConsoleReader {

    public int readInt(){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try{
            i = sc.nextInt();
        }catch(Exception e){
            //Si une exception est levée car la valeur entrée n'est pas un int,
            //on relance une lecture clavier
            i = readInt();
        }
        return i;
    }

    public String readString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public void read(boolean clean){
        char c;
        try
        {
            c = (char)System.in.read();
            if(clean){
                for (int i = 0; i < 50; ++i) System.out.println();
            }
        }
        catch(IOException ioe)
        {
            read();
        }
    }
    
    public void read(){
        char c;
        try
        {
            c = (char)System.in.read();
        }
        catch(IOException ioe)
        {
            read();
        }
    }
}
