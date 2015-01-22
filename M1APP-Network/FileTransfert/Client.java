import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class Client {
    private DatagramSocket aSocket = null;
    private FileEvent event = null;
 
    public Client() {
 
    }
 
    public static void main(String[] args) {
        Client client = new Client();
        client.run(args[0],args[1]);
    }

    public void run(String adress, String filename){
        try {
                aSocket = new DatagramSocket();
                InetAddress aHost = InetAddress.getByName(adress);
                int serverPort = 6464;

                event = new FileEvent(filename);
                FileInputStream inputStream = new FileInputStream(event.getFilename());

                byte[] sentdata = new byte[5000];
                int nRead = 0;
                int count = 0;
                // While we don't receive the ACK
                while ((nRead = inputStream.read(sentdata)) != -1) {
                    aSocket.send(new DatagramPacket(sentdata, sentdata.length, aHost, serverPort));
                    if (nRead == 0) {
                        sentdata = "END".getBytes();
                        aSocket.send(new DatagramPacket(sentdata, sentdata.length, aHost, serverPort));
                        inputStream.close();
                    }
                    DatagramPacket reply = new DatagramPacket(sentdata,sentdata.length);
                    aSocket.receive(reply); 
                    count++;
                    System.out.println("Server received packet number : \n" + count);
                }

        }
        catch (SocketException e){
               System.out.println("Socket: "+e.getMessage());
        }
        catch (IOException e) {
               System.out.println("IO: " + e.getMessage());
        }
        finally {
                if(aSocket != null) aSocket.close();
        }
    }
}
