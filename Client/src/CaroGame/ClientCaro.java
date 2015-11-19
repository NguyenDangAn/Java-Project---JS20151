package CaroGame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientCaro {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
            // TODO add your handling code here:
                    Socket ClientSocket = new Socket("localhost", 8888); 
            System.out.println("Ket noi thanh cong!");
            System.out.println(ClientSocket.getInetAddress());
            System.out.println(ClientSocket.getLocalSocketAddress());
            System.out.println(ClientSocket.getLocalPort());
            System.out.println(ClientSocket.getLocalAddress());
            
            
            
            //Tạo luồng nhận dữ liệu từ bàn phím
            DataInputStream inFromUser = new DataInputStream(System.in); 
            //Tạo luồng nhận dữ liệu từ Server
            DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream()); 
            //Tạo luồng gửi dữ liệu lên Server
            DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream()); 
        
        //Login at server
        LoginCaro logincaro = new LoginCaro(inFromServer, outToServer);

	}

}
