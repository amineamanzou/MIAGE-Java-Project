import java.net.*;
import java.io.*;
import java.text.*;
import java.util.Date;

public class UDPServer {

	private static byte[] concatenateByteArrays(byte[] a, byte[] b) {
	    byte[] result = new byte[a.length + b.length]; 
	    System.arraycopy(a, 0, result, 0, a.length); 
	    System.arraycopy(b, 0, result, a.length, b.length); 
	    return result;
	} 

	public static void main(String args[]) {
   		DatagramSocket aSocket = null;
   		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try
    	{
			// create socket at agreed port
			aSocket = new DatagramSocket(6464);
			while(true){
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				Date now = new Date();
				String date = "["+dateFormat.format(now)+"]";
				buffer = concatenateByteArrays(date.getBytes(),request.getData());
				DatagramPacket reply = new DatagramPacket(buffer,
															buffer.length,
															request.getAddress(),
															request.getPort()
														);
				aSocket.send(reply);
				
				System.out.println("["+ dateFormat.format(now) +"]");
				System.out.println("From: " + request.getAddress().toString());
				System.out.println("Message: " + new String(request.getData(),"UTF-8")); 
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