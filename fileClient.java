import java.util.Scanner;
import java.net.*;
import java.io.*;

public class fileClient{
	public static void main(String[] args) {
		try{
			DatagramSocket ds = new DatagramSocket();
			InetAddress address = InetAddress.getByName("127.0.0.1");
			int port = 1010;
			String temp ="hello server 1010";
			byte b[] = temp.getBytes();
			int len = temp.length();
			DatagramPacket outcome = new DatagramPacket(b,len, address,port);
			ds.send(outcome);

			byte b1[] = new byte[64000];
			int len1 = 64000;
			DatagramPacket goinhan = new DatagramPacket(b1,len1);
			ds.receive(goinhan);
			byte b2[] = goinhan.getData();
			int lenn = goinhan.getLength();
			String data = new String(b2,0,lenn);
			System.out.println(data);
		}
		catch(IOException e){
			System.out.print("fail");
		}
	}
}