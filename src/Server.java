import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class  Server {
    public static void main(String[] args)  {
        System.out.println("Listening");

        try(ServerSocket serverSocket = new ServerSocket(1080);
            Socket socket = serverSocket.accept();
            BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())){

            String line = bis.readLine();

            bos.write(("Rezultat je:" + line).getBytes());
            bos.flush();

        }catch (IOException ie){
            System.out.println(ie.getMessage());
        }
    }
}












