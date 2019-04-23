import java.util.Scanner;
import java.io.*;
import java.net.*;

public class serverChatHandle extends Thread{
	private DatagramSocket socket;
	private DatagramPacket packet;

	public serverChatHandle(DatagramSocket ds, DatagramPacket dp){
		this.socket =ds;
		this.packet = dp;
	}
	public void run(){
		try{
			socket.receive(packet);
			int port = packet.getPort();
			int len = packet.getLength();
			InetAddress address = packet.getAddress();
			byte b1[] = packet.getData();
			String b2 = new String(b1,0,len);
			System.out.print(b2);
			b1 = null;
			b2 = null;
		}
		catch(IOException e){
			System.out.print("fail");
		}
	}
}