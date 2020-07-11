package com.liyiruo.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author liyiruo
 */
public class NetServer {

    public static final ExecutorService THREAD_POOL = newFixedThreadPool(100);
    public static void startup(int port) throws IOException {
        ServerSocket socket = new ServerSocket(port);

        while (true) {
            Socket accept = socket.accept();
            THREAD_POOL.submit(new RPCThreadProcessor(accept));
        }
    }

    public static void main(String[] args) {
        try {
            NetServer.startup(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
