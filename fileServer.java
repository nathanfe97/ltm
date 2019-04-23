import java.io.*;
import java.net.*;
import java.util.Scanner;

public class fileServer{
	public static void main(String[] args) {
		try{
			DatagramSocket ds = new DatagramSocket(1010);
			byte b[] = new byte[101000];
			while (true) {
                DatagramPacket incoming = new DatagramPacket(b, b.length);
                ds.receive(incoming);
                InetAddress address = incoming.getAddress();
                int port = incoming.getPort();

                String message = new String(incoming.getData(), 0, incoming.getLength());
                System.out.println("Received: " + message);
                DatagramPacket outsending;

                File f = new File("text.txt");
                Scanner sc = new Scanner(f);
                String content="";
                while (sc.hasNextLine()) {
		            content += sc.nextLine()+"\n";
		        }
		        sc.close();

                outsending = new DatagramPacket(content.getBytes(), content.length(),
                        address, port);
                ds.send(outsending);
            }
		}
		catch(IOException e){
			System.out.print("fail");
		}
	}
}