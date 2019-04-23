import java.io.*;
import java.net.*;

public class serverChat{
	public static void main(String[] args) {
		try{
			DatagramSocket ds = new DatagramSocket(1010);
			byte b[] = new byte[50];
			while(true){
				DatagramPacket dp = new DatagramPacket(b,b.length);
				serverChatHandle instance = new serverChatHandle(ds,dp);
				instance.start();
			}
		}
		catch(IOException e){
			System.out.print("fail");
		}
	}
}