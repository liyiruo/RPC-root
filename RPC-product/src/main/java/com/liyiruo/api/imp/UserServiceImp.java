package com.liyiruo.api.imp;

import com.liyiruo.api.UserService;
import com.liyiruo.dto.UserDTo;

import java.util.Random;

/**
 * @author liyiruo
 */
public class UserServiceImp implements UserService {
    @Override
    public UserDTo addUser(UserDTo userDTo) {
        System.out.println(userDTo.toString());
        userDTo.setUserId(String.valueOf(new Random().nextInt(1000000000)));
        return userDTo;
    }
}
