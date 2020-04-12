package com.gongmao.controller;

import com.github.pagehelper.PageInfo;
import com.gongmao.pojo.Role;
import com.gongmao.service.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/role") //RestFul webService 代码风格
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping("/findAllRole.do")
    public ModelAndView findAllRole(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "5") Integer size){
        List<Role> roleList=roleService.findAllRole(page,size);

        //创建出分页中的内置对象，将查询到的List传到对象中
        PageInfo pageInfo=new PageInfo(roleList);

        ModelAndView model=new ModelAndView();
        model.addObject("pageInfo",pageInfo);
        model.setViewName("role-list");

        return model;
    }

    @RequestMapping("/findRoleById.do")
    public String findRoleById(int rid,@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "5") Integer size,HttpSession session){
        session.setAttribute("detailRole",roleService.findRoleById(rid));
        session.setAttribute("display","block");
        return "redirect:findAllRole.do?page="+page+"&size="+size;
    }
    //关闭详情提示框
    @RequestMapping("/closeDetail.do")
    public String closeDetail(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "5") Integer size,HttpSession session){
        session.removeAttribute("detailRole");
        session.setAttribute("display","none");
        return "redirect:findAllRole.do?page="+page+"&size="+size;
    }

    @RequestMapping("/addRole.do")
    public String addRole(Role role){roleService.addRole(role);
    return "redirect:findAllRole.do";
    }

    @RequestMapping("/delRoleById.do")
    public String delRoleById(int rid){
        roleService.delRoleById(rid);
        return "redirect:findAllRole.do";
    }
}
