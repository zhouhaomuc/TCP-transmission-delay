import java.io.*;
import java.net.*;

class UDPServer
{
    static String fileInfo1;
    static String fileInfo10;
    static String fileInfo100;
    static String fileInfo1000;
    public static void main(String args[]) throws Exception{
        if(args.length!=1){
            System.out.println("please enter one argument as port!");
        }
        try {
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
            String path100="10bytes";
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
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(args[0]));
        byte[] receiveData = new byte[10];
        byte[] sendData=new byte[1000];
        byte[] send1=new byte[1];
        byte[] send10=new byte[10];
        byte[] send100=new byte[100];
        byte[] send1000=new byte[1000];
        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
           String size = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            if(size.equals("1")){
                send1=fileInfo1.getBytes();
                DatagramPacket sendPacket =new DatagramPacket(send1, send1.length, IPAddress, port);

		//DatagramPacket sendPacket=new DatagramPacket(fileInfo1.getBytes(),fileInfo1.getBytes().length,IPAddress,port);
		serverSocket.send(sendPacket);
            }
            if(size.equals("10")){
                send10=fileInfo10.getBytes();
		//DatagramPacket sendPacket =new DatagramPacket(fileInfo10.getBytes(),fileInfo10.getBytes().length,IPAddress,port);
       		DatagramPacket sendPacket =new DatagramPacket(send10, send10.length, IPAddress, port);

		serverSocket.send(sendPacket);
            }
            if(size.equals("100")){
                send100=fileInfo100.getBytes();
		//DatagramPacket sendPacket=new DatagramPacket(fileInfo100.getBytes(),fileInfo100.getBytes().length,IPAddress,port);
                DatagramPacket sendPacket =new DatagramPacket(send100, send100.length, IPAddress, port);

		serverSocket.send(sendPacket);
            }
            if(size.equals("1000")){
                send1000=fileInfo1000.getBytes();
		//DatagramPacket sendPacket=new DatagramPacket(fileInfo1000.getBytes(),fileInfo1000.getBytes().length,IPAddress,port);
        	DatagramPacket sendPacket =new DatagramPacket(send1000, send1000.length, IPAddress, port);

		serverSocket.send(sendPacket);
            }
            DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
