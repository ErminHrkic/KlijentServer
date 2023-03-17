import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class Clijent {
    public static void main(String[] args) {
        int num1,num2,sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
       num1=sc.nextInt();
        System.out.println("Enter second number: ");
        num2=sc.nextInt();
        sc.close();
        sum=num1+num2;
        System.out.println(sum);


        try(Socket socket = new Socket("localhost", 1080);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())){

            bos.write(sum);
            bos.flush();

            String line = br.readLine();
            System.out.println(line);

        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}



