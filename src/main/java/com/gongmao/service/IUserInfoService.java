package com.gongmao.service;

import com.gongmao.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * IuserInfoService - 业务逻辑层
 * */
public interface IUserInfoService extends UserDetailsService {

    UserInfo doLogin(String username);

    List<UserInfo> findAll(Integer page,Integer size);

    void addUser(UserInfo userInfo);

    void delUserById(int id);

    UserInfo updSelUserById(int id);

    void updUserInfo(UserInfo userInfo);
}
