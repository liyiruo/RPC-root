package com.liyiruo;

import com.liyiruo.api.UserService;
import com.liyiruo.dto.UserDTo;
import com.liyiruo.proxy.ProxyFactory;

/**
 * @author liyiruo
 */
public class Test {
    public static void main(String[] args) {
        UserService userService = ProxyFactory.getProxyInstance(UserService.class);
        UserDTo userDTo = new UserDTo();
        userDTo.setAge(20);
        userDTo.setName("张三");
        UserDTo d = userService.addUser(userDTo);
        System.out.println(d);
    }
}
