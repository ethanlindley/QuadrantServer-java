package base;

import java.io.*;
import java.net.*;

class ServerBase extends PacketHandler {

    public static void main (String args[]) {

        ServerBase x = new ServerBase();
        x.startLoginServer();

    }

    private void startLoginServer() {

        try {
            ServerSocket ls = new ServerSocket(6112);
            Socket s;
            System.out.println("server started @ " + ls.getLocalSocketAddress());
            while (true) {
                try {
                    s = ls.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");

                    System.out.println("new connection incoming from " + s.getInetAddress() + ":" + s.getPort());

                    String data = in.readLine();
                    String x = handleReceivedPacket(data);
                    out.write(x);
                    System.out.println("sending packet to client with data: " + x);
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        catch (IOException e) {
            System.out.println("server unable to start with error " + e);
        }

    }

}
