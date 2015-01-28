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
  private static Socket socket;
  
  // info for server
  private String username;
  private int port;
  InetAddress server;
  
  /**
   *  Constructor call when used from a GUI
   *  in console mode the ClienGUI parameter is null
   */
  Client(InetAddress server, int port, String username) {
      this.server = server;
      this.port = port;
      this.username = username;
  }

  /**
   * Usage : Username ServerAdress Port
   * @param args
   */
  public static void main(String[] args) {
    // default values
    int portNumber = 12000;
    String serverAddress = "localhost";
    String userName = "Anonymous";
  
    // args
    if(args.length == 3){
      userName = args[0];
      serverAddress = args[1];
      portNumber = Integer.parseInt(args[2]);
    }

    // Create socket
    Socket s = null;
    try {
      s = new Socket(serverAddress,portNumber);
    }
    catch(Exception ec) {
      display("Error connectiong to server:" + ec);
    }

    String msg = new String("Connection accepted " 
            + s.getInetAddress().toString()
            + ":" + s.getPort());
    display(msg);

  }
  
  /**   
   * To send a message to the console
   */
  private static void display(String msg) {   
      System.out.println(msg);      // println in console mode
  }
  
  /**
    * To send a message to the server
    */
  void sendMessage(ChatMessage msg) {
    try {
      sOutput.writeObject(msg);
    }
    catch(IOException e) {
      display("Exception writing to server: " + e);
    }
  }

  /*
   * a class that waits for the message from the server and append them to the JTextArea
   * if we have a GUI or simply System.out.println() it in console mode
   */
  class ListenFromServer extends Thread {

    public void run() {
      while(true) {
        try {
          String msg = (String) sInput.readObject();
          // if console mode print the message and add back the prompt
          if(cg == null) {
            System.out.println(msg);
            System.out.print("> ");
          }
          else {
            cg.append(msg);
          }
        }
        catch(IOException e) {
          display("Server has close the connection: " + e);
          if(cg != null) 
            cg.connectionFailed();
          break;
        }
        // can't happen with a String object but need the catch anyhow
        catch(ClassNotFoundException e2) {
        }
      }
    }
  }

}
