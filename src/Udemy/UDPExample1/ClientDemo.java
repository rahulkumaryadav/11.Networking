package Udemy.UDPExample1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            InetAddress address=InetAddress.getLocalHost();
            DatagramSocket datagramSocket=new DatagramSocket();
            Scanner scanner=new Scanner(System.in);
            String echoString;
            do {
                System.out.println("Enter String to be echo");
                echoString=scanner.nextLine();
                byte[] buffer=echoString.getBytes();
                DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length,address,5000);
                datagramSocket.send(datagramPacket);
            }while (!echoString.equals("exit"));
        }catch (SocketTimeoutException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
