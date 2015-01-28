import java.net.*; 
import java.io.*;

public class DayTimeClient {
  InetAddress server;
  public static void main(String(] args) {
    Socket s = null; 
    try {
      s = new Socket("time.ien.i",13);
      InputStream is = s.getInputStream(); 
      InputStreamReader isr = new InputStreamReader(is); 
      BufferedReader br = new BufferedReader(isr); 
      StringBuffer sb = new StringBuffer();
      String theLine;
      while ((theLine = br.readLine()) != null) { sb. append(theLine + '*\r\n' );
        System.out.println(sb.toString());
      }
    }
    catch (IOException ex) {
      System.out.println("erreur");
    }
  }
}
