package Lesson06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final int PORT=Server.PORT;
    private static final String IP_ADDRESS="Localhost";
    static boolean isActive;

    public static void main(String[] args) {
        try (Socket socket=new Socket(IP_ADDRESS, PORT)){
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("client is connected to server");
            isActive=true;
            Scanner scanner=new Scanner(System.in);
            Thread tOut = new Thread (()->{
                while (isActive) {
                    String str=scanner.nextLine();
                    try {
                        out.writeUTF(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (str.equals("/end")) {
                        isActive=false;
                    }
                }
            });
            Thread tIn = new Thread (()->{
                while (isActive) {
                    String str = null;
                    try {
                        str = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("server: "+str);
                    if (str.equals("/end")) {
                        isActive=false;
                    }
                }
            });
            tIn.setDaemon(true);
            tIn.start();
            tOut.start();
            tOut.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
