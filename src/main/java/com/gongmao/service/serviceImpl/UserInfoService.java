package com.gongmao.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.gongmao.dao.IRoleDao;
import com.gongmao.dao.IUserInfoDao;
import com.gongmao.pojo.Role;
import com.gongmao.pojo.UserInfo;
import com.gongmao.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserInfoService implements IUserInfoService {


    //除了 @Autowired,也可以通过对象名注入
    //    @Resource(name="u1")

    @Autowired
    private IUserInfoDao iUserInfoDao;

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public UserInfo doLogin(String username) {

        return iUserInfoDao.doLogin(username);
    }

    @Override
    public List<UserInfo> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return iUserInfoDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        iUserInfoDao.addUser(userInfo);
    }

    @Override
    public void delUserById(int id) {
        iUserInfoDao.delUserById(id);
    }

    @Override
    public UserInfo updSelUserById(int id) {
        return iUserInfoDao.updSelUserInfoById(id);
    }

    @Override
    public void updUserInfo(UserInfo userInfo) {
        iUserInfoDao.updUserInfo(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        //根据姓名查询到当前登录的用户
        UserInfo userInfo=iUserInfoDao.doLogin(username);
        //根据当前登录的用户ID，去查询到所属的角色
        List<Role> roleList =iRoleDao.findRoleByUserId(userInfo.getId());
        userInfo.setRoleList(roleList);

        //得到想要的信息之后，就要交给Security去处理了
        //因为这里要用到security的User类，所以在用户实体类使用UserInfo这个名字，避免出现错误
        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(roleList));

        return user;

    }
    //鼠标光标GrantedAuthority类，再Ctrl+alt+B，就可以看到GrantedAuthority的三个方法，我们要用的是SimpleGrantedAuthority类
    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list=new ArrayList<>();

        for(Role role:roleList){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRname()));
        }
        return list;
    }
}
