import java.io.*; import java.net.*;
public class SimpleServer {
  public static void main(String args[]){
    String texteOut = new String("hello"), texteln = null;
    ServerSocket ecoute = null;
    Socket s = null;
    Writer out = null; 
    try {
      ecoute = new ServerSocket(12000);
      s = ecoute.accept();
      out = new BufferedWriter((new OutputStreamWriter(s.getOutputStream())));
      out.write("Salut a tous ! \r\n"); 
      out.write("A plus tard ! \r\n"); 
      out.flush(); 
      s.close();
    }catch(Exception e){
      System.out.println("Erreur !!!");
    }
  }
}
