import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args){
        new ChatClient().runClient();

    }

    public void runClient() {

        try
        {
            Socket socket = new Socket("localhost",1337);
            System.out.println("er forbundet til server ");

            Scanner scanner = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());


            while (true) {
                try{
                    System.out.println("Server: " + dis.readUTF());
                    System.out.print("you: ");
                    String tosend = scanner.nextLine();
                    dos.writeUTF(tosend);
                }
                catch (IOException ex){
                    ex.printStackTrace();

                    socket.close();
                    scanner.close();
                    dis.close();
                    dos.close();
                }
            }

         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
