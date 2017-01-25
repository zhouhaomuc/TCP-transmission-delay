import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class TCPClient {

	public static void main(String[] args) {
		if(args.length!=3){
			System.out.println("please enter 3 arguments as server address, port, file size!");
		}
		int i=0;
		long totalTime=0;
		while(true){
		try {
			long startTime=System.nanoTime();
			InetAddress IP = InetAddress.getByName(args[0]);
			Socket socket=new Socket(IP,Integer.parseInt(args[1]));
			OutputStream outstr=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(outstr);
			pw.write(args[2]);
			pw.flush();
			socket.shutdownOutput();	//shutdown output
			InputStream instr=socket.getInputStream();
			InputStreamReader inread=new InputStreamReader(instr);
			BufferedReader buffread=new BufferedReader(inread);
			String recinfo=null;
			while(null!=(recinfo=buffread.readLine())){
			}
			socket.shutdownInput();
			pw.close();
			outstr.close();
			socket.close();
			long runtime=System.nanoTime()-startTime;
			if(i>=100){ 
				totalTime=totalTime+runtime;			 
				System.out.println("Run time： "+runtime/1000+"ns");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
		if(i>=200){
			System.out.println("Average time is: "+totalTime/100000+"us");
			break;
		}
		}
		
	}

}
