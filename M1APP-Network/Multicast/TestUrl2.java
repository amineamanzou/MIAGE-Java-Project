import java.io.*; 
import java.net.*; 

class TestUrl2{
  public static void main(String arg[]){
    String l = null;
    Socket soc = null;
    BufferedReader lect = null;
    PrintWriter ecr = null;
    try{
      soc = new Socket("cosy.univ-reims.fr",80);
    }
    catch(UnknownHostException e){
      System.out.println("hote inconnu !!! \n");
    }
    catch(IOException e){
        System.out.println("erreur a l'ouverture de la socket III \n");
    }
    try{
        lect = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
        ecr = new PrintWriter(new OutputStreamWriter(soc.getOutputStream())); 
    }
    catch(IOException e){
        System.out.println("erreur a l'ouverture de la socket ill \n");
    }
    ecr.print("GET /LProCMSII/ HTTP/1.0\n\n");
    ecr.flush();
    try {
      for(l=null;(l=lect.readLine())!=null;){
        System.out.println(l);
      } 
    lect.close(); 
    ecr.close(); 
    soc.close();
    }catch(IOException e){
      System.out.println("Erreur a l'ouverture de la socket ! \n");   
    }
  }
}
