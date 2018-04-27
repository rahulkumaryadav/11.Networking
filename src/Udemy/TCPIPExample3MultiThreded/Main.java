package Udemy.TCPIPExample3MultiThreded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket=new ServerSocket(5000)){
            while (true) {
                Socket socket=serverSocket.accept();
                Echoer echoer=new Echoer(socket);
                echoer.start();
            }
        }catch (IOException e){
            System.out.println("Server Exception "+e.getMessage());
        }
    }
}
