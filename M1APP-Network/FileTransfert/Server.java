import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.*;
import java.util.Date;
 
public class Server {
    private DatagramSocket aSocket = null;
    private FileEvent fileEvent = null;
    private DateFormat dateFormat = null;
 
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public Server() {
 
    }
 
    public void run(){
        fileEvent = new FileEvent("Image.png");
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        try{
            aSocket = new DatagramSocket(6464);
            byte[] buffer = new byte[5000];
            
            FileOutputStream fileWriter = null;
            File file;
            file = new File(fileEvent.getDestinationDirectory());
            fileWriter = new FileOutputStream(file);
            
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                System.out.println("Connecting Client");
                fileWriter.write(request.getData());
                DatagramPacket reply = new DatagramPacket(request.getData(),
                                                          request.getLength(),
                                                          request.getAddress(),
                                                          request.getPort());
                aSocket.send(reply);
                Date now = new Date();
                System.out.println("["+ dateFormat.format(now) +"]");
                System.out.println("From: " + request.getAddress().toString());
            }
        }
        catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage()); 
        }
        catch (IOException e) {
            System.out.println("IO: " + e.getMessage()); 
        }
        finally {
            if(aSocket != null) aSocket.close();
        }
        
    }

}
