import java.io.*;
import java.net.*;


class UDPClient
{
   public static void main(String args[]) throws Exception
   {
      if(args.length!=3){
            System.out.println("please enter 3 arguments as hostname, port, file size!");
      }
	int i=0;
	long totalTime=0;
	
	InetAddress IPAddress = InetAddress.getByName(args[0]);
    byte[] sendData = args[2].getBytes();
    int size=Integer.parseInt(args[2]);
    byte[] receiveData=new byte[size];
	while(true){
     long startTime=System.nanoTime();
      DatagramSocket clientSocket = new DatagramSocket();
      
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(args[1]));
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      clientSocket.close();
      long runTime=System.nanoTime()-startTime;
	if(i>=100){
	System.out.println("run time: "+runTime/1000+"us");
	totalTime=totalTime+runTime;
	}
	i++;
	if(i>=1000){
		System.out.println("Average time: "+totalTime/900000+"us");
		break;
	}
	}
   }
}
