package com.lihao.diancaisystem.controller;

import com.lihao.diancaisystem.po.User;
import com.lihao.diancaisystem.service.UserService;
import com.lihao.diancaisystem.util.VerifyUtil;
import com.lihao.diancaisystem.util.WorkInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class UserController {


    private  final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/hello" , method = RequestMethod.GET)
    public  String getUserList(){
        return "hello";
    }




    @RequestMapping(value ="/user/hello")
    public @ResponseBody String seyHello(@RequestParam(name = "name") String name){
        return "hello";
    }

    @PostMapping(value ="/user/updateFile")
    @ResponseBody
    public String getFile(@RequestParam("files") MultipartFile  file) throws  Exception{
        if (!file.isEmpty()){
            String fileName1 = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            logger.info("第一个文件的名字是："+fileName1);
            System.out.println(fileName1);
            return  "SUCCESS";
        }
        return "failure";
    }

    @PostMapping(value = "/user/uploadfiles")
    @ResponseBody
    public String getFiles(HttpServletRequest request){

        List<MultipartFile> fileList = ((MultipartHttpServletRequest)request).getFiles("files");
            for(int i = 0; i<fileList.size() ;i++){
                MultipartFile file = fileList.get(i);
                if (file.isEmpty()){
                    return "上传第"+(i++)+"个文件错误";
                }
                String fileName = file.getOriginalFilename();

                System.out.println("第"+(i++)+"个文件的名字是："+fileName);
            }
            return "success";
    }


}
