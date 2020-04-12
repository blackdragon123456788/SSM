package com.gongmao.dao;

import com.gongmao.pojo.Role;

import java.util.List;

//数据库交互层
public interface IRoleDao {

    //查询全部角色
    List<Role> findAllRole();

    //通过rid查询角色
    Role findRoleById(int rid);

    void addRole(Role role);

    void delRoleById(int rid);

    //根据用户ID去查询对应Role
    List<Role> findRoleByUserId(int uid);
}
