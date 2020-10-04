package com.happy.service;

import com.happy.common.ServerResponse;
import com.happy.model.User;

public interface IUserService {

    /**
     * 账号登录
     * @param userName
     * @param passWord
     * @return
     */
    User login(String userName, String passWord);

    /**
     * 账号注册
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);
}
