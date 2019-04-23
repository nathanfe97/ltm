import java.io.*;
import java.net.*;
import java.util.Scanner;

public class clientChat{
	public static void main(String[] args) {
	try{
		Scanner sc = new Scanner(System.in);
		System.out.print("Yourname: "); String name = sc.nextLine();
		String content = name +" has connected\n------------------------------\n";
		DatagramSocket socket = new DatagramSocket();
		byte b[] = content.getBytes();
		int port = 1010;
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(b,b.length,address,port);
		socket.send(packet);
		String message="";
		while(true){
			message = sc.nextLine();
			content = name+": "+message+"\n";
			b = content.getBytes();
			packet = new DatagramPacket(b,b.length,address,port);
			socket.send(packet);
			if(message=="bye")break;
		}
	}
	catch(IOException e){
		System.out.print("fail");
	}
	}
}