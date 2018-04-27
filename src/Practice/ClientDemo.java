package Practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        try (Socket socket=new Socket("localhost",5000);){
            PrintWriter stringToEcho=new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner=new Scanner(System.in);
            String echoString="";
            while (true){
               echoString= scanner.nextLine();
               stringToEcho.println(echoString);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
