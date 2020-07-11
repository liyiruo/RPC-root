package com.liyiruo.net;

import com.liyiruo.dispatch.ServiceDispatch;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author liyiruo
 */
public class RPCThreadProcessor implements Runnable {
    private Socket socket;

    public RPCThreadProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            //网络传输过来的对象的流
            ois = new ObjectInputStream(socket.getInputStream());
            //将流转化为对象
            Object reqObj = ois.readObject();
            //将这个对象进行处理
            Object respObj = ServiceDispatch.dispatch(reqObj);
            //发送处理的结果
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(respObj);
            oos.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
