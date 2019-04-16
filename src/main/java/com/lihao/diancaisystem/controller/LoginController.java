package com.lihao.diancaisystem.controller;

import com.lihao.diancaisystem.po.Response;
import com.lihao.diancaisystem.po.SuccessResponse;
import com.lihao.diancaisystem.po.User;
import com.lihao.diancaisystem.service.UserService;
import com.lihao.diancaisystem.util.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 登录接口
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/login" , method = RequestMethod.GET)
    public  String loginPage(){
        return "login";
    }

    @RequestMapping(value ="/home/index",method = RequestMethod.GET)
    public String indexPage(){return "loginSuccess";}
    /**
     * 登录接口
     * @param user
     * @param result
     * @param request
     * @return
     */
    @PostMapping(value = "/user/loginin")
    @ResponseBody
    public Response checkUser(@Validated({User.Add.class}) User user , BindingResult result, HttpServletRequest request){
        System.out.println("进来了吗？");
/*        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError)list.get(0);
            System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
            return;
        }*/
        User userLogin = userService.getUserByUserName(user.getName());
        if (userLogin == null){
            return  new SuccessResponse().withData("用户名密码错误");
        }
        if(!userLogin.getPassword().equals(user.getPassword())){
            return  new SuccessResponse().withData("用户名密码错误");
        }
        HttpSession session =request.getSession();
        String code = user.getCode();
        code = code.toLowerCase();
        String imageCode = session.getAttribute("imageCode")+"";
        imageCode = imageCode.toLowerCase();
        if (!imageCode.equals(code)){
            return  new SuccessResponse().withData("验证码错误");
        }
        session.setAttribute("user",user);
        return  new SuccessResponse().withData("登录成功");
    }
    /**
     * 验证码接口
     * @param servletResponse
     * @throws IOException
     * @param httpServletRequest
     */
    @RequestMapping(value = "/user/code",method = RequestMethod.GET)
    public void getCode(HttpServletResponse servletResponse , HttpServletRequest httpServletRequest) throws IOException {
        HttpSession session = httpServletRequest.getSession();
        Object[] objects = VerifyUtil.createImage();
        session.setAttribute("imageCode",objects[0]);
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage)objects[1];
        servletResponse.setContentType("image/png");
        OutputStream outputStream = servletResponse.getOutputStream();
        ImageIO.write(image , "png",outputStream);
    }
    public void hello(){

    }

}
