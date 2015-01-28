
import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.*;

public class Server implements Serializable {

    public static message mess = null;

    public static void main(String[] args) {
        double draw = (Math.random() * 100) % 2;
        int start = (int) draw; //forcément égal à 0 ou 1. 0 => Client commence, 1 Serveur Commence. A mettre à la connexion d'un client
        System.out.println(start);
        ServerSocket ecoute = null;
        Socket s = null;
        Writer out = null;
        int port = Integer.parseInt(args[0]);
        try {
            ecoute = new ServerSocket(port);
            System.out.println("Lancement du Serveur sur le port : " + port + " !");
            while (true) {
                s = ecoute.accept();
                System.out.println("Connexion avec : " + s.getInetAddress().toString() + " réussi !");
                ObjectInputStream serverInputStream = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream serverOutputStream = new ObjectOutputStream(s.getOutputStream());
                mess = (message) serverInputStream.readObject();
                String tmp = mess.getMessage();

                
                //out = new BufferedWriter((new OutputStreamWriter(s.getOutputStream())));
                // Partie logique à faire côté server
                serverInputStream.close();
                serverOutputStream.close();
                s.close();
            }
        } catch (Exception e) {
            System.out.println("Erreur ahah");
        }
    }
}
