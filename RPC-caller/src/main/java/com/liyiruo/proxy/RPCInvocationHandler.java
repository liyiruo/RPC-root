package com.liyiruo.proxy;

import com.liyiruo.dto.RPCCommonReqDTO;
import com.liyiruo.net.NetClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liyiruo
 */
public class RPCInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RPCCommonReqDTO rpcCommonReqDTO = new RPCCommonReqDTO();
        rpcCommonReqDTO.setArgs(args);
        rpcCommonReqDTO.setMethodName(method.getName());
        rpcCommonReqDTO.setClasspath("com.liyiruo.api.imp.UserServiceImp");

        System.out.println(method);
        for (Object arg : args) {
            System.out.println(arg);
        }

        return NetClient.callRemoteService("localhost",9999,rpcCommonReqDTO);
    }
}
