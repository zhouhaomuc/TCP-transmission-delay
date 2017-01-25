import java.io.*;
import java.net.*;

class UDPServer10000
{
    static String fileInfo1;
    static String fileInfo10;
    static String fileInfo100;
    static String fileInfo10000;
    public static void main(String args[]) throws Exception{
        if(args.length!=1){
            System.out.println("please enter one argument as port!");
        }
        try {
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
        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(args[0]));
        byte[] receiveData = new byte[10];
        byte[] sendData=new byte[10000];
        byte[] send1=new byte[1];
        byte[] send10=new byte[10];
        byte[] send100=new byte[100];
        byte[] send10000=new byte[10000];
        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
           String size = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            if(size.equals("10000")){
                send10000=fileInfo10000.getBytes();
		//DatagramPacket sendPacket=new DatagramPacket(fileInfo1000.getBytes(),fileInfo1000.getBytes().length,IPAddress,port);
        	DatagramPacket sendPacket =new DatagramPacket(send10000, send10000.length, IPAddress, port);

		serverSocket.send(sendPacket);
            }
            DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
