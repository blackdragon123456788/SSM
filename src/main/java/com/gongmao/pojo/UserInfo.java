package com.gongmao.pojo;

import java.util.List;

/**
 * UserInfo -实体类，映射数据库字段，字段建议一致。
 * */
public class UserInfo {
    //在实体类中为什么要进行封装？
    //Spring 容器，去访问对象成员属性的时候必须是封装类型的，不然就没办法访问！

    private int id;             //用户ID
    private String username;    //用户名
    private String password;    //用户密码
    private List<Role> roleList; //角色列表

    //构造方法
    public UserInfo (){}    //无参构造
    //有参构造
    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    //get set 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
