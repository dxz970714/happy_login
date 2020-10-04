package com.happy.controller;

import com.happy.common.Const;
import com.happy.common.GeneralException;
import com.happy.common.ServerResponse;
import com.happy.model.User;
import com.happy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService iUserService;


    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register" ,method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> register (User user){
        return null;
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     * @param session
     * @return
     */
    @RequestMapping(value = "/login" ,method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> logout (String userName, String passWord, HttpSession session){

        User user = null;
        try{
            user = iUserService.login(userName,passWord);
        }catch(GeneralException e){
            return ServerResponse.createByErrorMsg(e.getMessage());
        }
        // 如果返回状态码为成功，将用户信息保存
        session.setAttribute(userName,user);
        return ServerResponse.createBySuccess(user);
    }

    /**
     * 退出登录
     * @param userName
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout" ,method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login (String userName, HttpSession session){
        session.removeAttribute(userName);
        return ServerResponse.createByErrorMsg("退出登录成功！");
    }

}
