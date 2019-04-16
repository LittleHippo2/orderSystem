package com.lihao.diancaisystem.serviceImpl;

import com.lihao.diancaisystem.dao.UserMapper;
import com.lihao.diancaisystem.po.User;
import com.lihao.diancaisystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectUser() {
     List<User> userList = userMapper.selectUser();
        System.out.println("nihao");
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
       User user =  userMapper.getUserById(id);
        return user;
    }

    @Override
    public User getUserByUserName(String userName){
        User user = userMapper.getUserByUserName(userName);
        return  user;
    }
}
