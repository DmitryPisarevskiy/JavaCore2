package Lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static final int PORT = 7777;
    private static boolean isActive;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server has been started!");
            try (Socket socket = server.accept()) {
                System.out.println("Client was connected");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner scanner=new Scanner(System.in);
                isActive=true;
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
                Thread tIn = new Thread(()-> {
                    while (isActive) {
                        String str = null;
                        try {
                            str = in.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("client: "+str);
                        if (str.equals("/end")) {
                            isActive=false;
                        }
                    }
                });
                tIn.setDaemon(true);
                tOut.start();
                tIn.start();
                tOut.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
