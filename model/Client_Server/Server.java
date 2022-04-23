package model.Client_Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{
        ServerSocket server = new ServerSocket(6666);
        Socket s = server.accept();
        
        DataInputStream input = new DataInputStream(s.getInputStream());
        
        DataOutputStream output = new DataOutputStream(s.getOutputStream());  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String text="", text2="";  
        while(!text.equals("stop")){  
        text=input.readUTF();  
        System.out.println("From Client: "+ text);  
        text2=reader.readLine();  
        output.writeUTF(text2);  
        output.flush();  
        }  
        input.close();  
        s.close();  
        server.close(); 
        
        }catch(Exception e){System.out.println(e);
        }
        }
}
