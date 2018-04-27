package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {

        //allocate port for client
        try (ServerSocket serverSocket=new ServerSocket(5000)){
            Socket socket =serverSocket.accept();//establish connection
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                String echoString=input.readLine();
                if(echoString.equals("exit")){
                    break;
                }
                System.out.println(echoString);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
