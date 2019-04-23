import java.net.*;
import java.io.*;
import java.util.Scanner;


public class serverHandle extends Thread{
	private Socket s;
	Scanner sc = new Scanner(System.in);

	public serverHandle(Socket s){
		this.s = s;
	}
	public void run(){
		try{
			while(true){
				InputStream in = this.s.getInputStream();
				OutputStream out = this.s.getOutputStream();
				int len = in.read();
				if(len==0){
					this.s.close();
					break;
				}
				else{
					byte[] aa = new byte[len];
					for(int i =0;i<len;i++){
						aa[i] = (byte)in.read();
					}
					String temp = new String(aa);
					temp = temp.trim();
					temp = temp.substring(temp.lastIndexOf(" ")+1);
					out.write(temp.length());
					for(int i=0;i<temp.length();i++){
						out.write(temp.charAt(i));
					}
				}
			}
			
		}
		catch (IOException e) {
			System.out.print("fail");
		}
	}
}