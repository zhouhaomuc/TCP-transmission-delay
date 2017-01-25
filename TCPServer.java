import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	static String fileInfo1="";
	static String fileInfo10="";
	static String fileInfo100="";
	static String fileInfo1000="";
	static String fileInfo10000="";
	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("please enter one argument as port!");
		}
		try {
			//initialize a server socket, bind port 
			ServerSocket serverSocket=new ServerSocket(Integer.parseInt(args[0]));
			Socket socket=null;
			System.out.println("***TCPserver starts!***");
			try {
				/*fileInfo1[0]="1";
				for(int i=0;i<10;i++){
					fileInfo10[i]="1";
				}
				for(int i=0;i<100;i++){
					fileInfo100[i]="1";
				}
				for(int i=0;i<1000;i++){
					fileInfo1000[i]="1";
				}
				for(int i=0;i<10000;i++){
					fileInfo10000[i]="1";
				}*/
				String path1="1byte";
				BufferedReader reader1 = new BufferedReader(new FileReader(path1));
				String line1 =null;
				fileInfo1 = "";
				while((line1=reader1.readLine())!=null){
					fileInfo1=fileInfo1+line1;
				}
				reader1.close();
				String path10="10bytes";
				BufferedReader reader10 = new BufferedReader(new FileReader(path10));
				String line10 =null;
				fileInfo10 = "";
				while((line10=reader10.readLine())!=null){
					fileInfo10=fileInfo10+line10;
				}
				reader10.close();
				String path100="100bytes";
				BufferedReader reader100 = new BufferedReader(new FileReader(path100));
				String line100 =null;
				fileInfo100 = "";
				while((line10=reader100.readLine())!=null){
					fileInfo100=fileInfo100+line100;
				}
				reader100.close();
				String path1000="1000bytes";
				BufferedReader reader1000 = new BufferedReader(new FileReader(path1000));
				String line1000 =null;
				fileInfo1000 = ""; 
				while((line1000=reader1000.readLine())!=null){
					fileInfo1000=fileInfo1000+line1000;
				}
				reader1000.close();
				String path10000="10000bytes";
				BufferedReader reader10000 = new BufferedReader(new FileReader(path10000));
				String line10000 =null;
				fileInfo10000 = ""; 
				while((line10000=reader10000.readLine())!=null){
					fileInfo10000=fileInfo10000+line10000;
				}
				reader10000.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			//accept client continuosly
			while(true){
				socket=serverSocket.accept();
				InputStream instr=null;
				InputStreamReader inread=null;
				BufferedReader buffread=null;
				String info=null;				
				
				try {
					instr = socket.getInputStream();
					inread = new InputStreamReader(instr);
					buffread = new BufferedReader(inread);
					info = buffread.readLine();
					//if(info!=null){
					//	System.out.println("client input: "+info);
					//}
					socket.shutdownInput();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					if(info.equals("1")){ 
						OutputStream outstr=socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstr);
						//pw.write("1byte:");
						pw.write(fileInfo1);
						//pw.write("\n");
						pw.flush();
		    		
					}
					if(info.equals("10")){ 
						OutputStream outstr=socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstr);
						//pw.write("10bytes:");
						pw.write(fileInfo10);
						//pw.write("\n");
						pw.flush();
		    		
					}
					if(info.equals("100")){ 
						OutputStream outstr=socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstr);
						//pw.write("100bytes");
						pw.write(fileInfo100);
						//pw.write("\n");
						pw.flush();
		    		
					}
					if(info.equals("1000")){ 
						OutputStream outstr=socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstr);
						//pw.write("1000bytes:");
						pw.write(fileInfo1000);
						//pw.write("\n");
						pw.flush();
		    		
					}
					if(info.equals("10000")){ 
						OutputStream outstr=socket.getOutputStream();
						PrintWriter pw=new PrintWriter(outstr);
						//pw.write("10000byte:");
						pw.write(fileInfo10000);
						//pw.write("\n");
						pw.flush();
		    		
						}
					} catch (Exception e) { 
		           		e.printStackTrace(); 
					}
		 		try {
					buffread.close();
					inread.close();
					instr.close();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
