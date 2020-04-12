package com.gongmao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.UUID;

@Controller
@RequestMapping("/uploadController")
public class uploadController {

    private static final String UPLOAD_PATH = "D:/ideaProject/upload";

    //如何去实现参数的封装，  上传的时候，如何给出判断或者验证
    //需要CommonsMultipartResolver,手动配置Spring容器
    @RequestMapping("/upload.do")
    public ModelAndView upload(@RequestParam("myPic") MultipartFile myPic) throws IOException {

        //1.文件在服务器上的存储
        //先生成一个新的文件名
        UUID rid = UUID.randomUUID();
        long uid = rid.getLeastSignificantBits();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date=sdf.format(new Date());
        System.out.println(date);

        //取出后缀名，进行字符串的拼接
        String filename= myPic.getOriginalFilename();
        String suffix= filename.substring(filename.lastIndexOf('.'));
        //        File file=new File(文件地址+文件名+后缀名);
        File file = new File(UPLOAD_PATH + "/" +date+ uid +suffix);

        //throws 和 try..catch的区别,一道java面试题
        myPic.transferTo(file);
        //2、文件地址的回显
        ModelAndView model=new ModelAndView();
        model.setViewName("upload");
        model.addObject("upload_file_path",file.getName());

        //3、给出页面的跳转
        return model;
    }
}
