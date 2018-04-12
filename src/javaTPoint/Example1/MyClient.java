package javaTPoint.Example1;

import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",5000);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }
}
