import java.net.*;

public class TestInet {

  /**
   ** @param args the command line arguments
   **/
  public static void main(String[] args) {
    // TODO code application logic here
    try {
      InetAddress i = InetAddress.getByName("www.univ-reims.fr");
      System.out.println(i);
      System.out.println(i.getHostName());
      System.out.println("Addresse : ");
      byte[] b = i.getAddress();
      for (int k = 0; k < b.length; k++) {
        System.out.println(b[k] + " ");
      }
      System.out.println();
      System.out.println(i.getHostAddress());
    } catch (UnknownHostException e) {
      System.out.println("Error");
    }
  }
}
