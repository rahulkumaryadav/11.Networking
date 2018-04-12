package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket=new ServerSocket(5000)){
            Socket socket=serverSocket.accept();//establishes connection with client
            System.out.println("Client is connected");
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner=new Scanner(System.in);


            while (true){
                String echoString=input.readLine();
                System.out.println("Message from client :"+echoString);
                System.out.println("--------------------------------------------------------");
                echoString=scanner.nextLine();
                if(echoString.equals("exit")){
                    break;
                }/*output.println("Echo from server"+echoString);*/
                output.println(echoString);
            }
        }catch (IOException e){
            System.out.println("Server Exception "+e.getMessage());
        }
    }
}
