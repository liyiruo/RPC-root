package com.liyiruo.dispatch;

import com.liyiruo.dto.RPCCommonReqDTO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyiruo
 */
public class ServiceDispatch {

    /**
     * 做服务的分发
     *
     * @param reqObj 传入一个对象
     * @return 返回一个对象
     */
    public static Object dispatch(Object reqObj) {
        RPCCommonReqDTO rpcCommonReqDTO = (RPCCommonReqDTO) reqObj;
        String methodName =rpcCommonReqDTO.getMethodName();
        String classpath = rpcCommonReqDTO.getClasspath();
        Object[] args = rpcCommonReqDTO.getArgs();

        Class[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        Object object = null;
        try {
            //通过反射调用方法
            Class<?> clazz = Class.forName(classpath);
            Object o = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(methodName, types);
            //方法调用
            object = method.invoke(o, args);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
