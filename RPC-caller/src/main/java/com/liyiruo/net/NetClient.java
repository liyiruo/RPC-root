package com.liyiruo.net;

import java.io.*;
import java.net.Socket;

/**
 * @author liyiruo
 */
public class NetClient {
    public static Object callRemoteService(String host, int port, Object object) {
        //发出网络请求
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Object reqObj = null;

        try {
            Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(object);
            oos.flush();

            InputStream inputStream = socket.getInputStream();
            ois = new ObjectInputStream(inputStream);
            reqObj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reqObj;
    }

}
