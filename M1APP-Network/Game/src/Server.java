<<<<<<< HEAD
=======

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

>>>>>>> FETCH_HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD

=======
>>>>>>> FETCH_HEAD
/**
 *
 * @author pierregaillard
 */
public class Server {
<<<<<<< HEAD
    
=======

    public static void main(String[] args) {
        ServerSocket ecoute = null;
        Socket s = null;
        Writer out = null;
        try {
            ecoute = new ServerSocket(12000);
            s = ecoute.accept();
            out = new BufferedWriter((new OutputStreamWriter(s.getOutputStream())));
            
            // Partie logique à faire côté server
            /* out.write("Salut à tous \r\n");
            out.write("A plus tard ! \r\n");
            out.flush(); */
            
            s.close();
        } catch (Exception e) {
            System.out.println("Erreur ahah");
        }
    }
>>>>>>> FETCH_HEAD
}
