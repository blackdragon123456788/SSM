package com.gongmao.service;

import com.gongmao.pojo.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole(Integer page,Integer size);
    Role findRoleById(int rid);
    void addRole(Role role);
    void delRoleById(int rid);

}
