import java.io.*;
import java.net.*;
import java.util.Scanner;


public class multiServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(1010);
			System.out.print("server on 1010......");
			try{
				while(true){
					Socket s = ss.accept();
					serverHandle instance = new serverHandle(s);
					instance.start();
				}
			}
			catch(IOException e){
				System.out.print("cannot handle require");
			}
		}
		catch(IOException e){
			System.out.print("server run fail");
		}
		
	}
}