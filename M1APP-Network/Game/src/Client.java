import java.io.*; 
import java.net.*;

/**
 *
 * @author pierregaillard
 */
public class Client {
    
  // for I/O
  private ObjectInputStream sInput;       // to read from the socket
  private ObjectOutputStream sOutput;     // to write on the socket
  private Socket socket;
  
  // info for server
  private String username;
  private int port;
  InetAddress server;
  
  /**
   *  Constructor call when used from a GUI
   *  in console mode the ClienGUI parameter is null
   */
  Client(String server, int port, String username) {
      this.server = server;
      this.port = port;
      this.username = username;
  }

  /**
   * Usage : Username ServerAdress Port
   */
  public static void main(String[] args) {
    // default values
    int portNumber = 12000;
    String serverAddress = "localhost";
    String userName = "Anonymous";
  
    // args
    if(args.length < 3){
      userName = args[1]
      serverAddress = args[2];
      portNumber = Integer.parseInt(args[3]);
    }

    // Create socket
    Socket s = null;
    try {
      s = new Socket(serverAddress,portNumber);
    }
    catch(Exception ec) {
      display("Error connectiong to server:" + ec);
      return false;
    }

    String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
    display(msg);

  }
  
  /**   
   * To send a message to the console
   */
  private void display(String msg) {   
      System.out.println(msg);      // println in console mode
  }

}
