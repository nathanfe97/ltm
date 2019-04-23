import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			Socket s = new Socket("localhost",1010);
			while(true){
				OutputStream out = s.getOutputStream();
				InputStream in = s.getInputStream();
				String fullname = sc.nextLine(); 
				if(fullname.length()==0){
					out.write(0);
					break;
				}
				else{
					out.write(fullname.length());
					for (int i =0;i< fullname.length() ;i++ ) {
						out.write(fullname.charAt(i));
					}
					int len = in.read();
					byte[] aa = new byte[len];
					for(int i =0;i<len;i++){
						aa[i] = (byte)in.read();
					}
					String aaa = new String(aa);
					System.out.println(aaa);
					continue;
				}

			}
		}
		catch(IOException e){
			System.out.print("fail");
		}
	}
}