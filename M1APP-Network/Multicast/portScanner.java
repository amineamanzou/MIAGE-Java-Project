import java.io.IOException; 
import java.net.*;

public class PortScanner {
  public static void main(String[] args) { 
    try {
      InetAddress remote = null;
      InetSocketAddress soRemote = null;
      remote = InetAddress.getByName("www.univ-reims.fr");
      for (int port = 80; port <= 110; port++) {
        soRemote = new InetSocketAddress(remote,port);
        System.out.printIn("Test sur le port "+port);
        Socket s = new SocketO; 
        try {
          s.connect(soRemote,500);
          System.out.println(remote.getHostName() +
            " est a l'ecoute sur le port "+ port); 
          s.close();
        } catch (IOException ex) {
          System.out.println("une erreur s'est produite (port pas à l'écoute)");
        }
    }
    catch (UnknownHostException ex) {
      System.out.println("Le nom de hote indique n'existe pas");
    }
  }
}
