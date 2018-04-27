package Udemy.UDPExample1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket=new DatagramSocket(5000);

            while (true){
                byte [] buffer=new byte[50];
                DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
                socket.receive(datagramPacket);
                System.out.println("Text received is "+new String(buffer,0,datagramPacket.getLength()));
            }

        }catch (SocketException s){
            System.out.println(s.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
