import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class web{
	public static void main(String[] args) {
		int count=0;
		long totalTime=0;
		
			String hName = args[0]; 
			Socket server = null;
			int port = 80;
			
		
			try {
				long startTime=System.currentTimeMillis();
				if (hName != null) {
					server= new Socket(hName, port);
					try {					
						String sumInfo="GET / HTTP/1.1\nHost: "+hName+"\nConnection: close";
						 OutputStream out = server.getOutputStream();
						out.write(sumInfo.getBytes());
	                                 	BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream())); 
	                                 	

	                                	int d = -1 ;
	                                 	out.close();
										server.close();
	                                 //clientOut.close();
	                                 in.close();
						long endTime=System.currentTimeMillis();
						long timePeriod=endTime-startTime;
						System.out.println("Run time： "+timePeriod+"ms");
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	

}


