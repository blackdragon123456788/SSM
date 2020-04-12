package com.gongmao.dao;

import com.gongmao.pojo.UserInfo;

import java.util.List;

//IUserInfoDao - 接口，数据库访问层，直接可以访问数据库
public interface IUserInfoDao {

    //验证登录
    //查询Select
    UserInfo doLogin(String username);

    //全部查询
    List<UserInfo> findAll();

    //增加操作
    void addUser(UserInfo userInfo);

    //删除操作(根据主键ID)
    void delUserById(int id);

    //更新前的查询
    UserInfo updSelUserInfoById(int id);

    //更新操作
    void updUserInfo(UserInfo userInfo);
}
