import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaces {
  public static void main (String args[]) {
    try {
      NetworkInterface inter;   
      for (Enumeration<NetworkInterface>
        e=NetworkInterface.getNetworkInterfaces(); e.hasMoreElements();) {
        inter = e.nextElement();
        System.out.println(inter.getDisplayName());
        Enumeration<InetAddress> inetAddresses = inter.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
          System.out.printf("InetAddress: %s\n", inetAddress);
        }
      }
    } catch (SocketException ex) {
      Logger.getLogger(Interfaces.class.getName()).log(Level.SEVERE, null,ex);
    }
  }
}
