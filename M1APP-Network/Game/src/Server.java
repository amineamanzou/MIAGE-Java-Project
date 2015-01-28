
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierregaillard
 */
public class Server {
    public static void main(String[] args) {
        double draw = (Math.random()*100) % 2;
        int start = (int) draw; //forcément égal à 0 ou 1. 0 => Client commence, 1 Serveur Commence. 
        System.out.println(start);
        ServerSocket ecoute = null;
        Socket s = null;
        Writer out = null;
        int port = Integer.parseInt(args[0]);
        int nb = 0;
        try {
            ecoute = new ServerSocket(port);
            System.out.println("Lancement du Serveur sur le port : "+port+" !");
            while (true) {
                s = ecoute.accept();
                System.out.println("Connexion avec : "+ecoute.getInetAddress()+" réussi !");
                out = new BufferedWriter((new OutputStreamWriter(s.getOutputStream())));
                // Partie logique à faire côté server
                
                s.close();
            }
        } catch (Exception e) {
            System.out.println("Erreur ahah");
        }
    }
}
