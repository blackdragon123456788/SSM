package com.gongmao.controller;

import com.github.pagehelper.PageInfo;
import com.gongmao.pojo.UserInfo;
import com.gongmao.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * UserInfoController - 表现层/控制层
 * */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

//    @RequestMapping("/doLogin.do")
//    public String doLogin(String username, String password, HttpSession session) {
//        //1、调用service层，查询得到结果,  userInfoService.doLogin(username)后-操作--》Ctrl+Alt+V补全返回值
//        UserInfo userInfo = userInfoService.doLogin(username);
//
//        //2、判断
//        if (userInfo != null) {
//            if (userInfo.getPassword().equals(password)) {
//                //传输用户
//                session.setAttribute("userInfo",userInfo);
//                //设置跳转路径
//                return  "main";
//            } else {
//                //传输错误信息
//                session.setAttribute("errors","密码错误，登录失败！");
//                return  "../login";
//            }
//        } else {
//            session.setAttribute("errors","用户名不存在，请重新输入！");
//            return "../login";
//        }
//    }

    //全部查询
    //所有需要返回数据到页面显示的全部都需要封装到ModelAndView中
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1")Integer page,
                                @RequestParam(defaultValue = "5")Integer size){
        //调用service中的方法，得到查询结果
        List<UserInfo> userInfoList=userInfoService.findAll(page,size);

        //把得到的数据放到PageInfo中
        PageInfo pageInfo=new PageInfo(userInfoList);
        ModelAndView model=new ModelAndView();
        model.addObject("pageInfo",pageInfo);
        model.setViewName("user-list");
        return model;
    }

    //增加
    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
        //增加成功，返回重新查询
        return "redirect:findAll.do";
    }

    //删除
    @RequestMapping(value="/delUser.do")
    public String delUserById(int id){
        userInfoService.delUserById(id);
        return "redirect:findAll.do";
    }

    //更新前的查询
    @RequestMapping("/updSelUserById.do")
    public ModelAndView updSelUserById(int id){
       UserInfo userInfo= userInfoService.updSelUserById(id);

       ModelAndView model=new ModelAndView();
       model.addObject("userInfo",userInfo);
       model.setViewName("/user-update");

       return model;
    }

    //修改
    @RequestMapping("/updUserInfo.do")
    public String updUserInfo(UserInfo userInfo){
        userInfoService.updUserInfo(userInfo);
        return "redirect:findAll.do";
    }

    //注销
    @RequestMapping("/doLogout.do")
    public String doLogout(HttpSession session){
        session.removeAttribute("userInfo");

        return "redirect:doLogin.do" ;
    }
}

