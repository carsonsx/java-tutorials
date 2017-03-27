package com.carsonsx.springchat;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by carsonsx on 18/03/2017.
 */
public class NetServer {


    public static void startServer() throws Exception {

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(8888));
        Socket socket = ss.accept();

        while(true) {


            socket.getInputStream().read();


        }


    }

}
