package com.liyiruo.api;

import com.liyiruo.dto.UserDTo;

/**
 *
 */
public interface UserService {

    /**
     * @param userDTo 参数
     * @return UserDTo
     */
    UserDTo addUser(UserDTo userDTo);
}
