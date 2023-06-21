import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

class Server{
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            Selector s = Selector.open();
            System.out.println("server start");
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg = br.readLine()) != null) {
                System.out.println("服务端接收到：" + msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}