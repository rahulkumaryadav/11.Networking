package javaTPoint.Example3Udemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket=new ServerSocket(5000)){
            Socket socket=serverSocket.accept();//establishes connection with client
            System.out.println("Client is connected");
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);

            while (true){
                String echoString=input.readLine();
                if(echoString.equals("exit")){
                    break;
                }output.println("Echo from server"+echoString);
            }
        }catch (IOException e){
            System.out.println("Server Exception "+e.getMessage());
        }
    }
}
