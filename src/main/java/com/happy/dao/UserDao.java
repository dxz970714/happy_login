package com.happy.dao;

import com.happy.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 账号密码是不是正确
     * @param userName
     * @param passWord
     * @return
     */
    User checkLogin(@Param("userName") String userName,@Param("passWord") String passWord);

    int checkByName(@Param("userName")String userName);
}