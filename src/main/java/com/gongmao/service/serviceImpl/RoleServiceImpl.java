package com.gongmao.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.gongmao.dao.IRoleDao;
import com.gongmao.pojo.Role;
import com.gongmao.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAllRole(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return iRoleDao.findAllRole();
    }

    @Override
    public Role findRoleById(int rid) {
        return iRoleDao.findRoleById(rid);
    }

    @Override
    public void addRole(Role role) {
        iRoleDao.addRole(role);
    }

    @Override
    public void delRoleById(int rid) {
        iRoleDao.delRoleById(rid);
    }
}
