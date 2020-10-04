package com.happy.service.impl;

import com.happy.common.GeneralException;
import com.happy.common.ServerResponse;
import com.happy.dao.UserDao;
import com.happy.model.User;
import com.happy.service.IUserService;
import com.happy.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    UserDao userDao;

    @Override
    public ServerResponse<String> register(User user) {
        return null;
    }

    private boolean isVaild(User user){
      return false;
    }

    @Override
    public User login(String userName, String passWord) {

        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(passWord)){
            throw new GeneralException("账号或密码为空！");
        }
        String md5PassWord = MD5Util.MD5EncodeUtf8(passWord);
        // 检查账号是不是存在
        int resCount = userDao.checkByName(userName);
        if(resCount == 0){
            throw new GeneralException("用户不存在！");

        }
        User user = userDao.checkLogin(userName, md5PassWord );
        if (user == null) {
            throw new GeneralException("密码不正确");
        }
        user.setPassword(null);
        return user;
    }
}
